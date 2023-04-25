package codility.maxpair;

import org.junit.Test;

import java.util.Arrays;
import java.util.SplittableRandom;

import static org.junit.Assert.assertEquals;

public class MaxPairInet {

    public static final int N = 10_000_000;
    public static final int MIN = -100_000_000;

	int solution2(int[] A) {
		int maxPairValue = 0;
		// Algorithm is efficient. It does not create Integer object.
		// It's fast to compare, sort primitives.
		// It's memory efficient to hold array of primitives.
		int[] orderedIntegers = Arrays.stream(A).sorted().toArray();

		for (int i = 0; i < orderedIntegers.length; i++) {
			if (orderedIntegers[i] < 0) {
				int currentInt = orderedIntegers[i];
				if (binarySearch(-1 * currentInt, orderedIntegers)) {
					maxPairValue = currentInt;
					break;
				}
			} else {
				break;
			} // If we don't have negative any more

		}

		return maxPairValue;
	}

	int solution1(int[] A) {
		int maxPairValue = 0;

		// Algorithm is efficient. It does not create Integer object.
		// It's fast to compare, sort primitives.
		// It's memory efficient to hold array of primitives.
		int[] negativeOnly = Arrays.stream(A).filter(v -> v < 0).sorted().distinct().toArray();
		int[] positiveOnly = Arrays.stream(A).filter(v -> v > 0).sorted().distinct().toArray();

		for (int i = 0; i < negativeOnly.length; i++) {
			int currentPositive = -1 * negativeOnly[i];
			if (binarySearch(currentPositive, positiveOnly)) {
				maxPairValue = negativeOnly[i];
				break;
			}
		}

		return maxPairValue;
	}

	static public boolean binarySearch(int a, int[] b) {
		boolean pairFound = false;

		int positionFound = Arrays.binarySearch(b, a);

		if (positionFound >= 0) {
			pairFound = true;
		}

		return pairFound;
	}

	static public int[] initArray() {

		int[] arr = new SplittableRandom().ints(N, MIN, -1 * MIN).parallel().toArray();

		// Arrays.stream(arr).limit(1000).forEach(System.out::println);

		return arr;
	}

	@Test
	public void testCmpMaxPairInet() {
		MaxPairInet sol2 = new MaxPairInet();

		long start = System.currentTimeMillis();
		int[] a = MaxPairInet.initArray();
		int[] b = Arrays.copyOf(a, a.length);
		int[] c = Arrays.copyOf(a, a.length);
		int[] d = Arrays.copyOf(a, a.length);
		int[] s = Arrays.copyOf(a, a.length);
		Arrays.parallelSort(s);

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
		int solutionResult3 = MaxPairMy.solutionFast(c);
		time = System.currentTimeMillis() - start;
		System.out.println( "solutionFast execution: " + time + " millisec solutionResult3: " + solutionResult3);

		start = System.currentTimeMillis();
		int solutionResult4 = MaxPairMy.solutionFastest(d);
		time = System.currentTimeMillis() - start;
		System.out.println( "solutionFastest execution: " + time + " millisec solutionResult4: " + solutionResult4);

		start = System.currentTimeMillis();
		int solutionResult5 = MaxPairMy.solutionSlow(d);
		time = System.currentTimeMillis() - start;
		System.out.println( "solutionSlow execution: " + time + " millisec solutionResult5: " + solutionResult5 );

		assertEquals(solutionResult1, solutionResult2);
		assertEquals(solutionResult1, solutionResult3);
		assertEquals(solutionResult1, solutionResult5);

	}

}
