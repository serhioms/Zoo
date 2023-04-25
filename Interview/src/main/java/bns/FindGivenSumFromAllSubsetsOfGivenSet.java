package bns;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class FindGivenSumFromAllSubsetsOfGivenSet {

    public static List<String> solution(int[] nums, int targetSum) {
        int max = nums.length;

        Stack<Integer> stack = new Stack<>();
        IntStream.range(0, max).forEach(stack::add); // populate indexes

        List<String> result = new ArrayList<>(12);
        while (stack.size() > 0) {

            int sum = stack.stream().mapToInt(i -> nums[i]).sum();

            if (sum == targetSum) {
                result.add("["+stack.stream().map(i -> Integer.toString(nums[i])).collect(Collectors.joining(","))+"]");
            }

            int last = stack.pop() + 1;

            if (stack.size() == 0) {
                IntStream.range(last, max).forEach(stack::add); // populate indexes
            } else if (last < max) {
                stack.push(last);
            }
        }
        return result;
    }

    @Test
    public void testFindGivenSumFromAllSubsetsOfGivenSet(){
        assertEquals("[[3,9], [4,8]]", solution(new int[]{3, 4, 6, 8, 9}, 12).toString());

    }

}