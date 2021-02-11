package ca.interview.rbc.transactions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class TestTransactionNotification {

	final static int CONCURRENT_THREADS = 1000;
	final static int NUMBER_OF_TIMES = 1000;

	final static int PROCESSING_THREADS = 4;

	TransactionManager tmanager = new TransactionManager();
	
	Object publishTimeMonitor = new Object();
	Object processTimeMonitor = new Object();
	Object threadTimeMonitor = new Object();

	@Test
	public void testSequential() {
		for( int processors = PROCESSING_THREADS; processors > 0 ; --processors) {
			tmanager.transactionCounter = 0;

			System.out.printf("\nSEQUENTIAL NOTIFICATIONS with contention of %,d threads %,d times\n", CONCURRENT_THREADS, NUMBER_OF_TIMES);
	
			CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_THREADS);
			CountDownLatch latch = new CountDownLatch(CONCURRENT_THREADS);
	
			int[] processTime = new int[] {0};
			long[] threadTime = new long[] {Long.MAX_VALUE, 0};
	
			long startTest = System.currentTimeMillis();
	
			for (int i = 0, maxi = CONCURRENT_THREADS; i < maxi; ++i) {
				new Thread(() -> {
					long startThread = System.currentTimeMillis();
					try {
						for (int j = 0, maxj = NUMBER_OF_TIMES; j < maxj; ++j) {
							barrier.await();
							long[] timing = tmanager.processSequentially(new Transaction(), startTest);
							synchronized( processTimeMonitor ) {
								processTime[0] += timing[1]-timing[0];;
							}
						}
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
					long endThread = System.currentTimeMillis();
					synchronized( threadTimeMonitor ) {
						// The earliest thread start
						threadTime[0] = Math.min(threadTime[0], startThread);
						// The oldest thread end
						threadTime[1] = Math.max(threadTime[1], endThread);
					}
				}).start();
			}
	
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			long endTest = System.currentTimeMillis();
	
			System.out.printf("                  Test time = %,d mls\n", endTest - startTest);
			System.out.printf("            Processing time = %,d mls\n", processTime[0]);
			System.out.printf("                Thread time = %,d mls\n", threadTime[1]-threadTime[0]);
			System.out.printf("     Number of transactions = %,d\n", tmanager.transactionCounter);
			System.out.printf("    Number of notifications = %,d\n", tmanager.notificationCounter);
			System.out.printf("Number of notified accounts = %,d (%,d)\n", tmanager.notifiedAccounts.size(), Transaction.TOTAL_ACCOUNTS);
	
			assertEquals(0, CONCURRENT_THREADS * NUMBER_OF_TIMES - tmanager.transactionCounter);
		}
	}

	@Test
	public void testConcurrent() {
		for( int processors = PROCESSING_THREADS; processors > 0 ; --processors) {
			tmanager.transactionCounter = 0;
			
			System.out.printf("\nCONCURRENT NOTIFICATIONS with contention of %,d threads %,d times\n", CONCURRENT_THREADS, NUMBER_OF_TIMES);
	
			CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_THREADS);
			CountDownLatch latch = new CountDownLatch(CONCURRENT_THREADS);
	
			int[] processTime = new int[] {0};
			long[] threadTime = new long[] {Long.MAX_VALUE, 0};
	
			long startTest = System.currentTimeMillis();
	
			for (int i = 0, maxi = CONCURRENT_THREADS; i < maxi; ++i) {
				new Thread(() -> {
					long startThread = System.currentTimeMillis();
					try {
						for (int j = 0, maxj = NUMBER_OF_TIMES; j < maxj; ++j) {
							barrier.await();
							long[] timing = tmanager.processConcurrently(new Transaction(), startTest);
							synchronized( processTimeMonitor ) {
								processTime[0] += timing[1] - timing[0];
							}
						}
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
					long endThread = System.currentTimeMillis();
					synchronized( threadTimeMonitor ) {
						// The earliest thread start
						threadTime[0] = Math.min(threadTime[0], startThread);
						// The oldest thread end
						threadTime[1] = Math.max(threadTime[1], endThread);
					}
				}).start();
			}
	
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			long endTest = System.currentTimeMillis();
	
			System.out.printf("                  Test time = %,d mls\n", endTest - startTest);
			System.out.printf("            Processing time = %,d mls\n", processTime[0]);
			System.out.printf("                Thread time = %,d mls\n", threadTime[1]-threadTime[0]);
			System.out.printf("     Number of transactions = %,d\n", tmanager.transactionCounter);
			System.out.printf("    Number of notifications = %,d\n", tmanager.notificationCounter);
			System.out.printf("Number of notified accounts = %,d (%,d)\n", tmanager.notifiedAccounts.size(), Transaction.TOTAL_ACCOUNTS);
	
			assertEquals(0, CONCURRENT_THREADS * NUMBER_OF_TIMES - tmanager.transactionCounter);
		}
	}


	@Test
	public void testLmax() throws InterruptedException {
		for( int processors = PROCESSING_THREADS; processors > 0 ; --processors) {
			tmanager.transactionCounter = 0;

			System.out.printf("\nLMax NOTIFICATIONS with %d processors and contention of %,d threads %,d times\n", processors, CONCURRENT_THREADS, NUMBER_OF_TIMES);

			CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_THREADS);
			CountDownLatch latch = new CountDownLatch(CONCURRENT_THREADS);
	
		    ExecutorService executor = Executors.newFixedThreadPool(processors+1);
	
		    @SuppressWarnings("deprecation")
			Disruptor<Transaction>  disruptor = new Disruptor<>(new TransactionFactory(), 16384, executor, ProducerType.SINGLE, new BlockingWaitStrategy());
	        
		    TransactionEventProcessor procs[] = new TransactionEventProcessor[processors];
		    TransactionResultReclaimer result = new TransactionResultReclaimer();
	 
	        for (int i = 0; i < procs.length; i++) {
	            procs[i] = new TransactionEventProcessor();
	        }
	        disruptor.handleEventsWithWorkerPool(procs).thenHandleEventsWithWorkerPool(result);
	
	        disruptor.start();
			
		    RingBuffer<Transaction> ringBuffer = disruptor.getRingBuffer();
			
			int[] publishTime = new int[] {0};
			long[] threadTime = new long[] {Long.MAX_VALUE, 0};
	
			long startTest = System.currentTimeMillis();
	
			for (int i = 0, maxi = CONCURRENT_THREADS; i < maxi; ++i) {
				new Thread(() -> {
					long startThread = System.currentTimeMillis();
					try {
						for (int j = 0, maxj = NUMBER_OF_TIMES; j < maxj; ++j) {
							barrier.await();
							long[] timing = tmanager.publishLmaxSynch(ringBuffer, startTest);
							synchronized( publishTimeMonitor ) {
								publishTime[0] += timing[1]-timing[0];;
							}
						}
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
					long endThread = System.currentTimeMillis();
					synchronized( threadTimeMonitor ) {
						// The earliest thread start
						threadTime[0] = Math.min(threadTime[0], startThread);
						// The oldest thread end
						threadTime[1] = Math.max(threadTime[1], endThread);
					}
				}).start();
			}
	
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			while( processedCount < tmanager.transactionCounter ) {
	            TimeUnit.MICROSECONDS.sleep(10);
			}
	
			disruptor.shutdown();
			executor.shutdownNow();
			
			long endTest = System.currentTimeMillis();
	
			System.out.printf("                  Test time = %,d mls\n", endTest - startTest);
			System.out.printf("               Publish time = %,d mls\n", publishTime[0]);
			System.out.printf("            Processing time = %,d mls\n", processTimeLmax);
			System.out.printf("                Thread time = %,d mls\n", threadTime[1]-threadTime[0]);
			System.out.printf("     Number of transactions = %,d\n", tmanager.transactionCounter);
			System.out.printf("    Number of notifications = %,d\n", tmanager.notificationCounter);
			System.out.printf("Number of notified accounts = %,d (%,d)\n", tmanager.notifiedAccounts.size(), Transaction.TOTAL_ACCOUNTS);
	
			assertEquals(0, CONCURRENT_THREADS * NUMBER_OF_TIMES - tmanager.transactionCounter);
		}
	}

    public class TransactionFactory implements EventFactory<Transaction> {
        @Override
        public Transaction newInstance() {
            return new Transaction();
        }
    }

	int processTimeLmax = 0;
	int processedCount = 0;
	boolean singleThreadProcessing = (PROCESSING_THREADS == 1);

    public class TransactionEventProcessor implements WorkHandler<Transaction> {
        @Override
        public void onEvent(Transaction transaction) throws Exception {
        	if( singleThreadProcessing ) {
            	long start = System.currentTimeMillis();
            	if( tmanager.getNotificationManager(transaction).isOverLimit(transaction, transaction.startMls) ) {
            		tmanager.notify(transaction, transaction.startMls, transaction.startTestMls);
            	}
            	processTimeLmax += System.currentTimeMillis() - start;
        	} else {
            	long start = System.currentTimeMillis();
            	if( tmanager.getNotificationManagerConcurrently(transaction).isOverLimitSequentially(transaction, transaction.startMls) ) {
            		tmanager.notify(transaction, transaction.startMls, transaction.startTestMls);
            	}
            	processTimeLmax += System.currentTimeMillis() - start;
        	}
        }
    }
    
    Object processedCountMonitor = new Object();
    
    public class TransactionResultReclaimer implements WorkHandler<Transaction> {
        @Override
        public void onEvent(Transaction event) throws Exception {
        	if( singleThreadProcessing ) {
        		++processedCount;
        	} else {
	        	synchronized( processedCountMonitor ) {
	        		++processedCount;
	        	}
        	}
        }
    }

}
