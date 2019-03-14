package java7.threads;

import org.junit.Test;

public class TwoWayCreateThread {

	@Test
	public void passRunnableToThread() {
		new Thread(()->{
			System.out.println("Thread A");
		}).start();
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Thread B");
		}
	}
	
	@Test
	public void extendThreadItself() {
		new MyThread().start();
	}

}
