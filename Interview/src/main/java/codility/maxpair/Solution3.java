package codility.maxpair;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

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
		int solutionResult3 = MaxPair.solutionFast(c);
		time = System.currentTimeMillis() - start;
		System.out.println( "solution3 execution: " + time + " millisec solutionResult3: " + solutionResult3 );

		start = System.currentTimeMillis();
		int solutionResult4 = MaxPair.solutionSlow(d);
		time = System.currentTimeMillis() - start;
		System.out.println( "solution4 execution: " + time + " millisec solutionResult4: " + solutionResult4 );

		assertEquals(solutionResult1, solutionResult2);
		assertEquals(solutionResult1, solutionResult3);
		assertEquals(solutionResult1, solutionResult4);

	}


}
