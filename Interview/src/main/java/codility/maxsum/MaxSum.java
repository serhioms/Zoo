package codility.maxsum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSum {

	@Test
	public void test() {
		assertEquals(5, solutionBeautiful(new int[] { 3, 2, -6, 4, 0 }));
		assertEquals(7, solutionBeautiful(new int[] { 3, 2, -6, 7, 0 }));
		assertEquals(6, solutionBeautiful(new int[] { 3, 2, -6, 6, 0 }));
		assertEquals(5, solutionBeautiful(new int[] { 3, 2, -6, 5, 0 }));
		assertEquals(-1000000, solutionBeautiful(new int[] {}));
		assertEquals(-6, solutionBeautiful(new int[] { -6 }));
		assertEquals(-5, solutionBeautiful(new int[] { -6, -5 }));
		assertEquals(0, solutionBeautiful(new int[] { -6, -5, 0 }));
		assertEquals(23, solutionBeautiful(new int[] { 3, 2, -6, 4, 9, 10, 0 }));
		assertEquals(23, solutionBeautiful(new int[] { 3, 2, -5, 4, 9, 10, 0 }));
		assertEquals(24, solutionBeautiful(new int[] { 3, 2, -4, 4, 9, 10, 0 }));
		assertEquals(100, solutionBeautiful(new int[] { 3, 2, -4, 4, 9, 10, 0, -24, 100 }));
		assertEquals(101, solutionBeautiful(new int[] { 3, 2, -4, 4, 9, 10, 0, -23, 100 }));
	}

	public static int solutionBeautiful(int[] A) {
		int max_ending, max_slice;
		
		max_ending = max_slice = -1000000;

		for (int a : A) {
			max_ending = Math.max(a, max_ending + a);
			max_slice = Math.max(max_slice, max_ending);
		}
		return max_slice;
	}

	public static int solutionFast(int[] A) {

		int maxp = Integer.MIN_VALUE, maxn = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0, length = A.length; i < length; ++i) {
			if (A[i] >= 0) {
				sum += A[i];
				maxp = Math.max(maxp, sum);
			} else if ((sum + A[i]) < 0) {
				sum = 0;
				maxn = Math.max(maxn, A[i]);
			} else {
				sum += A[i];
				maxp = Math.max(maxp, sum);
				maxn = Math.max(maxn, A[i]);
			}
		}

		return maxp > Integer.MIN_VALUE ? maxp : maxn > Integer.MIN_VALUE ? maxn : -1000000;
	}

	public static int solutionSlow(int[] A) {

		int maxSum = A[0];

		for (int i = 0, max = A.length; i < max; i++) {
			for (int j = i; j < max; j++) {
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum += A[k];
				}
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
}