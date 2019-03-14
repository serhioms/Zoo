package java8;

/*
 * Static import methods of the class with *
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRulesException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * Java Programming Language
 * 
 * http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
 * https://www.journaldev.com/2389/java-8-features-with-examples
 */
public class Java8Features {

	/*
	 * Lambdas hey enable you to treat functionality as a method argument, or code as data
	 */
	@Test
	public void Java_Lambdas() {fail("Not implemented!");}

	/*
	 * Method references provide easy-to-read lambda expressions for methods that already have a name.
	 */
	@Test
	public void JavaMethodReferences() {fail("Not implemented!");}
	
	/*
	 * Default methods enable new functionality to be added to the interfaces of libraries and ensure 
	 * binary compatibility with code written for older versions of those interfaces.

	 * Default and static methods in interfaces - become similar to abstract classes!
	 * 
	 */
	// @FunctionalInterface  - Java8Features.DefaultAndStatic is not a functional interface !!!
	public interface JavaDefaultAndStatic {
		
		default int defaultMirror(int v) { 
			return v;
		}
		
		static int staticMirror(int v) { 
			return v;
		}
	}


	/*
	 * Repeating Annotations provide the ability to apply the same annotation type more than once to the same declaration or type use.
	 */
	@Test
	public void JavaRepeatingAnnotations() {fail("Not implemented!");}
	
	/*
	 * Type Annotations provide the ability to apply an annotation anywhere a type is used, not just on a declaration. 
	 * Used with a pluggable type system, this feature enables improved type checking of your code.
	 */
	@Test
	public void JavaTypeAnnotations() {fail("Not implemented!");}
	
	/*
	 * Method parameter reflection
	 */
	@Test
	public void JavaMethodParameterReflection() {fail("Not implemented!");}
	
	/*
	 * Improved type inference.
	 * 
	 * @FunctionalInterface - An interface with exactly one abstract method becomes Functional Interface.
	 */
	@Test
	public void JavaImprovedTypeInference()  {fail("Not implemented!");}

