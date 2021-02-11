package ca.interview.rbc.transactions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class TestTransactionNotification {

	final static int CONCURRENT_THREADS = 1000;
	final static int NUMBER_OF_TIMES = 1000;

	Object processTimeMonitor = new Object();
	Object threadTimeMonitor = new Object();

	@Test
	public void testSequential() {
		System.out.printf("\nSEQUENTIAL NOTIFICATIONS with contention of %,d threads %,d times\n", CONCURRENT_THREADS, NUMBER_OF_TIMES);

		CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_THREADS);
		CountDownLatch latch = new CountDownLatch(CONCURRENT_THREADS);

		TransactionManager tmanager = new TransactionManager();
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

	@Test
	public void testConcurrent() {
		System.out.printf("\nCONCURRENTNOTIFICATIONS with contention of %,d threads %,d times\n", CONCURRENT_THREADS, NUMBER_OF_TIMES);

		CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_THREADS);
		CountDownLatch latch = new CountDownLatch(CONCURRENT_THREADS);

		TransactionManager tmanager = new TransactionManager();

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

	private int calculate(long[][] timing) {
		int processTime = 0;
		for(int i=0,max=timing.length; i<max; ++i) {
			processTime += (timing[i][1]-timing[i][0]);
		}
		return processTime;
	}

	private long[][] initialize(long[][] timing) {
		for(int i=0,max=timing.length; i<max; ++i) {
			timing[i] = new long[] {Long.MAX_VALUE,0};
		}
		return timing;
	}

}
/*

SINGLE-THRED NOTIFICATIONS with contention of 1,000 threads 1,000 times
  9) time slot= 6 Acc#880 = $10,710 > $10,000 (total 153 - 3 expired)
 36) time slot= 9 Acc#523 = $10,010 > $10,000 (total 143 - 2 expired)
                  Test time = 6,005 mls
            Processing time = 807 mls ################################################
                Thread time = 5,952 mls
     Number of transactions = 1,000,000
    Number of notifications = 58
Number of notified accounts = 48 (831)

MULTI-THREADS NOTIFICATIONS with contention of 1,000 threads 1,000 times
 61) time slot= 7 Acc#784 = $10,080 > $10,000 (total 144 - 3 expired)
 74) time slot= 8 Acc#705 = $10,500 > $10,000 (total 150 - 1 expired)
                  Test time = 5,726 mls
            Processing time = 5,562 mls ##############################################
                Thread time = 5,724 mls
     Number of transactions = 1,000,000
    Number of notifications = 116
Number of notified accounts = 100 (831)
*/