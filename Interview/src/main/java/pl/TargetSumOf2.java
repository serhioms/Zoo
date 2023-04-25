package pl;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

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
public class TargetSumOf2 {

    public static int[] twoSum(int[] nums, int target) {

        int[] result = null;

        //write your solution here
        Map<String, Integer> map = new HashMap<>(nums.length);

        for (int i = 0, maxi = nums.length; i < maxi; ++i) {
            map.put(Integer.toString(nums[i]), nums[i]);
            int a = target - nums[i];
            if (map.containsKey(Integer.toString(a))) {
                result = new int[]{a, nums[i]};
                break;
            }
        }

        if (result == null) {
            for (int i = 0, maxi = nums.length; i < maxi; ++i) {
                int a = target - nums[i];
                if (map.containsKey(Integer.toString(a))) {
                    result = new int[]{a, nums[i]};
                    break;
                }
            }
        }

        if (result == null) {
            return new int[]{};
        }


        for (int i = 0, maxi = nums.length; i < maxi; ++i) {
            if (nums[i] == result[0]) {
                for (int j = i; j < maxi; ++j) {
                    if (nums[j] == result[1]) {
                        return new int[]{i, j};
                    }
                }
            } else if (nums[i] == result[1]) {
                for (int j = i; j < maxi; ++j) {
                    if (nums[j] == result[0]) {
                        return new int[]{i, j};
                    }
                }
            }
        }


        throw new RuntimeException("Must not be here!");
    }

    @Test
    public void testTargetSumOf2() {
        assertEquals("[0, 1]", Arrays.toString(twoSum(new int[]{2, 7, 11, 3}, 9)));
        assertEquals("[1, 2]", Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        assertEquals("[0, 1]", Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}

