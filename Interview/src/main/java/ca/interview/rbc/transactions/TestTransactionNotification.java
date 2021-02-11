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

}
/*


SEQUENTIAL NOTIFICATIONS with contention of 1,000 threads 1,000 times
  3) time slot= 6 Acc#880 = $10,010 > $10,000 (total 143 - 2 expired)
 11) time slot= 8 Acc#389 = $10,080 > $10,000 (total 144 - 1 expired)
                  Test time = 6,425 mls
            Processing time = 890 mls ####################### faster
                Thread time = 6,374 mls
     Number of transactions = 1,000,000
    Number of notifications = 11
Number of notified accounts = 9 (831)

CONCURRENTNOTIFICATIONS with contention of 1,000 threads 1,000 times
  8) time slot= 4 Acc#537 = $10,010 > $10,000 (total 143 - 3 expired)
 30) time slot= 5 Acc#765 = $10,220 > $10,000 (total 146 - 2 expired)
 43) time slot= 6 Acc#758 = $10,150 > $10,000 (total 145 - 3 expired)
 65) time slot= 7 Acc#157 = $10,080 > $10,000 (total 144 - 1 expired)
 67) time slot= 7 Acc#632 = $10,570 > $10,000 (total 151 - 1 expired)
 69) time slot= 7 Acc#784 = $10,360 > $10,000 (total 148 - 5 expired)
115) time slot= 9 Acc#684 = $10,010 > $10,000 (total 143 - 1 expired)
118) time slot= 9 Acc#640 = $10,080 > $10,000 (total 144 - 1 expired)
                  Test time = 5,715 mls
            Processing time = 1,679 mls #################### slower
                Thread time = 5,714 mls
     Number of transactions = 1,000,000
    Number of notifications = 155
Number of notified accounts = 113 (831)

*/