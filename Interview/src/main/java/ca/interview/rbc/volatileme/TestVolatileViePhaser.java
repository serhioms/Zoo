package ca.interview.rbc.volatileme;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class TestVolatileViePhaser {

	@Test
	public void test() {

		final int T = 10000;
		final int N = 100000;

		Phaser phaser = new Phaser(T);
		CountDownLatch latch = new CountDownLatch(T);
		
		Incremental inc = new Incremental();

		AtomicLong[] finish = 
				new AtomicLong[]{new AtomicLong(0), new AtomicLong(0), 
				new AtomicLong(0), new AtomicLong(0), new AtomicLong(0), 
				new AtomicLong(0), new AtomicLong(0)};
		
		long start = System.currentTimeMillis();
		
		for (int i = 0, max = T; i < max; ++i) {
			new Thread(() -> {
				phaser.arriveAndAwaitAdvance();
				finish[0].addAndGet(inc.incrementSynchVolatile(N));
 
				phaser.arriveAndAwaitAdvance();
				finish[1].addAndGet(inc.incrementSynchNonVolatile(N));

				phaser.arriveAndAwaitAdvance();
				finish[2].addAndGet(inc.incrementAsynchNonVolatile(N));

				phaser.arriveAndAwaitAdvance();
				finish[3].addAndGet(inc.incrementAsynchVolatile(N));

				phaser.arriveAndAwaitAdvance();
				finish[4].addAndGet(inc.incrementAtomic(N));

				phaser.arriveAndAwaitAdvance();
				finish[5].addAndGet(inc.incrementLockVolatile(N));

				phaser.arriveAndAwaitAdvance();
				finish[6].addAndGet(inc.incrementLockNonVolatile(N));

				phaser.arriveAndDeregister();
				latch.countDown();
			}).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		
		System.out.printf("\n PHASER execution time with contention of %,d threads = %,d mls\n", T, end-start);
		System.out.printf("++      Sync volatile = %,12d mls\n", finish[0].get());
		System.out.printf("++      Lock volatile = %,12d mls\n", finish[5].get());
		System.out.printf("++  Lock non volatile = %,12d mls\n", finish[6].get());
		System.out.printf("++  Sync non volatile = %,12d mls\n", finish[1].get());
		System.out.printf("++ Async non volatile = %,12d mls\n", finish[2].get());
		System.out.printf("++     Async volatile = %,12d mls\n", finish[3].get());
		System.out.printf("++             Atomic = %,12d mls\n", finish[4].get());
		
		// Synchronized increments and atomics are succeed
		assertEquals(0, T*N-inc.syncVolatileCounter);
		assertEquals(0, T*N-inc.syncNonVolatileCounter);
		assertEquals(0, T*N-inc.lockVolatileCounter);
		assertEquals(0, T*N-inc.lockNonVolatileCounter);
		assertEquals(0, T*N-inc.atomicCounter.get());
		// Non synchronized increments are failed
		assertNotEquals(0, T*N-inc.asyncCounter);
		assertNotEquals(0, T*N-inc.asyncVolatileCounter);
	}

}
