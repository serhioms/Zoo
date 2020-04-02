package ca.mss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Test;

public class TestListIterator implements Supplier<Integer> {

	private static int counter = 0;
	private int i = 0;

	public TestListIterator() {
		i = counter++;
	}

	@Override
	public Integer get() {
		return i;
	}

	@Test
	public void test() {
		List<TestListIterator> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			list.add(new TestListIterator());
		}
		
		List<Integer> output = list.stream().map(Supplier::get).collect(Collectors.toList());
		
		List<Integer> output3 = list.parallelStream().map(Supplier::get).collect(Collectors.toList());
		
		System.out.println(list);
		System.out.println(output);
		System.out.println(output3);
		
		//assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", output.toString());
		
		List<Integer> output2 = StreamSupport.stream(list.spliterator(), true)
				.map(Supplier::get).collect(Collectors.toList());
		
		System.out.println(output2);
		
		AtomicInteger count = new AtomicInteger(0);
		list.parallelStream().map(Supplier::get).map(i->{
				switch(count.incrementAndGet()){
					case 1: return "["+i+", "; 
					case 10: return i+"]"; 
					default: return i+", ";
				}
			}).forEach(System.out::print);
		
		System.out.println("");
		
		List<String> output4 = list.parallelStream()
				.map(Supplier::get).map(i->{
					switch(count.incrementAndGet()){
						default: return String.format("%d", i);
					}
				}).collect(Collectors.toList());
		
		System.out.println(output4);

	
		list.stream().map(Supplier::get).map(i->i+" ").forEach(System.out::print);
		System.out.println("");
		list.parallelStream().map(Supplier::get).map(i->i+" ").forEach(System.out::print);
		System.out.println("");
		
	}
	
}
