package bns.subset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubSets implements Iterator<Stream<Integer>> {

	private final int max;
	private Integer[] arr;
	private Stack<Integer> stack;

	public SubSets(int max) {
		this.max = max;
	}

	@Override
	public boolean hasNext() {
		if( stack == null ) {
			return true;
		} else if( stack.size() > 0 ) {
			return true;
		} else {
			arr = null;
			stack = null;
			return false;
		}
	}

	@Override
	public Stream<Integer> next() {
		if( stack == null ) {
			arr = new Integer[max];
			stack = new Stack<>();
			IntStream.range(0, max).forEach(stack::add);
		}
		Stream<Integer> next = Arrays.stream(stack.toArray(arr)).limit(stack.size());
		IntStream.range(stack.pop()+1, max).forEach(stack::add);
		return next;
	}

	public void next(Function<Stack<Integer>, Integer> process) {

		if( stack == null ) {
			stack = new Stack<>();
			IntStream.range(0, max).forEach(stack::add);
		}

		int index = process.apply(stack);

		if( index == 0 ){
			IntStream.range(stack.pop()+1, max).forEach(stack::add);
		} else if( index == -1 ){
			int first = stack.firstElement() + 1;
			stack.clear();
			IntStream.range(first, max).forEach(stack::add);
		} else {
			int mid = stack.get(index)+1;
			stack.setSize(index);
			IntStream.range(mid, max).forEach(stack::add);
		}
	}

}
