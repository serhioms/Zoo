package scotia.subset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubSets implements Iterator<Stream<Integer>>{

	private final int max;
	private final Integer[] arr;
	private Stack<Integer> stack;

	public SubSets(int max) {
		this.max = max;
		this.arr = new Integer[max];
	}

	@Override
	public boolean hasNext() {
		if( stack == null ) {
			return true;
		} else if( stack.size() > 0 ) {
			return true;
		} else {
			stack = null;
			return false;
		}
	}

	@Override
	public Stream<Integer> next() {
		if( stack == null ) {
			stack = new Stack<>();
			IntStream.range(0, max).forEach(stack::add);
		}
		
		Stream<Integer> next = Arrays.stream(stack.toArray(arr)).limit(stack.size());
		
		int last = stack.pop()+1;
		if (stack.size() == 0) {
			IntStream.range(last, max).forEach(stack::add);
		} else if (last < max) {
			stack.push(last);
		}
		return next;
	}
}
