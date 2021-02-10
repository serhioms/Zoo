package ca.interview.rbc.transactions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class TestTransactionNotification {

	final int T = 1000;
	final int N = 1000;


	@Test
	public void testMultithreadedImplementation() {
		System.out.printf("\nMULTI-THREADS NOTIFICATIONS for contention of %,d threads %,d times\n", T, N);

		CyclicBarrier barrier = new CyclicBarrier(T);
		CountDownLatch latch = new CountDownLatch(T);

		TransactionManager tmanager = new TransactionManager();
		int processTime = 0;

		long startProcessing = System.currentTimeMillis();

		long[][] minmaxTime = initializeTiming(new long[N][]);

		for (int i = 0, max = T; i < max; ++i) {
			new Thread(() -> {
				try {
					for (int j = 0; j < N; ++j) {
						barrier.await();
						long[] timing = tmanager.processAsynch(new Transaction(), startProcessing);
						synchronized( this ) {
							// The earliest thread startProcessingTime
							minmaxTime[j][0] = Math.min(minmaxTime[j][0], timing[0]);
							// The oldest thread endProcessingTime
							minmaxTime[j][1] = Math.max(minmaxTime[j][1], timing[1]);
						}
					}
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				} finally {
					latch.countDown();
				}
			}).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endProcessing = System.currentTimeMillis();

		processTime = calculateTiming(minmaxTime);

		System.out.printf("                  Test time = %,d mls\n", endProcessing - startProcessing);
		System.out.printf("            Processing time = %,d mls\n", processTime);
		System.out.printf("     Number of transactions = %,d\n", tmanager.transactionCounter);
		System.out.printf("    Number of notifications = %,d\n", tmanager.notificationCounter);
		System.out.printf("Number of notified accounts = %,d (%,d)\n", tmanager.notifiedAccounts.size(), Transaction.TOTAL_ACCOUNTS);

		assertEquals(0, T * N - tmanager.transactionCounter);
	}


	Object processTimeMonitor = new Object();

	@Test
	public void testSingleThreadedImplementation() {
		System.out.printf("\nSINGLE-THRED NOTIFICATIONS for contention of %,d threads %,d times\n", T, N);

		CyclicBarrier barrier = new CyclicBarrier(T);
		CountDownLatch latch = new CountDownLatch(T);

		TransactionManager tmanager = new TransactionManager();
		int[] processTime = new int[] {0};

		long startProcessing = System.currentTimeMillis();

		for (int i = 0, max = T; i < max; ++i) {
			new Thread(() -> {
				try {
					for (int j = 0; j < N; ++j) {
						barrier.await();
						long[] timing = tmanager.processSynch(new Transaction(), startProcessing);
						long accumulativeTime = timing[1]-timing[0];
						synchronized( processTimeMonitor ) {
							processTime[0] += accumulativeTime;
						}
					}
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				} finally {
					latch.countDown();
				}
			}).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endProcessing = System.currentTimeMillis();

		System.out.printf("                  Test time = %,d mls\n", endProcessing - startProcessing);
		System.out.printf("            Processing time = %,d mls\n", processTime[0]);
		System.out.printf("     Number of transactions = %,d\n", tmanager.transactionCounter);
		System.out.printf("    Number of notifications = %,d\n", tmanager.notificationCounter);
		System.out.printf("Number of notified accounts = %,d (%,d)\n", tmanager.notifiedAccounts.size(), Transaction.TOTAL_ACCOUNTS);

		assertEquals(0, T * N - tmanager.transactionCounter);
	}

	private int calculateTiming(long[][] timing) {
		int processTime = 0;
		for(int i=0,max=timing.length; i<max; ++i) {
			processTime += (timing[i][1]-timing[i][0]);
		}
		return processTime;
	}

	private long[][] initializeTiming(long[][] timing) {
		for(int i=0,max=timing.length; i<max; ++i) {
			timing[i] = new long[] {Long.MAX_VALUE,0};
		}
		return timing;
	}

}
