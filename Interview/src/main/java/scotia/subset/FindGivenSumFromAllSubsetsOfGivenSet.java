package scotia.subset;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FindGivenSumFromAllSubsetsOfGivenSet {

 public static void main(String [] args) {
     findMatchingPair(new int[]{3, 4, 6, 8, 9}, 12);
     
 }
 
 
 public static void findMatchingPair(int[] nums, int targetSum){
     int max = nums.length;
     
     Stack<Integer> stack = new Stack<>();
     IntStream.range(0,max).forEach(stack::add);

     while( stack.size() > 0 ){        

         int sum = stack.stream().mapToInt(i->nums[i]).sum();
         
         if( sum == targetSum ){
        	 System.out.println(stack.stream().map(i->Integer.toString(nums[i])).collect(Collectors.joining( ",")));
         }
         
         int last = stack.pop()+1;
         
         if( stack.size() == 0 ){
             IntStream.range(last,max).forEach(stack::add);
         } else if( last < max) {
             stack.push(last);
         }
     }        
     
 }
}