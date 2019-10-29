package java8;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ProveIt {

	@Test
	public void fruits() {
		
		Stream.of("Mango", "Orange", "Banana")
		.filter(fruit->{
			System.out.println("fruits: "+fruit);
			return true;
		});
	}

	@Test
	public void fruits4() {
		
		Stream.of("Mango", "Orange", "Banana")
		.filter(fruit->{
			System.out.println("fruits4: "+fruit);
			return true;
		}).collect(Collectors.toList());
	}

	@Test
	public void fruits2() {
		
		Arrays.asList("Mango", "Orange", "Banana")
		.stream()
		.filter("Orange"::equals)
		.forEach(fruit->{
			System.out.println("fruits2: "+fruit);
		});
	}

	@Test
	public void fruits3() {
		
		Arrays.asList("Mango", "Orange", "Banana")
		.stream()
		.filter(fruit->{
			System.out.println("fruits3: "+fruit);
			return true;
		})
		.forEach(fruit->{
			System.out.println("fruits3: "+fruit);
		});
	}

	public void programmaticJavadoc() {
		//new javax.script.ScriptEngine().eval();
	}
}
