package kenexa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class PTestIt {

	@Test
	public void testFunctionInterface40() {
		Function<String, Integer>	length		= s->s.length();
		Function<Integer, Boolean>	condition	= i->i<10;
		Function<String, Boolean> 	function	= length.andThen(condition);
		
		assertEquals(true, function.apply("Java 8"));
	}

	/*
	 * 41 Method Reference
	 * x->ReferenceDemo.myReference(x)
	 * same as
	 * ReferenceDemo::myReference
	 */
	
	@Test
	public void testStreamSkip42() {
		List<Integer>	numbers		= Arrays.asList(1,2,3,4,5);
		List<Integer>	results		= numbers.stream()
				.skip(2)
				.collect(Collectors.toCollection(ArrayList::new));	
		
		assertEquals("[3, 4, 5]", results.toString());
	}

	/*
	 * 43 Function Package Interface
	 * 
	 * 					  Producer			- does not belong to java.util.function package
	 * java.util.function.Predicate<T>		- belongs
	 * java.util.function.Function<T, R>	- belongs
	 * java.util.function.Consumer<T>		- belongs
	 * java.util.function.Supplier<T>		- belongs
	 */
	
	@Test
	public void testStreamsAndFilters44() {
		
		Stream.of("Mango", "Oranhe", "Banana")
			.filter(fruit->{
				System.out.println("Fruit: "+fruit);
				fail("Nothing will be printed out.");
				return true;
			});
	}
	
	
	@Test
	public void testParallelStream45() {
		List<String> list = new ArrayList<>();

		Stream.of("Mango", "Oranhe", "Banana")
			.parallel()
			.filter(fruit->{
				list.add(fruit);
				return false;
			})
			.forEach(f->{});
		assertEquals(3, list.size());
		assertEquals(true, list.contains("Mango"));
		assertEquals(true, list.contains("Oranhe"));
		assertEquals(true, list.contains("Banana"));
	}
	
	/*
	 * 46 Script Engine Command Line Tool
	 * jps		- command to get PIDs of running JVM processes
	 * javac	- java compiler command
	 * jjs		- command line tool is used for invoke Nashorn java script engine to
	 * 				interpret java scripts.
	 * jdb		- simple command-line debugger for Java classes
	 */
	
	/*
	 * 47 Class File Analyzing Tool
	 * jdeps	- command to analyze statically declared dependences between classes in a .jar or .class
	 * jjs		- ^^^^^
	 * keytool	- command for Key and Certificate Management Tool (generates key Pair, 
	 * 				export/import certificate, List/Delete keystore entries, generate a certificate) 
	 * jarsigner - command to 
	 * 				To sign Java Archive (JAR) files and 
	 * 				To verify the signatures and integrity of signed JAR files. 
	 */
	
	/*
	 * 48 Command Line Startup Flag
	 * -server	optimazi perfomance, extends startup time
	 * -timeout	not a JVM param
	 * -client	reduce startup time to run as quick as possible
	 * -minimal	not a JVM param
	 */
	
	/*49 Memory Tracking Tool
	 * jjs	- ^^^^^
	 * jps	- ^^^^^
	 * jdb	- ^^^^^
	 * jcmd	- diagnostic command requests jcmd <PID> VM.native_memory[summary|detail|baseline...]
	 * 
	 */
	
	/*
	 * 50 Garbage Collectors
	 * G1	- identify duplicated strings in a heap and avoid multiple copies of the strings inside heap
	 */
	@Test
	public void testGC50() {
		char[] sentence = new char[] {'f','o','o'};
		assertEquals(false, new String(sentence) == new String(sentence));
		assertEquals(true, new String(sentence).intern() == new String(sentence).intern());
	}
	
	/*
	 * 51 Bootstrap Class Location
	 * JRE/lib		- Bootstrap ClassLoader - load classes from JRE/lib/rt.jar 
	 *  ^^^^^^^
	 * JRE/lib/ext	- Extension ClassLoader - load classes from JRE/lib/ext or java.ext.dirs 
	 *  ^^^^^^^
	 * -classpath	- Application ClassLoader - load classes from CLASSPATH, -classpath, -cp, Manifest
	 */
	
	
	/*
	 * 52 Keytool Utility
	 * keytool	- command for Key and Certificate Management Tool (generates key Pair, 
	 * 				export/import certificate, List/Delete keystore entries, generate a certificate) 
	 */
	
	/*
	 * 53 Javadoc Package
	 * javautil		-
	 * javax.tools	- ???
	 * java.lang	-
	 * java.io		-
	 */
	
	/*
	 * 54 Class Loader Hierarchy
	 * 1. Bootstrap Classloader
	 * 2. Extension Classloader
	 * 3. System Classpath Classloader
	 */

	/*
	 * 55 Script Engine API Method
	 * eval	- new javax.script.ScriptEngine().eval("");
	 */
	@Test
	public void testScriptEngine55() throws ScriptException {
		ScriptEngine jss = new ScriptEngineManager().getEngineByName("nashorn");
		
		Object eval = jss.eval("1+1");
		assertEquals("2", eval.toString());
	}

	/* 56 JavaScript to Java Interface
	 * ScriptEngine	- interface provides a method to convert JavaScript code to a Java interface reference
	 * 
	 */
	@Test
	public void testScriptEngine56() throws ScriptException, NoSuchMethodException, FileNotFoundException {
		ScriptEngine jss = new ScriptEngineManager().getEngineByName("nashorn");
		
		jss.eval(new FileReader("testScriptEngine56.js"));
		
		Invocable invocable = (Invocable )jss;
		
		Object result = invocable.invokeFunction("fun1", "Peter Parker");
		
		assertEquals("Peter Parker", result.toString());
	}

	@Test
	public void testVariableScopeAndLambda1() {
		String name = "Sir ";

		name = name + "Nelson";
		
		Runnable r = ()->{
			// bla bla bla
			// System.out.println("Welcom: "+name); // error! name must be final or effectively final!
		};
		// bla bla bla
	}
	
	/*
	 * 6 Marker Interface
	 * java.io.Serializable	- marker interface (no methods defined)
	 * java.lang.Cloneable	- marker
	 * java.rmi.Remote		- marker
	 * java.io.Externalizable	- defines 2 methods writeExternal and readExternal
	 */
	


	/*
	 * 10 Optional Class Members
	 * 		Optional.of("foo").orElse("hoo");
	 * 		Optional.of("foo").isPresent();
	 * 	but not if()
	 */
	

	/* 12 Base64 Encoder
	 * 	Base64.getEncoder();
	 *	Base64.getUrlEncoder();
	 *	Base64.getMimeEncoder();
	 *	Base64.getHeaderEncoder();	- does not exists!
	 * 
	 */
	

	@Test
	public void testTimeZoneDisplay13() {
		// <[2021-01-15T12:42:03.486967800-05:00[America/New_York]]>
		System.out.println(ZonedDateTime.now().toString()); 
		
		// 2021-01-15T12:43:50.119103600	-	no info about time zone!!!
		System.out.println(LocalDateTime.now());
		
		// 2021-01-15T12:44:21.559076600-05:00
		System.out.println(OffsetDateTime.now());
		
		// Fri Jan 15 12:44:54 EST 2021
		System.out.println(Calendar.getInstance().getTime());
	}
	

	@Test
	public void testListOfIntegersDetails14() {
		IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
		intSummaryStatistics.accept(1);
		intSummaryStatistics.accept(2);
		intSummaryStatistics.accept(3);
		intSummaryStatistics.accept(4);
		intSummaryStatistics.accept(5);
		
		assertEquals(5, intSummaryStatistics.getCount());
		assertEquals(15, intSummaryStatistics.getSum());
	}

	@Test
	public void testArifmeticException15() {
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		int c1 = a + b;
		assertEquals(-2, c1); // No exception here but dummy result
		
		// Syntax incorrect
		// int c2 = Integer.parseInt(a) + Integer.parseInt(b);

		try {
			int c3 = Math.addExact(a,  b);
			fail("Must be exception");
		}catch(java.lang.ArithmeticException e) {
			// Expected exception
		}catch(Throwable t) {
			fail("Unexpected exception");
		}

		// Syntax incorrect
		//int c4 = Math.sum(a,  b);

	}

	@Test
	public void testSpliterator16() {
		SortedSet<String> set = new TreeSet<String>(Collections.reverseOrder());
		
		set.addAll(Arrays.asList(new String[]{"A","B","C","D"}));
		assertEquals("[D, C, B, A]",  set.toString());
		
		Spliterator<String> spliterator1 = set.spliterator();
		
		// ESTIMATION
		assertEquals(4,  spliterator1.estimateSize());
		assertEquals(4,  spliterator1.getExactSizeIfKnown());

		// COMPARATOR
		Comparator<? super String> comparator = spliterator1.getComparator();
		assertEquals(1,  comparator.compare("A", "B"));
		assertEquals(-1, comparator.compare("B", "A"));
		assertEquals(0,  comparator.compare("B", "B"));
		
		// SPLIT
		Spliterator<String> spliterator2 = spliterator1.trySplit();
		
		List<String> list1 = new ArrayList<String>();
		spliterator1.forEachRemaining(list1::add);
		assertEquals("[B, A]",  list1.toString());
		
		List<String> list2 = new ArrayList<String>();
		spliterator2.forEachRemaining(list2::add);
		assertEquals("[D, C]",  list2.toString());
		
		
	}

	/* 
	 * 17 What is superclass for Error and Exception?
	 * 
	 * public class Exception extends Throwable 
	 * public class Error extends Throwable
	 */

	/*
	 * 18 String Construction Classes
	 * 
	 * 		new StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
	 */
	

	@Test
	public void testCodeOutput19() {
		try {
			int a = 10/0;
			int n[] = new int[2];
			System.out.println(n[3]);
		}catch(ArrayIndexOutOfBoundsException | ArithmeticException e){
			// Syntax error first then decide by zero or arithmetic
			// e = null;
			System.out.println(e);
		}
	}
	
	/*
	 * 20 Runtime Exception Derived Classes
	 * !!!	- class ClassNotFoundException extends ReflectiveOperationException
	 * 		- class NullPointerException extends RuntimeException
	 *  	- class ArithmeticException extends RuntimeException
	 *  	- class IndexOutOfBoundsException extends RuntimeException
	 */

	
	@Test
	public void testConsumerInterface36() {
		Consumer<String> consumer = PTestIt::showConsumer36;
		consumer.accept("1");
		consumer.accept("2");
		consumer.accept("3");
		assertEquals("[1, 2, 3]",  list36.toString());
	}

	static List<String> list36 = new ArrayList<>();
	public static void showConsumer36(String name) {
		list36.add(name);
	}


	@Test
	public void testConsumerInterface37() {
		List<String> list = Arrays.asList("1","2","3");
		
		list.stream().forEach(name->{
			showSupplier37(()->name);
		});
		
		assertEquals("[1, 2, 3]",  list37.toString());
	}

	static List<String> list37 = new ArrayList<>();
	public static void showSupplier37(Supplier<String> name) {
		list37.add(name.get());
	}
	
	
	@Test
	public void testStreamReduce38() {
		List<String> list = Arrays.asList("1","2","3","4");

		// reduction stream allow to produce one single result from a sequence of elements
		String result = list.stream().reduce("foo", String::concat);
		assertEquals("foo1234",  result.toString());
		
		result = list.stream().reduce("foo", (String a, String b)->a);
		assertEquals("foo",  result.toString());
		
		result = list.stream().reduce("foo", (String a, String b)->b);
		assertEquals("4",  result.toString());
		
	}
	
	
	
	
	
	
	@Test
	public void test() {
	}
	
}
