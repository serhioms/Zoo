package codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProductOf3 {

	static public int solution(int[] A) {
		int largest3 = 0;

		// Try to find up to 3 largest positive numbers & up to 3 smallest negative
		// numbers
		int[] positiveLargest = { 0, 0, 0 };
		int[] negativeSmallest = { 0, 0, 0 };

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				if (A[i] > positiveLargest[2]) {
					positiveLargest[0] = positiveLargest[1];
					positiveLargest[1] = positiveLargest[2];
					positiveLargest[2] = A[i];
				} else {
					if (A[i] > positiveLargest[1]) {
						positiveLargest[0] = positiveLargest[1];
						positiveLargest[1] = A[i];
					} else if (A[i] > positiveLargest[0]) {
						positiveLargest[0] = A[i];
					}
				}

			} else if (A[i] < 0) {
				if (A[i] < negativeSmallest[2]) {
					negativeSmallest[0] = negativeSmallest[1];
					negativeSmallest[1] = negativeSmallest[2];
					negativeSmallest[2] = A[i];
				} else {
					if (A[i] < negativeSmallest[1]) {
						negativeSmallest[0] = negativeSmallest[1];
						negativeSmallest[1] = A[i];
					} else if (A[i] < negativeSmallest[0]) {
						negativeSmallest[0] = A[i];
					}
				}
			}
		}

		// Largest multiplication would be in 2 situations:
		// 3 largest positive or one largestPositive times by 2 smallest negatives
		// if all 3 positives > 0 then
		largest3 = positiveLargest[0] * positiveLargest[1] * positiveLargest[2];

		int negativeSmallest3 = negativeSmallest[1] * negativeSmallest[2] * positiveLargest[2];

		if (negativeSmallest3 > largest3) {
			largest3 = negativeSmallest3;
		}

		return largest3;
	}

	@Test
	public void testMaxProductOf3() {
		assertEquals(60, solution(new int[] { -3, 1, 2, 2, 5, 6 }));
		assertEquals(3600, solution(new int[] {  -3, 1, 2, -60, 2, -10, 5, 6}));
	}

}