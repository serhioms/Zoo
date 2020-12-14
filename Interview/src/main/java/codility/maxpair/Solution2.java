package codility.maxpair;

import java.util.Arrays;
import java.util.SplittableRandom;

public class Solution2 {
	public static final int N = 10_000_000;
	public static final int MIN = -100_000_000;
	
	public static void main(String[] args) {
		Solution2 sol2 = new Solution2();
		
		long start = System.currentTimeMillis();
		int[] a = sol2.initArray();
		long time = System.currentTimeMillis() - start;
		System.out.println( "Initialization:" + time + " millisec");
		
		System.out.println( "~~~" );
		
		start = System.currentTimeMillis();
		int solutionResult1 = sol2.solution1(a);
		time = System.currentTimeMillis() - start;
		System.out.println( "solution1 execution: " + time + " millisec solutionResult1: " + solutionResult1);

		System.out.println( "~~~" );
		
		start = System.currentTimeMillis();
		int solutionResult2 = sol2.solution2(a);
		time = System.currentTimeMillis() - start;
		System.out.println( "solution2 execution: " + time + " millisec solutionResult2: " + solutionResult2 );
		
	}
	
	int solution2(int[] A) {
		int maxPairValue = 0;
		int posFound = 0;
		// Algorithm is efficient. It does not create Integer object.
		// It's fast to compare, sort primitives.
		// It's memory efficient to hold array of primitives.
		int[] orderedIntegers = Arrays.stream(A).sorted().toArray();
		
		for (int i = 0; i < orderedIntegers.length; i++) {
			if( orderedIntegers[i] < 0 ) {
				int currentInt = orderedIntegers[i];
				if( binarySearch( -1 * currentInt, orderedIntegers ) ) {
					maxPairValue = currentInt;
					posFound = i;
					break;
				}
			} 
			else { break; } // If we don't have negative any more

		}
		
		return maxPairValue;
	}
	
	int solution1(int[] A) {
		int maxPairValue = 0;
		
		// Algorithm is efficient. It does not create Integer object.
		// It's fast to compare, sort primitives.
		// It's memory efficient to hold array of primitives.
		int[] negativeOnly = Arrays.stream(A).filter( v-> v < 0).sorted().distinct().toArray();
		int[] positiveOnly = Arrays.stream(A).filter( v-> v > 0).sorted().distinct().toArray();
		
		for (int i = 0; i < negativeOnly.length; i++) {
			int currentPositive = -1 * negativeOnly[i];
			if( binarySearch( currentPositive, positiveOnly ) ) {
				maxPairValue = negativeOnly[i];
				break;
			}
		}
		
		return maxPairValue;
	}
	
	private boolean binarySearch( int a, int[] b ) {
		boolean pairFound = false;

		int positionFound = Arrays.binarySearch( b, a);
		
		if( positionFound >= 0 ) {
			pairFound = true;
		}
		
		return pairFound;
	}
	
	public int[] initArray() {

		int[] arr = new SplittableRandom().ints( N, MIN, -1 * MIN ).parallel().toArray();
		
		// Arrays.stream(arr).limit(1000).forEach(System.out::println);
		
		return arr;
	}
}
