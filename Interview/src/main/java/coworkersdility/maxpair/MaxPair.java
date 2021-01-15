package coworkersdility.maxpair;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

// 100%
public class MaxPair {

	@Test
	public void test1() {
		assertEquals(3, solutionFastest(new int[] { 3, 2, -2, 5, -3 }));
		assertEquals(3, solutionFast(new int[] { 3, 2, -2, 5, -3 }));
		assertEquals(3, solutionSlow(new int[] { 3, 2, -2, 5, -3 }));
	}

	@Test
	public void test2() {
		assertEquals(1, solutionFastest(new int[] { 1, 1, 2, -1, 2, -1 }));
		assertEquals(1, solutionFast(new int[] { 1, 1, 2, -1, 2, -1 }));
		assertEquals(1, solutionSlow(new int[] { 1, 1, 2, -1, 2, -1 }));
	}

	@Test
	public void test3() {
		assertEquals(0, solutionFastest(new int[] { 1, 2, 3, -4 }));
		assertEquals(0, solutionFast(new int[] { 1, 2, 3, -4 }));
		assertEquals(0, solutionSlow(new int[] { 1, 2, 3, -4 }));
	}

	// 1 sort + 1 loop - fastest  

	static public int solutionFastest(int[] A) {
		Arrays.parallelSort(A);
		int n = 0;
		long start = System.nanoTime();
		for(int e: A) {
			if(e > 0) {
				break;
			}
			if( Arrays.binarySearch(A, -e) >= 0 ) {
				n = Math.abs(e);
				break;
			}
		}
		long time = System.nanoTime() - start;
		System.out.println( "solutionFastest search = "+time+" nano");
		return n;
	}
	
	// 1 sort + 1 loop - fast = Java 8 stream sucks!  
	static public int solutionFast(int[] A) {
		Arrays.parallelSort(A);
		long start = System.nanoTime();
		int n = Arrays.stream(A)
				.filter(e->e<0)
				.filter(e->Arrays.binarySearch(A, -e) >=0)
				.map(Math::abs)
				.findFirst()
				.orElse(0);
		long time = System.nanoTime() - start;
		System.out.println( "solutionFast search = "+time+" nano");
		return n;
	}

	// No sort + 1 loop + cache = slow 
	static public int solutionSlow(int[] A) {
		Set<Integer> set = new HashSet<>(Solution2.N);
		long start = System.nanoTime();
		int n = Arrays.stream(A)
				.filter(e->set.contains(-e)? true: set.contains(e)? false: !set.add(e))
				.map(Math::abs)
				.max()
				.orElse(0);
		long time = System.nanoTime() - start;
		System.out.println( "solutionSlow search = "+time+" nano");
		return n;
	}
}
