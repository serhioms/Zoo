package interview.multithreading.dataexchange;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


// http://stackoverflow.com/questions/5602904/piping-data-between-threads-with-java
public class Pipe<E> {

	static private int MAX_PUT_THREAD = 100;
	static private int MAX_TAKE_THREAD = 5;

	static private int MAX_SIZE = 20;
	static private int MAX_PUT_SIZE = MAX_SIZE/Math.min(MAX_SIZE, MAX_PUT_THREAD);

	static AtomicInteger startCounter = new AtomicInteger(0);

	private E e;

	private final Semaphore read = new Semaphore(0);
	private final Semaphore write = new Semaphore(1);

	public final void put(final E e) throws InterruptedException {
		write.acquire();
		this.e = e;
		read.release();
	}

	public final E take() throws InterruptedException {
		read.acquire();
		final E e = this.e;
		write.release();
		return e;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Pipe<Integer> pipe = new Pipe<Integer>();
		//final BlockingQueue<Integer> pipe = new java.util.concurrent.ArrayBlockingQueue<Integer>(100); 
		//final BlockingQueue<Integer> pipe = new java.util.concurrent.LinkedBlockingQueue<Integer>(100); 
		//final BlockingQueue<Integer> pipe = new java.util.concurrent.SynchronousQueue<Integer>(); 
		
		final Random rnd = new Random(1000L);

		ExecutorService executor = Executors.newFixedThreadPool(MAX_TAKE_THREAD+MAX_PUT_THREAD);
		
		for(int x=0; x<MAX_PUT_THREAD; x++)
		executor.execute(new Thread("Put") {

			@Override
			public void run() {
				//System.out.println("Put...");
				try {
					for (Integer i=0; i < MAX_PUT_SIZE; i++) {
						try {
							int n = startCounter.incrementAndGet();
							//System.out.println("Put..."+n);
							pipe.put(n);
						} catch (InterruptedException e) {
							System.out.println("Put thread interrupted on step "+ i + " " + e.getMessage());
							break;
						}
					}
				} catch (Throwable e) {
					System.out.println("Put exception: " + e.getMessage());
				}
				//System.out.println("Put done.");
			}
		});
		
		for(int x=0; x<MAX_TAKE_THREAD; x++)
		executor.execute(new Thread("Take") {
			int sum = 0;

			@Override
			public void run() {
				//System.out.println("Take...");
				try {
					int n = -2;
					try {
						long start = System.currentTimeMillis();
						for (n = pipe.take(); n != -1; n = pipe.take()) {
							//System.out.println("Take..."+n);
							sum++;
							
							if( n == MAX_SIZE ){
								for(int x=MAX_TAKE_THREAD; x>0; x--)
									pipe.put(-1);
							}
							
							Thread.sleep(rnd.nextInt(50));
						}
						System.out.println("Take result: " + sum + ", time: " + (System.currentTimeMillis() - start) + " mls");
					} catch (InterruptedException e) {
						System.out.println("Take thread interruptrd on step " + n + " " + e.getMessage());
					}
				} catch (Throwable e) {
					System.out.println("Take result: " + sum + ", exception: "
							+ e.getMessage());
				}
			}
		});

		executor.shutdown();

		while (!executor.isTerminated()) {}

		System.out.println("The end..");
	}

}
