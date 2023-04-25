package interview.multithreading.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

	private static Random r = new Random();
	
	public long start = 0;
	public long end = 0;
	
	public MyThread(String ident, int priority) {
		super(ident);
		setDaemon(true); // Daemons would be finished after main thread get finished
		setPriority(priority);
	}

	public MyThread(String ident, Runnable run) {
		super(run);
		setDaemon(true); // Daemons would be finished after main thread get finished
		setName(ident);
	}

	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		start = System.nanoTime();
		try {
			TimeUnit.MICROSECONDS.sleep(r.nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			end = System.nanoTime();
			yield();
		}
	}
}
