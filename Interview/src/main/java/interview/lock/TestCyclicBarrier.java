package interview.lock;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	public static void main(String[] args) throws InterruptedException {

		CyclicBarrier lock = new CyclicBarrier(9, ()->System.out.println("GO!"));
		
		long start = System.nanoTime();
		
		for(int i=0, max=lock.getParties(); i<max; i++){
			new Thread(()->{
				try {
					lock.await();
					System.out.printf("%s %.2f mks\n", Thread.currentThread().getName(), (System.nanoTime()-start)/1000000.0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}, "Thread#"+(i+1)).start();
		}
		
		Thread.sleep(10L);
	}

}

/*
		GO!
		Thread#4 3.02 mks
		Thread#1 3.44 mks
		Thread#3 3.40 mks
		Thread#9 3.36 mks
		Thread#8 3.31 mks
		Thread#7 3.28 mks
		Thread#6 3.21 mks
		Thread#5 3.09 mks
		Thread#2 3.06 mks
*/