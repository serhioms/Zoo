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

	final static int CONCURRENT_THREADS = 10000;
	final static int NUMBER_OF_TIMES = 100000;

	final static int PROCESSING_THREADS = 8;

	TransactionManager tmanager = new TransactionManager();
	
	Object barrierTimeMonitor = new Object();
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
			long[] threadTime = new long[] {0, Long.MAX_VALUE, 0};
			long[] barrierTime = new long[] {0, Long.MAX_VALUE, 0};
	
			long startTest = System.currentTimeMillis();
	
			for (int i = 0, maxi = CONCURRENT_THREADS; i < maxi; ++i) {
				new Thread(() -> {
					long threadDuration = System.currentTimeMillis();
					try {
						long barrierWait=0;
						if( CONCURRENT_THREADS > 1 ) {
							barrierWait = System.currentTimeMillis();
							barrier.await();
							barrierWait = System.currentTimeMillis() - barrierWait;
							synchronized( barrierTimeMonitor ) {
								barrierTime[0] += barrierWait;
								barrierTime[1] = Math.min(barrierTime[1] , barrierWait);
								barrierTime[2] = Math.max(barrierTime[2] , barrierWait);
							}
						}
						for (int j = 0, maxj = NUMBER_OF_TIMES; j < maxj; ++j) {
							long[] timing = tmanager.processSequentially(Transaction.getTransaction(), startTest);
							synchronized( processTimeMonitor ) {
								processTime[0] += timing[1]-timing[0];
							}
						}
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
					threadDuration = System.currentTimeMillis() - threadDuration;
					synchronized( threadTimeMonitor ) {
						threadTime[0] += threadDuration;
						threadTime[1] = Math.min(threadTime[1] , threadDuration);
						threadTime[2] = Math.max(threadTime[2] , threadDuration);
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
			System.out.printf("                Thread time = %,d mls avg [%,d to %,d mls]\n", threadTime[0]/CONCURRENT_THREADS, threadTime[1], threadTime[2]);
			System.out.printf("               Barrier time = %,d mls avg [%,d to %,d mls]\n", barrierTime[0]/CONCURRENT_THREADS, barrierTime[1], barrierTime[2]);
			System.out.printf("            Processing time = %,d mls/%,d\n", processTime[0], tmanager.transactionCounter);
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
			long[] threadTime = new long[] {0, Long.MAX_VALUE, 0};
			long[] barrierTime = new long[] {0, Long.MAX_VALUE, 0};
	
			long startTest = System.currentTimeMillis();
	
			for (int i = 0, maxi = CONCURRENT_THREADS; i < maxi; ++i) {
				new Thread(() -> {
					long threadDuration = System.currentTimeMillis();
					try {
						long barrierWait=0;
						if( CONCURRENT_THREADS > 1 ) {
							barrierWait = System.currentTimeMillis();
							barrier.await();
							barrierWait = System.currentTimeMillis() - barrierWait;
							synchronized( barrierTimeMonitor ) {
								barrierTime[0] += barrierWait;
								barrierTime[1] = Math.min(barrierTime[1] , barrierWait);
								barrierTime[2] = Math.max(barrierTime[2] , barrierWait);
							}
						}
						for (int j = 0, maxj = NUMBER_OF_TIMES; j < maxj; ++j) {
							long[] timing = tmanager.processConcurrently(Transaction.getTransaction(), startTest);
							synchronized( processTimeMonitor ) {
								processTime[0] += timing[1] - timing[0];
							}
						}
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
					threadDuration = System.currentTimeMillis() - threadDuration;
					synchronized( threadTimeMonitor ) {
						threadTime[0] += threadDuration;
						threadTime[1] = Math.min(threadTime[1] , threadDuration);
						threadTime[2] = Math.max(threadTime[2] , threadDuration);
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
			System.out.printf("                Thread time = %,d mls avg [%,d to %,d mls]\n", threadTime[0]/CONCURRENT_THREADS, threadTime[1], threadTime[2]);
			System.out.printf("               Barrier time = %,d mls avg [%,d to %,d mls]\n", barrierTime[0]/CONCURRENT_THREADS, barrierTime[1], barrierTime[2]);
			System.out.printf("            Processing time = %,d mls/%,d\n", processTime[0], tmanager.transactionCounter);
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
			
			long[] publishTime = new long[] {0};
			long[] threadTime = new long[] {0, Long.MAX_VALUE, 0};
			long[] barrierTime = new long[] {0, Long.MAX_VALUE, 0};
	
			long startTest = System.currentTimeMillis();
	
			for (int i = 0, maxi=CONCURRENT_THREADS; i < maxi; ++i) {
				new Thread(() -> {
					long threadDuration = System.currentTimeMillis();
					try {
						long barrierWait=0;
						if( CONCURRENT_THREADS > 1 ) {
							barrierWait = System.currentTimeMillis();
							barrier.await();
							barrierWait = System.currentTimeMillis() - barrierWait;
							synchronized( barrierTimeMonitor ) {
								barrierTime[0] += barrierWait;
								barrierTime[1] = Math.min(barrierTime[1] , barrierWait);
								barrierTime[2] = Math.max(barrierTime[2] , barrierWait);
							}
						}
						for (int j = 0, maxj = NUMBER_OF_TIMES; j < maxj; ++j) {
							long[] timing = tmanager.publishLmaxSynch(ringBuffer, startTest);
							synchronized( publishTimeMonitor ) {
								publishTime[0] += timing[1]-timing[0];
							}
						}
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					} finally {
						latch.countDown();
					}
					threadDuration = System.currentTimeMillis() - threadDuration;
					synchronized( threadTimeMonitor ) {
						threadTime[0] += threadDuration;
						threadTime[1] = Math.min(threadTime[1] , threadDuration);
						threadTime[2] = Math.max(threadTime[2] , threadDuration);
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
			System.out.printf("                Thread time = %,d mls avg [%,d to %,d mls]\n", threadTime[0]/CONCURRENT_THREADS, threadTime[1], threadTime[2]);
			System.out.printf("               Barrier time = %,d mls avg [%,d to %,d mls]\n", barrierTime[0]/CONCURRENT_THREADS, barrierTime[1], barrierTime[2]);
			System.out.printf("               Publish time = %,d mls/%,d\n", publishTime[0], tmanager.transactionCounter);
			System.out.printf("            Processing time = %,d mls/%,d\n", processTimeLmax, tmanager.transactionCounter);
			System.out.printf("     Number of transactions = %,d\n", tmanager.transactionCounter);
			System.out.printf("    Number of notifications = %,d\n", tmanager.notificationCounter);
			System.out.printf("Number of notified accounts = %,d (%,d)\n", tmanager.notifiedAccounts.size(), Transaction.TOTAL_ACCOUNTS);
	
			assertEquals(0, CONCURRENT_THREADS * NUMBER_OF_TIMES - tmanager.transactionCounter);
		}
	}

    public class TransactionFactory implements EventFactory<Transaction> {
        @Override
        public Transaction newInstance() {
            return Transaction.getTransaction();
        }
    }

	Object processTimeLmaxMonitor = new Object();

	int processTimeLmax = 0;
	int processedCount = 0;
	
	final boolean singleThreadProcessing = (PROCESSING_THREADS == 1);

    public class TransactionEventProcessor implements WorkHandler<Transaction> {
        @Override
        public void onEvent(Transaction transaction) throws Exception {
        	long start = System.currentTimeMillis();
        	if( singleThreadProcessing ) {
            	if( tmanager.getNotificationManager(transaction).isOverLimit(transaction, transaction.startMls) ) {
            		tmanager.notify(transaction, transaction.startMls, transaction.startTestMls);
            	}
            	processTimeLmax += System.currentTimeMillis() - start;
        	} else {
            	if( tmanager.getNotificationManagerConcurrently(transaction).isOverLimitSequentially(transaction, transaction.startMls) ) {
            		tmanager.notify(transaction, transaction.startMls, transaction.startTestMls);
            	}
            	synchronized( processTimeLmaxMonitor ) {
            		processTimeLmax += System.currentTimeMillis() - start;
            	}
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
