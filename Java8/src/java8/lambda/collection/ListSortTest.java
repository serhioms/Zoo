package java8.lambda.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListSortTest {

	@Test
	public void sortListStrVieStream() {
		
		List<String> list = Arrays.asList("one", "two", "three", "four");
		
		List<String> sorted = list
				.stream()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());
		
		assertTrue(sorted.toString().equals("[FOUR, ONE, THREE, TWO]"));
	}
	
	@Test
	public void sortListIntegerVieCollections() {
		
		List<Integer> list = Arrays.asList(4, 1, 3, 2);
		
		Collections.sort(list, (a, b) -> b.compareTo(a));
		assertEquals("[4, 3, 2, 1]", list.toString());
		
		Collections.sort(list, (a, b) -> a.compareTo(b));
		assertEquals("[1, 2, 3, 4]", list.toString());
	}
	
	@Test
	public void sortListInteger() {
		
		List<Integer> list = Arrays.asList(4, 1, 3, 2);
		
		list.sort((a, b) -> b.compareTo(a));
		assertEquals("[4, 3, 2, 1]", list.toString());
		
		list.sort((a, b) -> a.compareTo(b));
		assertEquals("[1, 2, 3, 4]", list.toString());
	}
	
	@Test
	public void sortListFoo() {
		
		List<Foo> list = Arrays.asList(new Foo("four",4), new Foo("one",1), new Foo("three",3), new Foo("two",2));
		
		list.sort(Comparator.comparing(Foo::getName));
		assertEquals("[[four,4], [one,1], [three,3], [two,2]]", list.toString());
		
		list.sort(Comparator.comparing(Foo::getId));
		assertEquals("[[one,1], [two,2], [three,3], [four,4]]", list.toString());
	}
	
	static public class Foo {
		final private String name;
		final private int id;
		public Foo(String name, int id) {
			this.name = name;
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public int getId() {
			return id;
		}
		@Override
		public String toString() {
			return "["+name+","+id+"]";
		}
		
	}
}
