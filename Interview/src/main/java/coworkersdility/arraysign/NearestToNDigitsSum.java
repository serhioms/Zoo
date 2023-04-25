package coworkersdility.arraysign;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// 100%
public class NearestToNDigitsSum {

	public int solution(int N) {
		int lookingFor2TimesBigger = digitSum(N) * 2, nearestLargeThenN = N;
		while (!(digitSum(++nearestLargeThenN) == lookingFor2TimesBigger)) {
			if( nearestLargeThenN <= 0 ) {
				return -1;
			}
		}
		return nearestLargeThenN;
	}

	public int digitSum(int N) {
		int sum = 0;
		for (int i = N; i > 0; i = i / 10) {
			sum += i % 10;
		}
		return sum;
	}

	@Test
	public void testCalcIntArraySign() {
		assertEquals(19, solution(14));
		assertEquals(11, solution(10));
		assertEquals(9999, solution(99));
		assertEquals(699, solution(444));
		assertEquals(1234599999, solution(1234554321));
		assertEquals(-1, solution(Integer.MAX_VALUE-100));
	}

}
