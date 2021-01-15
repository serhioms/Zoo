package zamazan;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

import java8.lambdas.Arrays2List;

/*
 * Min Cost to Connect Ropes
 * 
 * Given n ropes of different lengths, we need to connect these ropes into one rope. 
 * We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. 
 * The length of this connected rope is also equal to the sum of their lengths. 
 * This process is repeated until n ropes are connected into a single rope. 
 * Find the min possible cost required to connect all ropes.
 * 
 * Example 1:
Input: ropes = [8, 4, 6, 12]
Output: 58
Explanation: The optimal way to connect ropes is as follows
1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
3. Connect the ropes of length 18 and 12 (cost is 30).
Total cost to connect the ropes is 10 + 18 + 30 = 58
 */
public class MinCostToConnectRopes {

	private int solution1(int[] A) {
		int totalCost=0;
		while(true) {
			Arrays.sort(A);
			if( A[1] == Integer.MAX_VALUE ) {
				break;
			}
			int sum = A[0]+A[1];
			totalCost += sum;
			A[0] = sum;
			A[1] = Integer.MAX_VALUE;
		}
		return totalCost;
	}

	private int solution2(int[] A) {
		int totalCost = 0;
		Arrays.sort(A);
		for(int i=1,max=A.length; i<max; i++) {
			int sum = A[i-1]+A[i];
			totalCost += sum;
			// move sum to right place vie swa-ap
			for(int k=i+1; k<max; k++) {
				if( A[k]<sum ) {
					A[k-1] = A[k];
					A[k] = sum;
				} else {
					A[k-1] = sum;
					break;
				}
			}
		}
		return totalCost;
	}

	public static int solutionAmazonMinCost(List<Integer> ropes) {
	    Queue<Integer> pq = new PriorityQueue<>(ropes);
	    int totalCost = 0;
	    while (pq.size() > 1) {
	        int cost = pq.poll() + pq.poll();
	        pq.add(cost);
	        totalCost += cost;
	    }
	    return totalCost;
	}
	
	@Test
	public void test1() {
		assertEquals(58, solution1(new int[]{8,4,6,12}));
		assertEquals(58, solution2(new int[]{8,4,6,12}));
		assertEquals(58, solutionAmazonMinCost(Arrays2List.toListOf(new int[]{8,4,6,12})));
	}

	@Test
	public void test2() {
		assertEquals(54, solution1(new int[]{20, 4, 8, 2}));
		assertEquals(54, solution2(new int[]{20, 4, 8, 2}));
		assertEquals(54, solutionAmazonMinCost(Arrays2List.toListOf(new int[]{20, 4, 8, 2})));
	}

	@Test
	public void test3() {
		assertEquals(224, solution1(new int[]{1, 2, 5, 10, 35, 89}));
		assertEquals(224, solution2(new int[]{1, 2, 5, 10, 35, 89}));
		assertEquals(224, solutionAmazonMinCost(Arrays2List.toListOf(new int[]{1, 2, 5, 10, 35, 89})));
	}

	@Test
	public void test4() {
		assertEquals(20, solution1(new int[]{2, 2, 3, 3}));
		assertEquals(20, solution2(new int[]{2, 2, 3, 3}));
		assertEquals(20, solutionAmazonMinCost(Arrays2List.toListOf(new int[]{2, 2, 3, 3})));
	}
}
