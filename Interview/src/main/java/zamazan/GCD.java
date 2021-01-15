package zamazan;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class GCD {

	@Test
	public void test1() {
		assertEquals(2, generalizedGCD(5, new int[] { 4, 8, 0, 10 }));
		assertEquals(1, generalizedGCD(5, new int[] { 3, 5, 7, 9 }));
		assertEquals(2, generalizedGCD(5, new int[] { 2, 4, 6, 0, 10 }));
		assertEquals(2, generalizedGCD(5, new int[] { 2, 4, 6, 8, 10 }));
		assertEquals(2, generalizedGCD(5, new int[] { 2, 4, 6, 8, 10, 11, 12, 13 }));
		assertEquals(2, generalizedGCD(5, new int[] { 2, 4, 6 }));
		assertEquals(0, generalizedGCD(-5, new int[] { 2, 4, 6 }));
		assertEquals(0, generalizedGCD(0, new int[] { 2, 4, 6 }));
		assertEquals(0, generalizedGCD(5, new int[] {}));
		assertEquals(0, generalizedGCD(5, null));
	}

	public int generalizedGCD(int num, int[] arr) {
		if (arr == null || arr.length == 0 || num <= 0) {
			return 0;
		}

		num = Math.min(num, arr.length);

		int min = Arrays.stream(arr).limit(num).filter(e -> e > 0).min().orElse(1);

		for (int m = min; m >= 1; m--) {
			if (isGCD(num, arr, m) == m) {
				return m;
			}
		}

		return 0;
	}

	public int isGCD(int num, int[] arr, int gcd) {
		for (int i = 0; i < num; i++) {
			if (arr[i] > 0) {
				if ( arr[i] % gcd != 0) {
					return -1;
				}
			}
		}
		return gcd;
	}
}