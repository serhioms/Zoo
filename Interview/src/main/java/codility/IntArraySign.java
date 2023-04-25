package codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// 100%
public class IntArraySign {

	public int solution(int[] A) {
		boolean minus = false;
		for(int n: A){
			if( n == 0 ) {
				return 0;
			} else if( n < 0 ) {
				minus = !minus;
			};
		}
		return minus? -1: 1;
	}

	@Test
	public void testArraySign() {
		assertEquals(1, solution(new int[] { 1, 2, 3 }));
		assertEquals(-1, solution(new int[] { -1, 2, 3 }));
		assertEquals(1, solution(new int[] { -1, -2, 3 }));
		assertEquals(0, solution(new int[] { -1, 0, 3 }));
		assertEquals(-1, solution(new int[] { -100, Integer.MAX_VALUE }));
		assertEquals(1, solution(new int[] { 100, Integer.MAX_VALUE }));
	}

}
