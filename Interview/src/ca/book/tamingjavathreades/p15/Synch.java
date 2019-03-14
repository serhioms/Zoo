package ca.book.tamingjavathreades.p15;

import java.text.NumberFormat;

/** 
 * Synchronization Is Expensive
 *
 * Pass 0: Time lost: 226 ms. 2,611.11% increase
 * Pass 1: Time lost: 230 ms. 3,933.33% increase
 * Pass 2: Time lost: 227 ms. 3,883.33% increase
 * Pass 3: Time lost: 222 ms. 2,566.67% increase
 * Pass 4: Time lost: 225 ms. 3,314.29% increase
 * Pass 5: Time lost: 222 ms. 2,875% increase
 * Pass 6: Time lost: 223 ms. 3,285.71% increase
 * Pass 7: Time lost: 1,177 ms. 16,914.29% increase
 * Pass 8: Time lost: 1,173 ms. 14,762.5% increase
 
 A benchmark to test the overhead of synchronization on a simple method
 invocation. Benchmarking java, particularly when Hot- Spot is in the
 equation, is tricky. There's a good tech note on this subject at http
 */

class Synch {

	private static long[] locking_time = new long[100];
	private static long[] not_locking_time = new long[100];
	private static final int ITERATIONS = 10000000;

	
	//  3'000% slower without concurrency
	// 20'000% slower with concurrency
	synchronized long locking(long a, long b) {
		return a + b;
	}

	
	// Fast
	long not_locking(long a, long b) {
		return a + b;
	}

	
	private void test(int id) {
		long start = System.currentTimeMillis();

		for (long i = ITERATIONS; --i >= 0;) {
			locking(i, i);
		}

		locking_time[id] = System.currentTimeMillis() - start;
		start = System.currentTimeMillis();

		for (long i = ITERATIONS; --i >= 0;) {
			not_locking(i, i);
		}

		not_locking_time[id] = System.currentTimeMillis() - start;
	}

	static void print_results(int id) {

		NumberFormat compositor = NumberFormat.getInstance();
		compositor.setMaximumFractionDigits(2);

		double time_in_synchronization = locking_time[id] - not_locking_time[id];

		System.out.println("Pass " + id + ": Time lost: " + compositor.format(time_in_synchronization) + " ms. "
				+ compositor.format(((double) locking_time[id] / not_locking_time[id]) * 100.0) + "% increase");

	}

	static public void main(String[] args) throws InterruptedException {
		// First, with no contention

		final Synch tester = new Synch();
		tester.test(0);
		print_results(0);
		tester.test(1);
		print_results(1);
		tester.test(2);
		print_results(2);
		tester.test(3);
		print_results(3);
		tester.test(4);
		print_results(4);
		tester.test(5);
		print_results(5);
		tester.test(6);
		print_results(6);

		// Now let's do it again with contention. I'm assuming that
		// hotspot has optimized the test method by now, so am only
		// calling it once.

		final Object start_gate = new Object();

		Thread t1 = new Thread() {
			public void run() {
				try {
					synchronized (start_gate) {
						start_gate.wait();
					}
				}

				catch (InterruptedException e) {
				}

				tester.test(7);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					synchronized (start_gate) {
						start_gate.wait();
					}
				} catch (InterruptedException e) {
				}

				tester.test(8);
			}
		};

		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();

		/*
		 * Wait for Thread1 and Thread2 are started
		 */
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}

		/*
		 * Start test(7) and test(8) simultaniously!
		 */
		synchronized (start_gate) {
			start_gate.notifyAll();
		}

		t1.join();
		t2.join();
		/*
		 * Wait for both threads are finished
		 */
		
		print_results(7);
		print_results(8);
	}
}
