package codility.maxpair;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class Solution3 {
	@Test
	public void test() {
		Solution2 sol2 = new Solution2();
		
		long start = System.currentTimeMillis();
		int[] a = sol2.initArray();
		int[] b = Arrays.copyOf(a, a.length);
		int[] c = Arrays.copyOf(a, a.length);
		int[] d = Arrays.copyOf(a, a.length);
		long time = System.currentTimeMillis() - start;
		System.out.println( "Initialization:" + time + " millisec");
		
		start = System.currentTimeMillis();
		int solutionResult1 = Math.abs(sol2.solution1(a));
		time = System.currentTimeMillis() - start;
		System.out.println( "solution1 execution: " + time + " millisec solutionResult1: " + solutionResult1);

		start = System.currentTimeMillis();
		int solutionResult2 = Math.abs(sol2.solution2(b));
		time = System.currentTimeMillis() - start;
		System.out.println( "solution2 execution: " + time + " millisec solutionResult2: " + solutionResult2 );

		start = System.currentTimeMillis();
		int solutionResult3 = solution3(c);
		time = System.currentTimeMillis() - start;
		System.out.println( "solution3 execution: " + time + " millisec solutionResult3: " + solutionResult3 );

		start = System.currentTimeMillis();
		int solutionResult4 = solution4(d);
		time = System.currentTimeMillis() - start;
		System.out.println( "solution4 execution: " + time + " millisec solutionResult4: " + solutionResult4 );

		assertEquals(solutionResult1, solutionResult2);
		assertEquals(solutionResult1, solutionResult3);
		assertEquals(solutionResult1, solutionResult4);

	}

	// 1 sort + 1 loop - fastest  
	
	private int solution3(int[] A) {
		Arrays.parallelSort(A);
		return Arrays.stream(A)
				.filter(e->e > 0? true: Arrays.binarySearch(A, -e) >=0)
				.map(e->e > 0? 0: -e)
				.findFirst()
				.orElse(0);
	}

	// No sort + 1 loop + cache = slow 
	
	private int solution4(int[] A) {
		Set<Integer> set = new HashSet<>(Solution2.N);
		return Arrays.stream(A)
				.filter(e->set.contains(-e)? true: set.contains(e)? false: !set.add(e))
				.map(e->Math.abs(e))
				.max()
				.orElse(0);
	}
}
