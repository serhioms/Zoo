package tamaso;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class RobastScalableExample {

	@Test
	public void test() throws InterruptedException {
		ExecutorService threads = Executors.newCachedThreadPool();
		
		HighOrder sequential = HighOrder.sequential(); 
		HighOrder asynchronous = HighOrder.asynchronous(threads); 
		HighOrder parallel = HighOrder.parallel(threads); 
		
		ConcurrentLinkedQueue<String> result = new ConcurrentLinkedQueue<String>();
		
		Runnable flow = sequential.combine(
				()->result.add("seq1"),
				()->result.add("seq2"),
					parallel.combine(
							sequential.combine(
									()->result.add("seq3.1"),
									()->sleep(),
									()->result.add("seq3.2"),
									()->sleep(),
									()->sleep(),
									()->result.add("seq3.3")
									),
							()->{sleep();result.add("par2");},
							()->{sleep();sleep();result.add("par3");}
							),
				()->result.add("seq4"),
					asynchronous.combine(
							()->result.add("async1"),
							()->{sleep();sleep();result.add("async2");},
							()->{sleep();sleep();sleep();result.add("async3");}
							),
				()->{sleep();result.add("seq5");}
				); 
		
		// threads.execute(flow); // HAVE TO WAIT UNTILL FLOW BUILDS
		flow.run();
		
		threads.shutdown();
		threads.awaitTermination(1, TimeUnit.HOURS);
		
        assertEquals("[seq1, seq2, seq3.1, par2, seq3.2, par3, seq3.3, seq4, async1, seq5, async2, async3]", result.toString());
	}

	public void sleep() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
		}
	}

	public static interface HighOrder {
		
		public Runnable combine(Runnable... jobs);
		
		public static HighOrder sequential() {
			return jobs -> () -> Arrays.stream(jobs).forEach(Runnable::run);
		}
		
		public static HighOrder asynchronous(ExecutorService threads ) {
			return jobs -> () -> Arrays.stream(jobs).forEach(threads::execute);
		}
		
		public static HighOrder parallel(ExecutorService threads ) {
			return jobs -> () -> {
				try {
					CountDownLatch latch = new CountDownLatch(jobs.length);
					Arrays.stream(jobs).forEach(job -> {
						threads.execute(()->{
							try {
								job.run();
							} finally {
								latch.countDown();
							}
						});
					});
					latch.await();
				} catch(InterruptedException e){
					Thread.currentThread().interrupt();
				}
			};
		}
	}
}
