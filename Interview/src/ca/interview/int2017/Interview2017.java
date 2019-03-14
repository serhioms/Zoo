package ca.interview.int2017;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Interview2017 {

	@Test
	public void ScotiaRecursion() {
		assertEquals("Recursion", "aaaaabbbbb", r(5,"a") + r(5,"b"));
		assertEquals("Recursion", "ab", r(1,"a") + r(1,"b"));
		assertEquals("Recursion", "", r(0,"a") + r(0,"b"));
	}

	private String r(int i, String s) {
		if( i == 0 ) 
			return "";
		else if( i == 1 ) 
			return s;
		else
			return r(i-1, s) + s;
	}

	@Test
	public void RbcSizeOfLinkedList() {
		assertEquals("Standard case", 4, listLength(new int[]{1,2,4,-1,3}));
		assertEquals("Zero case", 0, listLength(new int[]{-1}));
	}

	private Object listLength(int[] N) {
		int count = 0;
		for(int i=N[0]; i != -1; i=N[i]){
			count++;
		}
		return count;
	}

	@Test
	public void RbcOneSwapNonDecreasing() {
		assertEquals("Vie sorting", true, NonDecreasingVieSorting(new int[]{2,3,5,4,6,7}));
		assertEquals("Vie sorting", false, NonDecreasingVieSorting(new int[]{2,3,5,4,4,4,4,7,6}));
		assertEquals("Vie sorting", false, NonDecreasingVieSorting(new int[]{2,3,5,6,4,4,6,7}));
		assertEquals("Vie sorting", true, NonDecreasingVieSorting(new int[]{2,3,5,4,4,4,6,7}));
		assertEquals("Vie sorting", true, NonDecreasingVieSorting(new int[]{2,3,5,4,4,4,3,7}));
		assertEquals("Vie sorting", false, NonDecreasingVieSorting(new int[]{2,3,5,4,4,4,2,7}));
		assertEquals("Vie sorting", false, NonDecreasingVieSorting(new int[]{2,3,5,4,4,4,3,3}));
		assertEquals("Vie sorting", false, NonDecreasingVieSorting(new int[]{5,6,4,4,6,7}));
		assertEquals("Vie sorting", false, NonDecreasingVieSorting(new int[]{5,6,4,4,6}));
		
		assertEquals("One swap", true, NonDecreasingVieSwap(new int[]{2,3,5,4,6,7}));
		assertEquals("One swap", false, NonDecreasingVieSwap(new int[]{2,3,5,4,4,4,4,7,6}));
		assertEquals("One swap", false, NonDecreasingVieSwap(new int[]{2,3,5,6,4,4,6,7}));
		assertEquals("One swap", true, NonDecreasingVieSwap(new int[]{2,3,5,4,4,4,6,7}));
		assertEquals("One swap", true, NonDecreasingVieSwap(new int[]{2,3,5,4,4,4,3,7}));
		assertEquals("One swap", false, NonDecreasingVieSwap(new int[]{2,3,5,4,4,4,2,7}));
		assertEquals("One swap", false, NonDecreasingVieSwap(new int[]{2,3,5,4,4,4,3,3}));
		assertEquals("One swap", false, NonDecreasingVieSwap(new int[]{5,6,4,4,6,7}));
		assertEquals("One swap", false, NonDecreasingVieSwap(new int[]{5,6,4,4,6}));
 	}

	private boolean NonDecreasingVieSwap(int[] N) {
		int count = 0;
		for(int i=1,max=N.length; i<max && count < 2; i++){
			if( N[i-1] > N[i]){
				int left = i-1;
				int right = goRightFindMin(i, N); 
				swap(N, left, right);
				count += checkLeft(left-1, right, N) + 1;
				i = right;
			}
		}
		return count < 2;
	}

	private int checkLeft(int left, int right, int[] N) {
		int count = 0;
		for(int j=right; j>left; j--){
			if( N[j-1] > N[j]){
				count++;
			}
		}
		return count;
	}

	private int goRightFindMin(int i, int[] N) {
		for(int max1=N.length-1; i < max1 && N[i] >= N[i+1]; i++);
		return i;
	}

	private void swap(int[] n, int a, int b) {
		int A = n[a];
		n[a] = n[b];
		n[b] = A;
	}

	private boolean NonDecreasingVieSorting(int[] N) {
		int[] sorted = Arrays.copyOf(N, N.length);
		Arrays.sort(sorted);
		int count=0;
		for(int i=0,max=N.length; i<max && count < 3; i++){
			if( N[i] != sorted[i] )
				count++;
		}
		return count < 3;
	}

}
