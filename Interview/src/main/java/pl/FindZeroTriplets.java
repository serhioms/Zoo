package pl;

/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.*;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all triplets in the array which gives the sum of
 * zero.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */

public class FindZeroTriplets {

    public List<List<Integer>> threeSum(int[] nums) {
        int count = 0;
        Map<String, List<Integer>> map = new HashMap<>(1024);
        Set<Integer> set = new HashSet<>(1024);
        for(int i=0,max=nums.length; i<max; ++i) {
            for (int j = i + 1; j < max; ++j) {
                // no need looking for the same pair as before = for the same sum as before!
                if( set.contains(nums[i] + nums[j]) ){
                    continue;
                }
                set.add(nums[i] + nums[j]);
                for (int k = j + 1; k < max; ++k) {
                    if ( nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> collection = new ArrayList<>(3);
                        collection.add(nums[i]);
                        collection.add(nums[j]);
                        collection.add(nums[k]);
                        Collections.sort(collection);
                        map.put(collection.toString(), collection);
                        ++count;
                        break; // No need looking for the next same value for the 3rd number
                    }
                }
            }
        }
        System.out.println("["+Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(","))+"] = "+count);

        List<List<Integer>> list = new ArrayList<>(map.size());
        list.addAll(map.values());
        return list;
    }

    @Test
    public void testThreeSum1(){
        Assert.assertEquals("[[-1, 0, 1], [-1, -1, 2]]", threeSum(new int[] {-1,0,1,2,-1,0,-4,1}).toString()); // 9, 8, 3
    }

    @Test
    public void testThreeSum2(){
        Assert.assertEquals("[[-2, 1, 1]]", threeSum(new int[] {1, -2, -2, 1, 1, 0, 5}).toString()); // 6, 4, 1
    }

    @Test
    public void testThreeSum3(){
        Assert.assertEquals("[]", threeSum(new int[] {}).toString()); // 0, 0, 0
    }
}
