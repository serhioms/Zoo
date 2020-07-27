package amazon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import java8.lambdas.Arrays2List;

public class Find2ClosestFloats {

	@Test
	public void test1() {
		double[] idx = new double[]{0,0};

		assertEquals(5.55, solution1(5.5, new double[]{6.6,1.15,2.3,3.3,4.4,5.5}, idx), 0.001);
		assertEquals(Arrays2List.toListOf(new double[]{1.15,4.4}), Arrays2List.toListOf(idx));
		
		assertEquals(3.45, solution1(0, new double[]{6.6,1.15,2.3,3.3,4.4,5.5}, idx), 0.001);
		assertEquals(Arrays2List.toListOf(new double[]{1.15,2.3}), Arrays2List.toListOf(idx));

		assertEquals(6.7, solution1(6.7, new double[]{6.6,1.15,2.3,3.3,4.4,5.5}, idx), 0.001);
		assertEquals(Arrays2List.toListOf(new double[]{2.3,4.4}), Arrays2List.toListOf(idx));
	}

	private double solution1(double point, double[] arr, double[] idx) {
		double mind = Double.MAX_VALUE;
		double mins = -1;
		
		Arrays.sort(arr);
		System.out.println(Arrays2List.toListOf(arr));
		
		for(int i=0, max=arr.length-1; i<=max; i++) {
			for(int j=i+1; j<max; j++) {
				double sum = arr[i]+arr[j];
				double diff = sum-point;
				double adiff = Math.abs(diff);
				if( adiff < mind ) {
					mind = adiff;
					mins = sum;
					idx[0] = arr[i];
					idx[1] = arr[j];
				} else if( diff > 0.0 ) {
					return mins;
				}
			}
		}
		return mins;
	}

}
