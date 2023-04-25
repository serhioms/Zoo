package pl;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

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

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(1012);

        for(int i=0,sizei=nums.length-2; i<sizei; ++i)

        for(int j=i+1,sizej=sizei+1; j<sizej; ++j)
            for(int k=j+1,sizek=sizej+1; k<sizek; ++k){
                if( checkIsDumNul(nums[i], nums[j], nums[k]) ){
                    List<Integer> r = new ArrayList<>(3);
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    if( isUnique(result, r) ){
                        result.add(r);
                    }
                }
            }

        System.out.println(result);
        System.out.println("....");
        return result;
    }

    private static boolean checkIsDumNul(int a, int b, int c){
        return (a+b+c)==0;
    }

    private static boolean isUnique(List<List<Integer>> result, List<Integer> r){

        Set<String> rs = new HashSet<>();
        r.stream().forEach(e->rs.add(e.toString()));

        for(List<Integer> n: result){
            if ( !isSame(n, rs) ){
                return false;
            }
        }
        return true;
    }

    private static boolean isSame(List<Integer> n, Set<String> rs){
        System.out.println(rs);
        for(Integer i: n){
            System.out.println(i+":"+rs.contains(i.toString()));
            if( !rs.contains(i.toString()) ){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testThreeSum1(){
        List<List<Integer>> threeSumResult = threeSum(new int[] {-1,0,1,2,-1,-4});
        Assert.assertEquals(2, threeSumResult.size());

        Assert.assertEquals(3, threeSumResult.get(0).size());
        Assert.assertTrue(threeSumResult.get(0).contains(-1));
        threeSumResult.get(0).remove(threeSumResult.get(0).indexOf(-1));
        Assert.assertTrue(threeSumResult.get(0).contains(-1));
        threeSumResult.get(0).remove(threeSumResult.get(0).indexOf(-1));
        Assert.assertTrue(threeSumResult.get(0).contains(2));
        threeSumResult.get(0).remove(threeSumResult.get(0).indexOf(2));
        Assert.assertEquals(0, threeSumResult.get(0).size());


        Assert.assertEquals(3, threeSumResult.get(1).size());
        Assert.assertTrue(threeSumResult.get(1).contains(-1));
        threeSumResult.get(1).remove(threeSumResult.get(1).indexOf(-1));
        Assert.assertTrue(threeSumResult.get(1).contains(0));
        threeSumResult.get(1).remove(threeSumResult.get(1).indexOf(0));
        Assert.assertTrue(threeSumResult.get(1).contains(1));
        threeSumResult.get(1).remove(threeSumResult.get(1).indexOf(1));
        Assert.assertEquals(0, threeSumResult.get(1).size());
    }

    @Test
    public void testThreeSum2(){
        List<List<Integer>> threeSumResult = threeSum(new int[] {1, -2, 1, 0, 5});
        Assert.assertEquals(1, threeSumResult.size());

        Assert.assertEquals(3, threeSumResult.get(0).size());
        Assert.assertTrue(threeSumResult.get(0).contains(1));
        threeSumResult.get(0).remove(threeSumResult.get(0).indexOf(1));
        Assert.assertTrue(threeSumResult.get(0).contains(-2));
        threeSumResult.get(0).remove(threeSumResult.get(0).indexOf(-2));
        Assert.assertTrue(threeSumResult.get(0).contains(1));
        threeSumResult.get(0).remove(threeSumResult.get(0).indexOf(1));
        Assert.assertEquals(0, threeSumResult.get(0).size());
    }

    @Test
    public void testThreeSumEmpty(){
        List<List<Integer>> threeSumResult = threeSum(new int[] {});
        Assert.assertEquals(0, threeSumResult.size());
    }

    @Test
    public void testThreeSumZero(){
        List<List<Integer>> threeSumResult = threeSum(new int[] {0});
        Assert.assertEquals(0, threeSumResult.size());
    }
}
