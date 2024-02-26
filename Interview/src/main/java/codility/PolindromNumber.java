package codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolindromNumber {

	public int solution(int[] S) {
		int[] cnt = new int[10];
		for(int i: S){
			++cnt[i];
		}
		String left = "";
		String right = "";
		for(int i=9; i>0; --i){
			while( cnt[i] > 0 && cnt[i] % 2 == 0){
				left = left + i;
				right = i + right;
				cnt[i] -= 2;
			}
		}
		String result = null;
		for(int i=9; i>=0; --i){
			if( cnt[i] > 0 ){
				result = left+i+right;
				break;
			}
		}
		if( result == null ){
			result = left+right;
		}
		return result.isEmpty()? -1: Integer.parseInt(result);
	}


	@Test
	public void testMaxPolinfromNumber() {
		assertEquals(-1, solution(new int[]{}));
		assertEquals(898, solution(new int[]{3,9,8,7,8}));
		assertEquals(0, solution(new int[]{0,0,0,0}));
		assertEquals(5, solution(new int[]{5,4,3,2,1}));
		assertEquals(9, solution(new int[]{0,9,0}));
		assertEquals(99899, solution(new int[]{1,2,3,4,5,6,7,8,9,9,9,9}));
		assertEquals(9987899, solution(new int[]{1,2,3,4,5,6,7,8,8,9,9,9,9}));
		assertEquals(99099, solution(new int[]{0,9,9,9,9}));
	}
}
