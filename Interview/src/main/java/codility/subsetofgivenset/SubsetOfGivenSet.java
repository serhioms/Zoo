package codility.subsetofgivenset;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

import org.junit.Test;

public class SubsetOfGivenSet {

	@Test
	public void test() {
		String result = "";
		
		AllSubsetOfGivenSet<String> subset = new AllSubsetOfGivenSet<>(new HashSet<>(Arrays.asList("A", "B", "C", "D")));
		while (subset.hasNext()) {
			result += subset.next() + ";";
		}

		assertEquals("[A, B, C, D];[A, B, C];[A, B, D];[A, B];[A, C];[A, D];[A];[B, C, D];[B, C];[B, D];[B];[C, D];[C];[D];", result);
}

	static public class AllSubsetOfGivenSet<T> implements Iterator<Set<T>> {

		private final int max;
		private final Object[] array;
		private final Stack<Integer> stack = new Stack<>();

		public AllSubsetOfGivenSet(Set<T> set) {
			this.max = set.size();
			this.array = new Object[max];
			set.toArray(array);
			IntStream.range(0, max).forEach(stack::add);
		}

		@Override
		public boolean hasNext() {
			return stack.size() > 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<T> next() {

			Set<T> subset = new HashSet<>();
			stack.stream().forEach(i -> subset.add((T) array[i]));

			int next = stack.pop();

			if (stack.size() == 0) {
				IntStream.range(++next, max).forEach(stack::add);
			} else if (++next < max) {
				stack.push(next);
			}
			return subset;
		}

	}
}
