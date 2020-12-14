package codility.maxpair;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

// 100%
public class MaxPair {

	@Test
	public void test1() {
		assertEquals(3, solutionFast(new int[] { 3, 2, -2, 5, -3 }));
		assertEquals(3, solutionSlow(new int[] { 3, 2, -2, 5, -3 }));
	}

	@Test
	public void test2() {
		assertEquals(1, solutionFast(new int[] { 1, 1, 2, -1, 2, -1 }));
		assertEquals(1, solutionSlow(new int[] { 1, 1, 2, -1, 2, -1 }));
	}

	@Test
	public void test3() {
		assertEquals(0, solutionFast(new int[] { 1, 2, 3, -4 }));
		assertEquals(0, solutionSlow(new int[] { 1, 2, 3, -4 }));
	}

	// 1 sort + 1 loop - fastest  
	static public int solutionFast(int[] A) {
		Arrays.parallelSort(A);
		return Arrays.stream(A)
				.filter(e->e > 0? true: Arrays.binarySearch(A, -e) >=0)
				.map(e->e > 0? 0: -e)
				.findFirst()
				.orElse(0);
	}

	// No sort + 1 loop + cache = slow 
	static public int solutionSlow(int[] A) {
		Set<Integer> set = new HashSet<>(Solution2.N);
		return Arrays.stream(A)
				.filter(e->set.contains(-e)? true: set.contains(e)? false: !set.add(e))
				.map(e->Math.abs(e))
				.max()
				.orElse(0);
	}
}
