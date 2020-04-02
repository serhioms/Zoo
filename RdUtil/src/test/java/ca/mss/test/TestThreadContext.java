package ca.mss.test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mss.exe.WNExecutorService;

public class TestThreadContext {

	Logger logger = LogManager.getLogger(TestThreadContext.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.setProperty("org.apache.logging.log4j.simplelog.StatusLogger.level", "TRACE");
	}

	@Test
	public void testThreads() throws InterruptedException {
		logger.info("Start 100 Real Thread");
		testContext(100, new WNExecutorService());
		logger.info("Finish 100 Real Thread");
	}

	@Test
	public void testThreadPool() throws InterruptedException {
		logger.info("Start Thread Pool 10");
		testContext(1000, Executors.newFixedThreadPool(10));
		logger.info("Finish Thread Pool 10");
	}


	private void testContext(int max, ExecutorService exec) throws InterruptedException{
		
		AtomicInteger taskCount = new AtomicInteger(0);
		AtomicInteger errorCount1 = new AtomicInteger(0);
		AtomicInteger errorCount2 = new AtomicInteger(0);
		AtomicInteger errorCount3 = new AtomicInteger(0);

		Set<String> doneTask = ConcurrentHashMap.newKeySet();
		
		for(AtomicInteger i=new AtomicInteger(0); i.get()<max; i.incrementAndGet() ){
			
			int id = i.get();
			String ident = i.toString();
			
			exec.execute(new Thread(()->{
				
				ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
				if( threadLocalValue.get() != null ){
					errorCount1.incrementAndGet();
				}
				threadLocalValue.set(id);

				String logprop = ThreadContext.get("logprop");
				if( logprop != null ){
					errorCount2.incrementAndGet();
					if( !doneTask.contains(logprop)){
						errorCount3.incrementAndGet();
					}
				}
				ThreadContext.put("logprop", ident);

				taskCount.incrementAndGet();
				doneTask.add(ident);
			}, ident));
		}

		for(exec.shutdown(); !exec.awaitTermination(100, TimeUnit.MILLISECONDS); );
		
		System.out.printf("                 Task count = %d\n", taskCount.get());
		System.out.printf("  ThreadLocal error count#1 = %d\n", errorCount1.get());
		System.out.printf("ThreadContext error count#1 = %d\n", errorCount2.get());
		System.out.printf("ThreadContext error count#2 = %d\n", errorCount3.get());
	}
}
