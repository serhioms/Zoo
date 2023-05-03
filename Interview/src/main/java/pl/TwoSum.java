package pl;
/*
 * Click `Run` to execute the snippet below!
 */

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/* Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same 
 * element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
*/

public class TwoSum {

	public int[] solution(int[] nums, int target) {
		for(int i=0,max=nums.length; i<max; ++i){
			for(int j=i+1; j<max; ++j){
				if( nums[i] + nums[j] == target ){
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	@Test
	public void testToSum1() {
		assertEquals("[0, 1]", Arrays.toString(solution(new int[] { 2, 7, 11, 3 }, 9)));
	}

	@Test
	public void testToSum2() {
		assertEquals("[1, 2]", Arrays.toString(solution(new int[] { 3, 2, 4 }, 6)));
	}

	@Test
	public void testToSum3() {
		assertEquals("[0, 1]", Arrays.toString(solution(new int[] { 3, 3 }, 6)));
	}
}