	/*
	 * Collections
	 * 
	 * Classes in the new java.util.stream package provide a Stream API to support functional-style operations on streams of elements. 
	 * The Stream API is integrated into the Collections API, which enables bulk operations on collections, such as sequential or 
	 * parallel map-reduce transformations.
	 * 
	 * Performance Improvement for HashMaps with Key Collisions
	 * 
	 * forEach for collections instead of iterator (no concurrent modification exception)
	 */
	/*
	 * Stream API
	 */
	@Test
	public void CollectionsStreamApi() {
		try {

			AtomicInteger sum = new AtomicInteger(0); 
			
			// sequential stream
			Arrays.asList(1,2,3,4,5,6,7).stream().forEach(sum::addAndGet);
			assertEquals(28, sum.get());
			
			// parallel stream
			Arrays.asList(1,2,3,4,5,6,7).parallelStream().forEach(sum::addAndGet);
			assertEquals(56, sum.get());
			
			// filter
			Arrays.asList(1,2,3,4,5,6,7).parallelStream().filter(n->n<2).forEach(sum::addAndGet);
			assertEquals(57, sum.get());

			// stream aggregates
			assertEquals(7, Arrays.stream(new int[] {1,2,3,4,5,6,7}).count());
			assertEquals(28, Arrays.stream(new int[] {1,2,3,4,5,6,7}).sum());
			assertEquals(4.0, Arrays.stream(new int[] {1,2,3,4,5,6,7}).average().getAsDouble(), 0.00000000001);
			assertEquals(1, Arrays.stream(new int[] {1,1,1,1,1,1,1}).distinct().sum());

			// Can't print Stream<int[]> directly, convert / flat it to IntStream 
		    Stream.of(new int[] {1,2,3,4,5,6,7}).flatMapToInt(x -> Arrays.stream(x)).forEach(sum::addAndGet);
			assertEquals(85, sum.get());

			// collect
			assertEquals("[1, 2, 3]", Arrays.stream(new String[] {"1","2","3"}).collect(Collectors.collectingAndThen(Collectors.toList(), Object::toString)) );
			
			// map
			assertEquals("1,2,3", Arrays.stream(new String[] {"1","2","3"}).map(Object::toString).collect(Collectors.joining(",")) );
			assertEquals("1,2,3", Arrays.asList("1","2","3").stream().map(Object::toString).collect(Collectors.joining(",")) );
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	/*
	 * Multiple inheritance Diamond issue resolved by compilation error:
	 * 
	 * 		Duplicate default methods named log with the parameters (String) and 
	 * 		(String) are inherited from the types Java8Features.Interface2 and Java8Features.Interface1
	 */
	public class MyClass implements Interface1, Interface2 {

		@Override
		public void method2() {
		}

		@Override
		public void method1(String str) {
		}

		// MyClass won't compile without having it's own log() implementation
		@Override
		public void log(String str){
			System.out.println("MyClass logging::"+str);
			Interface1.print("abc");
		}
	}


	@FunctionalInterface
	public interface Interface1 {
		void method1(String str);
		
		default void log(String str){
			System.out.println("I1 logging::"+str);
		}
		
		static void print(String str){
			System.out.println("Printing "+str);
		}	
	}
	
	@FunctionalInterface
	public interface Interface2 {
		void method2();
		
		default void log(String str){
			System.out.println("I2 logging::"+str);
		}
	}
	
	/*
	 * Date-Time Package - a new set of packages that provide a comprehensive date-time model.
	 * 
	 * New Date API (https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant)
	 * 
	 * Immutability: All the classes in the new Date Time API are immutable and good for multithreaded environments.
	 * Separation of Concerns: The new API separates clearly between human readable date time and machine time (unix timestamp). 
	 * 		It defines separate classes for Date, Time, DateTime, Timestamp, Timezone etc.
	 * Clarity: The methods are clearly defined and perform the same action in all the classes. For example, to get the 
	 * 		current instance we have now() method. There are format() and parse() methods defined in all these classes rather than 
	 * 		having a separate class for them. All the classes use Factory Pattern and Strategy Pattern for better handling. Once you 
	 * 		have used the methods in one of the class, working with other classes won’t be hard.
	 * Utility operations: All the new Date Time API classes comes with methods to perform common tasks, such as plus, minus, format, 
	 * 		parsing, getting separate part in date/time etc.
	 * Extendable: The new Date Time API works on ISO-8601 calendar system but we can use it with other non ISO calendars as well.
	 */
	@Test
	public void DateTimePackage() {
		try {

			/*
			 *  LocalDate
			 */
			System.out.println("Local date now: "+LocalDate.now()); 										// 2018-04-04
			System.out.println("Local date January 1, 2014: "+LocalDate.of(2014, Month.JANUARY, 1)); 		// 2014-01-01
			
			try {
				System.out.println("Local date January 32, 2014: "+LocalDate.of(2014, Month.JANUARY, 32));
			} catch(DateTimeException e) {
				System.out.println(e.getMessage()); // Invalid value for DayOfMonth (valid values 1 - 28/31): 32
			}

			System.out.println("Local date now Asia/Kolkata: "+LocalDate.now(ZoneId.of("Asia/Kolkata")));	// 2018-04-04
			try {
				System.out.println("Local date now IST: "+LocalDate.now(ZoneId.of("IST")));
			} catch(ZoneRulesException e) {
				System.out.println(e.getMessage()); // Unknown time-zone ID: IST
			}

			// Getting date from the base date i.e 01/01/1970
			System.out.println("Local date ofEpochDay(365): "+LocalDate.ofEpochDay(365));					// 1971-01-01

			System.out.println("Local date ofYearDay(2018, 256): "+LocalDate.ofYearDay(2018, 256));			// 2018-09-13

			/*
			 *  LocalTime
			 */
			System.out.println("Local time now: "+LocalTime.now()); 										// 12:11:58.893
			System.out.println("Local time of: "+LocalTime.of(12,20,25,40));								// 12:20:25.000000040

			try {
				System.out.println("Local time of wrong: "+LocalTime.of(120,20,25,40));
			} catch(DateTimeException e) {
				System.out.println(e.getMessage()); // Invalid value for HourOfDay (valid values 0 - 23): 120
			}

			System.out.println("Local time now Europe/Moscow: "+LocalTime.now(ZoneId.of("Europe/Moscow"))); // 19:15:29.472
			try {
				System.out.println("Local time now IST: "+LocalTime.now(ZoneId.of("IST")));
			} catch(ZoneRulesException e) {
				System.out.println(e.getMessage()); // Unknown time-zone ID: IST
			}

			System.out.println("Local time of: "+LocalTime.ofSecondOfDay(1024*10)); 						// 02:50:40
			
			/*
			 *  LocalDateTime
			 */
			System.out.println("Local date time now: "+LocalDateTime.now()); 										// 2018-04-04T12:19:11.544
			System.out.println("Local date time now: "+LocalDateTime.of(LocalDate.now(), LocalTime.now()));			// 2018-04-04T12:19:11.544
			System.out.println("Local date time of: "+LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30));		// 2014-01-01T10:10:30

			try {
				System.out.println("Local date time of wrong: "+LocalDateTime.of(2014, Month.JANUARY, 100, 10, 10, 30));
			} catch(DateTimeException e) {
				System.out.println(e.getMessage()); // Invalid value for DayOfMonth (valid values 1 - 28/31): 100
			}

			System.out.println("Local date time now Europe/Moscow: "+LocalDateTime.now(ZoneId.of("Europe/Moscow"))); // 2018-04-04T19:21:51.598
			try {
				System.out.println("Local date time now IST: "+LocalDateTime.now(ZoneId.of("IST")));
			} catch(ZoneRulesException e) {
				System.out.println(e.getMessage()); // Unknown time-zone ID: IST
			}

			System.out.println("Local date time of: "+LocalDateTime.ofEpochSecond(1024*10, 0, ZoneOffset.UTC)); 	// 1970-01-01T02:50:40

			/*
			 *  Instant class is used to work with machine readable time format, it stores date time in unix timestamp. 
			 */
			Instant timestamp = Instant.now();
			
			System.out.println("Instant now: "+timestamp);	 														// 2018-04-04T16:25:37.018Z
			System.out.println("Instant now from: "+Instant.ofEpochMilli(timestamp.toEpochMilli())); 				// 2018-04-04T16:25:37.018Z
			System.out.println("Duration.ofDays: "+Duration.ofDays(30)); 											// PT720H
			
			/*
			 * Java 8 Date API Utilities
			 */
			LocalDate today = LocalDate.now();
			
			//Get the Year, check if it's leap year
			System.out.println("Year "+today.getYear()+" is Leap Year? "+today.isLeapYear());
			
			//Compare two LocalDate for before and after
			System.out.println("Today is before 01/01/2015? "+today.isBefore(LocalDate.of(2015,1,1)));
			
			//Create LocalDateTime from LocalDate
			System.out.println("Current Time="+today.atTime(LocalTime.now()));
			
			//plus and minus operations
			System.out.println("10 days after today will be "+today.plusDays(10));
			System.out.println("3 weeks after today will be "+today.plusWeeks(3));
			System.out.println("20 months after today will be "+today.plusMonths(20));

			System.out.println("10 days before today will be "+today.minusDays(10));
			System.out.println("3 weeks before today will be "+today.minusWeeks(3));
			System.out.println("20 months before today will be "+today.minusMonths(20));
			
			//Temporal adjusters for adjusting the dates
			System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
			LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
			System.out.println("Last date of this year= "+lastDayOfYear);
			
			Period period = today.until(lastDayOfYear);
			System.out.println("Period Format= "+period);
			System.out.println("Months remaining in the year= "+period.getMonths());
			
			/*
			 * Date Parsing and Formatting
			 */
			//Format examples
			LocalDate date = LocalDate.now();
			//default format
			System.out.println("Default format of LocalDate="+date);
			//specific format
			System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
			System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			
			
			LocalDateTime dateTime = LocalDateTime.now();
			//default format
			System.out.println("Default format of LocalDateTime="+dateTime);
			//specific format
			System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
			System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
			
			//default format
			System.out.println("Default format of Instant="+timestamp);
			
			//Parse examples
			LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48", DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
			System.out.println("Default format after parsing = "+dt);

			/*
			 * Date API Legacy Date Time Support
			 * Legacy Date/Time classes are used in almost all the applications, so having backward compatibility is a must. 
			 * That’s why there are several utility methods through which we can convert Legacy classes to new classes and 
			 * vice versa. Let’s see this with a simple example.
			 */
			
			//Date to Instant
			Instant timestamp2 = new Date().toInstant();
			//Now we can convert Instant to LocalDateTime or other similar classes
			LocalDateTime date2 = LocalDateTime.ofInstant(timestamp2, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
			System.out.println("Date = "+date2);
			
			//Calendar to Instant
			Instant time = Calendar.getInstance().toInstant();
			System.out.println(time);
			
			//TimeZone to ZoneId
			ZoneId defaultZone = TimeZone.getDefault().toZoneId();
			System.out.println(defaultZone);
			
			//ZonedDateTime from specific Calendar
			ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
			System.out.println(gregorianCalendarDateTime);
			
			//Date API to Legacy classes
			Date dt2 = Date.from(Instant.now());
			System.out.println(dt2);
			
			TimeZone tz = TimeZone.getTimeZone(defaultZone);
			System.out.println(tz);
			
			GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
			System.out.println(gc);
			
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	

	/*
	 * Security
	 * Client-side TLS 1.2 enabled by default
	 * New variant of AccessController.doPrivileged that enables code to assert a subset of its privileges, without preventing the full traversal of the stack to check for other permissions
	 * 
	 * Stronger algorithms for password-based encryption
	 * 
	 * SSL/TLS Server Name Indication (SNI) Extension support in JSSE Server
	 * 
	 * Support for AEAD algorithms: The SunJCE provider is enhanced to support AES/GCM/NoPadding cipher implementation as well as GCM algorithm parameters. And the SunJSSE provider is enhanced to support AEAD mode based cipher suites. See Oracle Providers Documentation, JEP 115.
	 * 
	 * KeyStore enhancements, including the new Domain KeyStore type java.security.DomainLoadStoreParameter, and the new command option -importpassword for the keytool utility
	 * 
	 * SHA-224 Message Digests
	 * 
	 * Enhanced Support for NSA Suite B Cryptography
	 * 
	 * Better Support for High Entropy Random Number Generation
	 * 
	 * New java.security.cert.PKIXRevocationChecker class for configuring revocation checking of X.509 certificates
	 * 
	 * 64-bit PKCS11 for Windows
	 * 
	 * New rcache Types in Kerberos 5 Replay Caching
	 * 
	 * Support for Kerberos 5 Protocol Transition and Constrained Delegation
	 * 
	 * Kerberos 5 weak encryption types disabled by default
	 * 
	 * Unbound SASL for the GSS-API/Kerberos 5 mechanism
	 * 
	 * SASL service for multiple host names
	 * 
	 * JNI bridge to native JGSS on Mac OS X
	 * 
	 * Support for stronger strength ephemeral DH keys in the SunJSSE provider
	 * 
	 * Support for server-side cipher suites preference customization in JSSE
	 */
	@Test
	public void Security() {fail("Not implemented!");}

	/*
	 * JavaFX
	 * The new Modena theme has been implemented in this release. For more information, see the blog at fxexperience.com.
	 * 
	 * The new SwingNode class enables developers to embed Swing content into JavaFX applications. See the SwingNode javadoc and Embedding Swing Content in JavaFX Applications.
	 * 
	 * The new UI Controls include the DatePicker and the TreeTableView controls.
	 * 
	 * The javafx.print package provides the public classes for the JavaFX Printing API. See the javadoc for more information.
	 * 
	 * The 3D Graphics features now include 3D shapes, camera, lights, subscene, material, picking, and antialiasing. The new Shape3D (Box, Cylinder, MeshView, and Sphere subclasses), SubScene, Material, PickResult, LightBase (AmbientLight and PointLight subclasses) , and SceneAntialiasing API classes have been added to the JavaFX 3D Graphics library. The Camera API class has also been updated in this release. See the corresponding class javadoc for javafx.scene.shape.Shape3D, javafx.scene.SubScene, javafx.scene.paint.Material, javafx.scene.input.PickResult, javafx.scene.SceneAntialiasing, and the Getting Started with JavaFX 3D Graphics document.
	 * 
	 * The WebView class provides new features and improvements. Review Supported Features of HTML5 for more information about additional HTML5 features including Web Sockets, Web Workers, and Web Fonts.
	 * 
	 * Enhanced text support including bi-directional text and complex text scripts such as Thai and Hindi in controls, and multi-line, multi-style text in text nodes.
	 * 
	 * Support for Hi-DPI displays has been added in this release.
	 * 
	 * The CSS Styleable* classes became public API. See the javafx.css javadoc for more information.
	 * 
	 * The new ScheduledService class allows to automatically restart the service.
	 * 
	 * JavaFX is now available for ARM platforms. JDK for ARM includes the base, graphics and controls components of JavaFX.
	 */
	@Test
	public void JavaFX() {fail("Not implemented!");}
	
	/*
	 * Tools
	 * The jjs command is provided to invoke the Nashorn engine.
	 * 
	 * The java command launches JavaFX applications.
	 * 
	 * The java man page has been reworked.
	 * 
	 * The jdeps command-line tool is provided for analyzing class files.
	 * 
	 * Java Management Extensions (JMX) provide remote access to diagnostic commands.
	 * 
	 * The jarsigner tool has an option for requesting a signed time stamp from a Time Stamping Authority (TSA).
	 * 
	 * Javac tool
	 * 
	 * The -parameters option of the javac command can be used to store formal parameter names and enable the Reflection API to retrieve formal parameter names.
	 * 
	 * The type rules for equality operators in the Java Language Specification (JLS) Section 15.21 are now correctly enforced by the javac command.
	 * 
	 * The javac tool now has support for checking the content of javadoc comments for issues that could lead to various problems, such as invalid HTML or accessibility issues, in the files that are generated when javadoc is run. The feature is enabled by the new -Xdoclint option. For more details, see the output from running "javac -X". This feature is also available in the javadoc tool, and is enabled there by default.
	 * 
	 * The javac tool now provides the ability to generate native headers, as needed. This removes the need to run the javah tool as a separate step in the build pipeline. The feature is enabled in javac by using the new -h option, which is used to specify a directory in which the header files should be written. Header files will be generated for any class which has either native methods, or constant fields annotated with a new annotation of type java.lang.annotation.Native.
	 * 
	 */
	@Test
	public void Tools() {fail("Not implemented!");}
	
	/*
	 * Javadoc tool
	 * The javadoc tool supports the new DocTree API that enables you to traverse Javadoc comments as abstract syntax trees.
	 * 
	 * The javadoc tool supports the new Javadoc Access API that enables you to invoke the Javadoc tool directly from a Java 
	 * application, without executing a new process. See the javadoc what's new page for more information.
	 * 
	 * The javadoc tool now has support for checking the content of javadoc comments for issues that could lead to various problems, 
	 * such as invalid HTML or accessibility issues, in the files that are generated when javadoc is run. The feature is enabled 
	 * by default, and can also be controlled by the new -Xdoclint option. For more details, see the output from running 
	 * "javadoc -X". This feature is also available in the javac tool, although it is not enabled by default ther
	 */
	@Test
	public void JavadocTool() {fail("Not implemented!");}
	
	/*
	 * Internationalization
	 *
	 * Unicode Enhancements, including support for Unicode 6.2.0
	 * 
	 * Adoption of Unicode CLDR Data and the java.locale.providers System Property
	 * 
	 * New Calendar and Locale APIs
	 * 
	 * Ability to Install a Custom Resource Bundle as an Extension 
	 */
	@Test
	public void Internationalization() {fail("Not implemented!");}
	
	/*
	 * Deployment
	 * 
	 * For sandbox applets and Java Web Start applications, URLPermission is now used to allow connections back to the server from 
	 * which they were started. SocketPermission is no longer granted.
	 * 
	 * The Permissions attribute is required in the JAR file manifest of the main JAR file at all security levels.
	*/
	@Test
	public void Deployment() {fail("Not implemented!");}
	
	/*
	 * Scripting
	 * 
	 * The Rhino javascript engine has been replaced with the Nashorn Javascript Engine
	 */
	@Test
	public void Scripting() {fail("Not implemented!");}
	
	/*
	 * Pack200
	 * Pack200 Support for Constant Pool Entries and New Bytecodes Introduced by JSR 292
	 * JDK8 support for class files changes specified by JSR-292, JSR-308 and JSR-335
	 */
	@Test
	public void Pack200() {fail("Not implemented!");}
	
	/*
	 * IO and NIO
	 * 
	 * New SelectorProvider implementation for Solaris based on the Solaris event port mechanism. To use, run with the system 
	 * property java.nio.channels.spi.Selector set to the value sun.nio.ch.EventPortSelectorProvider.
	 * 
	 * Decrease in the size of the <JDK_HOME>/jre/lib/charsets.jar file
	 * 
	 * Performance improvement for the java.lang.String(byte[], *) constructor and the java.lang.String.getBytes() metho
	 */
	@Test
	public void IOAndNIO() {fail("Not implemented!");}
	
	/*
	 * java.lang and java.util Packages
	 * 
	 * Parallel Array Sorting
	 * 
	 * Standard Encoding and Decoding Base64
	 * 
	 * Unsigned Arithmetic Support
	 */
	@Test
	public void JavaLangUtil() {fail("Not implemented!");}
	
	/*
	 * JDBC
	 * 
	 * The JDBC-ODBC Bridge has been removed.
	 * 
	 * JDBC 4.2 introduces new features.
	 */
	@Test
	public void JDBC() {fail("Not implemented!");}
	
	/*
	 * Java DB - JDK 8 includes Java DB 10.10
	 */
	@Test
	public void JavaDB() {fail("Not implemented!");}
	
	/*
	 * Networking
	 * 
	 * The class java.net.URLPermission has been added.
	 * 
	 * In the class java.net.HttpURLConnection, if a security manager is installed, calls that request to open a connection 
	 * require permission.
	 */
	@Test
	public void Networking() {fail("Not implemented!");}
	
	/*
	 * Concurrency
	 * 
	 * Classes and interfaces have been added to the java.util.concurrent package.
	 * 
	 * Methods have been added to the java.util.concurrent.ConcurrentHashMap class to support aggregate 
	 * operations based on the newly added streams facility and lambda expressions.
	 * 
	 * Classes have been added to the java.util.concurrent.atomic package to support scalable updatable variables.
	 * 
	 * Methods have been added to the java.util.concurrent.ForkJoinPool class to support a common pool.
	 * 
	 * The java.util.concurrent.locks.StampedLock class has been added to provide a capability-based lock with 
	 * three modes for controlling read/write access. 
	 */
	@Test
	public void Concurrency() {fail("Not implemented!");}
	
	/*
	 * Java XML - JAXP
	 */
	@Test
	public void JavaXMLJAXP() {fail("Not implemented!");}
	
	/*
	 * HotSpot
	 * 
	 * Hardware intrinsics were added to use Advanced Encryption Standard (AES). The UseAES and UseAESIntrinsics flags 
	 * are available to enable the hardware-based AES intrinsics for Intel hardware. The hardware must be 2010 or newer 
	 * Westmere hardware. For example, to enable hardware AES, use the following flags:
	 * 
	 * -XX:+UseAES -XX:+UseAESIntrinsics
	 * To disable hardware AES use the following flags:
	 * 
	 * -XX:-UseAES -XX:-UseAESIntrinsics
	 * Removal of PermGen.
	 * 
	 * Default Methods in the Java Programming Language are supported by the byte code instructions for method invocation.
	 */
	@Test
	public void HotSpot() {fail("Not implemented!");}
	
	/*
	 * Java Mission Control 5.3 Release Notes - JDK 8 includes Java Mission Control 5.3.
	 */
	@Test
	public void JavaMissionControl() {fail("Not implemented!");}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Map<String,Integer> toMap(String...keyval){
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i=0,max=keyval.length; i<max; i+=2) {
			map.put(keyval[i], Integer.parseInt(keyval[i+1]));
		}
		return map;
	}
}
