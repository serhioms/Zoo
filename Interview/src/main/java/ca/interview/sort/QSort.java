package ca.interview.sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class QSort {

	static int swapCounter = 0, loopCounter = 0;
	
	@Test
	public void test() {
		
		int[] a = new int[] {8,3,6,5,0,2,6,1,8,3,4,9,4,7,2,9};
		
		swapCounter = 0;
		loopCounter = 0;

		debug(a);
		
		qsort(a, 0, a.length-1);
		
		assertArrayEquals(new int[]{0,1,2,2,3,3,4,4,5,6,6,7,8,8,9,9}, a);
	}

	private void qsort(int[] a, int low, int high) {
		if( low < high ) {
			int pivot = partition(a, low, high);
			qsort(a, low, pivot-1);
			qsort(a, pivot+1, high);
		}
	}

	private int partition(int[] a, int low, int high) {
		int pivot = pivot(a, low, high);
		int i = low;
		System.out.printf("%2d) For %d to %d.start\n", ++loopCounter, low, high);
		for(int j=low; j<high; ++j) {
			if( a[j] <= pivot ) {
				swap(a, i++, j);
			}
		}
		swap(a, i, high);
		System.out.printf("%2d) For %d to %d.end\n", loopCounter, low, high);
		return i;
	}
	
	private int pivot(int[] a, int low, int high) {
		int mid = (low + high)/2;
		System.out.printf("Pivot.start mid = %d\n", mid);
		if( a[mid] < a[low] ) {
			swap(a, mid, low);
		}
		if( a[high] < a[low] ) {
			swap(a, high, low);
		}
		if( a[mid] < a[high] ) {
			swap(a, mid, high);
		}
		System.out.printf("Pivot.end pivot = %d\n", a[high]);
		return a[high];
	}

	private void swap(int[] a, int i, int j) {
		
		if( i == j ) {
			return;
		}
		
		int s = a[i];
		a[i] = a[j];
		a[j] = s;
		
		++swapCounter;

		debug(a, i, j);
	}

	private void debug(int[] a) {
		System.out.printf("%s\n", 
				Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(","))
				);
	}
	
	private void debug(int[] a, int i, int j) {
		System.out.printf("%s\tNumber of swaps:%3d\t%2d<>%d\n", 
				Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(",")), 
				swapCounter, i, j);
	}

}
