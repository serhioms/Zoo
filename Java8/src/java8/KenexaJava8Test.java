package java8;

/*
 * Static import methods of the class with *
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/*
 * Java Programming Language
 * 
 * http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
 * https://www.journaldev.com/2389/java-8-features-with-examples
 */
public class KenexaJava8Test {

	/*
	 * Optional
	 * 
	 */
	@Test
	public void Optional() {
		try {
			// orElse
			assertEquals("typedir", Optional.ofNullable(new Project(new ApplicationType()))
					.map(Project::getApplicationTypeOptional)
			        .map(ApplicationType::getTypeDirNameOptional)
			        .orElse("N/A"));

			// isPresent
			assertEquals(true, Optional.ofNullable(new Project(new ApplicationType()))
					.map(Project::getApplicationTypeOptional)
			        .map(ApplicationType::getTypeDirNameOptional)
			        .isPresent());

			// orElse
			assertEquals("N/A", Optional.ofNullable(new Project(null))
					.map(Project::getApplicationTypeOptional)
			        .map(ApplicationType::getTypeDirNameOptional)
			        .orElse("N/A"));

			// isPresent
			assertEquals(false, Optional.ofNullable(new Project(null))
					.map(Project::getApplicationTypeOptional)
			        .map(ApplicationType::getTypeDirNameOptional)
			        .isPresent());
			
			// orElseThrow
			try {
				assertEquals("N/A", Optional.ofNullable(new Project(null))
						.map(Project::getApplicationTypeOptional)
				        .map(ApplicationType::getTypeDirNameOptional)
				        .orElseThrow(IllegalStateException::new ));
				fail("Expected IllegalStateException here...");
			} catch(IllegalStateException e) {
				assertEquals(null, e.getMessage());
			}
			
			// Filter (Lambdas)
			assertEquals(true, 
					Optional.ofNullable(new Project(new ApplicationType()))
					.map(Project::getApplicationTypeOptional)
			        .map(ApplicationType::getTypeDirNameOptional)
			        .filter(x -> {return "typedir".equals(x);})
			        .isPresent()
			        );
			assertEquals(false, 
					Optional.ofNullable(new Project(new ApplicationType()))
					.map(Project::getApplicationTypeOptional)
			        .map(ApplicationType::getTypeDirNameOptional)
			        .filter(x -> {return "abrakadabra".equals(x);})
			        .isPresent()
			        );
			
			// Map (Lambdas)
			assertEquals(new Integer(12), Optional.of("abrakad-abra").map( String::length            ).orElse(0) );
			assertEquals(new Integer(0),  Optional.ofNullable( null ).map( x -> x.toString().length()).orElse(0) );
			
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	public class Project {
		final private ApplicationType applicationTypeOptional;
		public Project(ApplicationType applicationTypeOptional) {
			this.applicationTypeOptional = applicationTypeOptional;
		}
		public ApplicationType getApplicationTypeOptional() {
			return applicationTypeOptional;
		}
		
	}
	public class ApplicationType {
		private String typeDirNameOptional = "typedir";
		public String getTypeDirNameOptional() {
			return typeDirNameOptional;
		}
	}
	
	/*
	 * Base64
	 */
	@Test
	public void Base64() {
		try {

			assertEquals("java.util.Base64$Decoder", java.util.Base64.getDecoder().getClass().getName());
			assertEquals("java.util.Base64$Encoder", java.util.Base64.getEncoder().getClass().getName());
			assertEquals("java.util.Base64$Decoder", java.util.Base64.getMimeDecoder().getClass().getName());
			assertEquals("java.util.Base64$Encoder", java.util.Base64.getMimeEncoder().getClass().getName());
			assertEquals("java.util.Base64$Decoder", java.util.Base64.getUrlDecoder().getClass().getName());
			assertEquals("java.util.Base64$Encoder", java.util.Base64.getUrlEncoder().getClass().getName());
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void IntSummaryStatistics() {
		IntSummaryStatistics stats = Arrays.asList("a","abc","abcdw").stream().filter(name -> !name.isEmpty())
				.collect(Collectors.summarizingInt(name -> name.length())); // summarizingDouble, summarizingLong
		
		assertEquals(9, stats.getSum());
		assertEquals(1, stats.getMin());
		assertEquals(5, stats.getMax());
		assertEquals(3.0, stats.getAverage(), 0.01);

		// Reference method name to call
		stats = Arrays.asList("a","abc","abcdw").stream().filter(name -> !name.isEmpty())
				.collect(Collectors.summarizingInt(String::length));
		
		assertEquals(9, stats.getSum());
		assertEquals(1, stats.getMin());
		assertEquals(5, stats.getMax());
		assertEquals(3.0, stats.getAverage(), 0.01);
	}
	
	@Test
	public void ArithmeticException() {
		try {

			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			
			// No ArithmeticException!
			try {
				int c = a + b;
				assertEquals(-2, c);
			} catch(ArithmeticException e) {
				fail(e.getMessage());
				assertEquals(null, e.getMessage());
			}
		
			// throw ArithmeticException
			try {
				assertEquals(-2, Math.addExact(a,b));
			} catch(ArithmeticException e) {
				assertEquals("ArithmeticException", e.getClass().getSimpleName());
			}
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	/*
	 * https://blog.rapid7.com/2015/10/28/java-8-introduction-to-parallelism-and-spliterator/
	 */
	@Test
	public void Spliterator() {
		try {
			
			// Listing 2 – Simple Spliterator on an ArrayList
			Collection<String> people = Arrays.asList("A","B","C","D","E","F","G");
			Spliterator<String> peopleSpliterator = people.spliterator();
			
			/*
			 *  Spliterator characteristics - is the result of the OR’ed values of the individual characteristics for an ArrayList, 
			 *  which is ORDERED, SORTED and SUBSIZED[10].
			 */
			assertEquals(16464, peopleSpliterator.characteristics());
			assertEquals(7, peopleSpliterator.estimateSize());
			
			// Listing 3 – Split the Spliterator to partitions
			Spliterator<String> newPartition = peopleSpliterator.trySplit(); 
			assertEquals(3, newPartition.estimateSize()); 
			assertEquals(4, peopleSpliterator.estimateSize());
			
			newPartition.forEachRemaining(System.out::println); // A, B, C
			newPartition.forEachRemaining(System.out::println); // Nothing
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	

	@Test
	public void FunctionalInterface() {
		try {

			AtomicInteger sum = new AtomicInteger(0); 
			
			Runnable r2 = () -> sum.addAndGet(1); 			// Functional interface implementation vie lambda definition

			IntStream.range(0,7).forEach(n->r2.run());
			assertEquals(7, sum.get());

			IntStream.range(0,7).forEach(sum::addAndGet); 	// Functional interface implementation vie lambda operator :: 
			assertEquals(28, sum.get());
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void forEach() {
		/*
		 * Stream forEach instead of collection iterator (no concurrent modification exception)
		 */
		try {

			AtomicInteger sum = new AtomicInteger(0); 
			
			// List forEach
			Arrays.asList(1,2,3,4,5,6,7).forEach(s->{
				sum.addAndGet(s);
			});
			assertEquals(28, sum.get());
			
			// Map forEach
			toMap("a","1" ,"b","2" ,"c","3" ,"d","4" ,"f","5" ,"g","6" ,"h","7").forEach((k,v)->{
				sum.addAndGet(v);
			});
			assertEquals(56, sum.get());

			// less verbose
			Arrays.asList(1,2,3,4,5,6,7).forEach(sum::addAndGet);
			assertEquals(84, sum.get());

		} catch(Exception e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void MultipleCatch() {
		try {
			if( new Random().nextBoolean() ) {
				throw new NullPointerException("Null");
			} else {
				throw new IOException("IO");
			}
			
		} catch (NullPointerException|IOException e) {
			/*
			 *  e = null; // !!! The parameter e of a multi-catch block cannot be assigned
			 */
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void HashCodeAndEquals() {
		/*
		 * HashCode & Equals agreement in Java
		 */
		assertEquals(
			"If two objects are equal according to the equals(Object) method, then calling the hashcode() method on each of the two objects must produce the same integer result.", 
			"If two objects are equal according to the equals(Object) method, then calling the hashcode() method on each of the two objects must produce the same integer result.");
		
	}
	
	@Test
	public void StringBufferDefSize16() {
		/*
		 * StringBuffer DefaultSize is 16!
		 */
		assertEquals(16, new StringBuffer().capacity());

	}
	
	@Test
	public void CallableInterface() {
		/*
		 * Callable interface is not the same as Runnable
		 */
		Callable<String> callable1 = ()->"Simple";
		Callable<String> callable2 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Not same as Runnable!!!";
			}
		};
		try {
			assertEquals("Simple", callable1.call());
			assertEquals("Not same as Runnable!!!", callable2.call());
		} catch (Exception e) {
		}

	}
	
	@Test
	public void RunnableInterface() {
		/*
		 * Executor can be implemented easily vie lambda
		 */
		
		Executor exec = Runnable::run;
		exec.execute(()->{
			assertEquals(
					":: aplicable to Class if it is @Functional only !!!", 
					":: aplicable to Class if it is @Functional only !!!");
		});
		
	}
	
	@Test
	public void ConcurrentHashMap() {
		/*
		 * ConcurrentHashMap can't use null for key
		 */
		ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<String,String>();
		
		try {
			chm.put(null, "null");
		} catch(Exception e) {
			assertEquals("NullPointerException", e.getClass().getSimpleName());
		}
		
	}
	
	@Test
	public void Predicate() {
		/*
		 * Predicate must implement boolean test<T>
		 */
		Predicate<Integer> checkEvent1 = x->x > 0;
		Predicate<Integer> checkEvent2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x > 0; // boolean!!!
			}
		};
		
		try {
			assertEquals(true, checkEvent1.test(1));
			assertEquals(false, checkEvent2.test(-1));
		} catch(Exception e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void Consumer() {
		/*
		 * Consumer must implement void accept<T>
		 */
		Consumer<String> consumer1 = System.out::println;
		Consumer<String> consumer2 = x->System.out.println(x);
		Consumer<String> consumer3 = x->{
			System.out.println(x);
			assertEquals("Hello", x);
		};
		consumer1.accept("mama");
		consumer2.accept("papa");
		consumer3.accept("Hello");
		
	}
	
	@Test
	public void Supplier() {
		/*
		 * Supplier must implement <T> get method
		 */
		Supplier<String> supplier1 = String::new;
		Supplier<String> supplier2 = ()->new String("Hello");
		
		assertEquals("", supplier1.get());
		assertEquals("Hello", supplier2.get());

		/*
		 * Stream can Skip # of first elements and can reduce to element type 
		 */
		assertEquals("identity34", Arrays.stream(new String[] {"1","2","3","4"}).skip(2).reduce("identity", String::concat));
	}
	
	@Test
	public void JavaUtilFunctionalInterface() {
		/*
		 *  Function  must implement <R>apply<T> method
		 *  
		 *  Defaults:
		 *  
		 *  <T,V>andThen<R,V> 	- implements after apply
		 *  <V,R>compose<V,T> 	- implements before apply 
		 *  <T>identity<T>		- return arg
		 *  converted i.e. mapped 
		 */
		Function<String,Integer> f;
	}
	
	public static Map<String,Integer> toMap(String...keyval){
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i=0,max=keyval.length; i<max; i+=2) {
			map.put(keyval[i], Integer.parseInt(keyval[i+1]));
		}
		return map;
	}
}
