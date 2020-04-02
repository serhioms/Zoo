package ca.mss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAsync {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		
		List<Runnable> runnables = new ArrayList<>();
		AtomicReference<String> ref = new AtomicReference<String>("");
		
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});
		runnables.add(()->{
			for(String actual = ref.get();
					!ref.compareAndSet(actual, ref.get()+"A");
					actual = ref.get());
		});

		runnables.parallelStream().forEach(r->{
			r.run();
		});
		
		while( ref.get().length() <8 );
		
		System.out.println(ref.get());
	}

}
