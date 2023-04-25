package coworkersdility.arraysign;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// 100%
public class NewAssignment4 {


	public int calcIntArraySign(int[] A) {
		if( A == null || A.length == 0 ) {
			throw new RuntimeException("Input array must not be empty.");
		}
		boolean minus = false;
		for(int n: A){
			if( n < 0 ) {
				minus = !minus;
			} else if( n == 0 ) {
				return 0;
			}
		}
		return minus? -1: 1;
	}

	@Test
	public void testCalcIntArraySign() {
		assertEquals(1, calcIntArraySign(new int[] { 1, 2, 3 }));
		assertEquals(-1, calcIntArraySign(new int[] { -1, 2, 3 }));
		assertEquals(1, calcIntArraySign(new int[] { -1, -2, 3 }));
		assertEquals(0, calcIntArraySign(new int[] { -1, 0, 3 }));
		assertEquals(-1, calcIntArraySign(new int[] { -100, Integer.MAX_VALUE }));
		assertEquals(1, calcIntArraySign(new int[] { 100, Integer.MAX_VALUE }));
	}

}
