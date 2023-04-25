package interview.highranking;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFlowRun {

	static ExecutorService exec;

	ExecutorService execNaive;
	
	String seq;
	AtomicInteger sum;
	AtomicInteger mult;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		exec = Executors.newFixedThreadPool(4);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		exec.shutdown();
		while( !exec.isTerminated() );
	}

	@Before
	public void setUp() throws Exception {
		seq = "";
		execNaive = Executors.newFixedThreadPool(4);
		sum = new AtomicInteger(0);
		mult = new AtomicInteger(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sequential() {
		Runnable flow = FlowRun.sequential().combine(
				()->{seq += "1";},
				()->{seq += "2";},
				()->{seq += "3";}
			);
		
		try {
			flow.run();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		assertEquals("123", seq);
	}

	@Test
	public void sequentialInterrupted() {
		Runnable flow = FlowRun.sequential().combine(
				()->{seq += "1";},
				()->{seq += "2";},
				()->{throw new RuntimeException("Sequential interrupted");}
			);
		
		try {
			flow.run();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		assertEquals("12", seq);
	}

	@Test
	public void parallelFullBlock() throws Exception {
		Runnable flow = FlowRun.parallelFullBlock(exec).combine(
				()->{sum.addAndGet(1);	mult.set(mult.get()*1);},
				()->{sum.addAndGet(2);	mult.set(mult.get()*2);},
				()->{sum.addAndGet(3);	mult.set(mult.get()*3);}
			);
		
		try {
			flow.run();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		assertEquals(6, sum.get());
		assertEquals(6, mult.get());
	}

	@Test
	public void parallelNonBlock() {
		Runnable flow = FlowRun.parallelNonBlock(execNaive).combine(
					()->{sum.addAndGet(1);	mult.set(mult.get()*1);},
					()->{sum.addAndGet(2);	mult.set(mult.get()*2);},
					()->{sum.addAndGet(3);	mult.set(mult.get()*3);}
				);

		try {
			flow.run();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		execNaive.shutdown();
		while( !execNaive.isTerminated() );

		assertEquals(6, sum.get());
		assertEquals(6, mult.get());
	}


}
