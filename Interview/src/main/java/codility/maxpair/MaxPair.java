package codility.maxpair;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

// 75%
public class MaxPair {

	public int solution(int[] A) {
		int maxPairValue = 0;

		// Algorithm is efficient. It does not create Integer object.
		// It's fast to compare, sort primitives.
		// It's memory efficient to hold array of primitives.
		int[] negativeOnly = Arrays.stream(A).filter(v -> v < 0).sorted().distinct().toArray();
		int[] positiveOnly = Arrays.stream(A).filter(v -> v > 0).sorted().distinct().toArray();

		for (int i = 0; i < negativeOnly.length; i++) {
			int currentPositive = -1 * negativeOnly[i];
			if (binarySearch(currentPositive, positiveOnly)) {
				maxPairValue = currentPositive;
				break;
			}
		}

		return maxPairValue;

	}

	private boolean binarySearch(int a, int[] b) {
		boolean pairFound = false;

		int positionFound = Arrays.binarySearch(b, a);

		if (positionFound >= 0) {
			pairFound = true;
		}

		return pairFound;
	}

	@Test
	public void test1() {
		assertEquals(3, solution(new int[] { 3, 2, -2, 5, -3 }));
	}

	@Test
	public void test2() {
		assertEquals(1, solution(new int[] { 1, 1, 2, -1, 2, -1 }));
	}

	@Test
	public void test3() {
		assertEquals(0, solution(new int[] { 1, 2, 3, -4 }));
	}

}
