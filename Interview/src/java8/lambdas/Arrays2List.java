package java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arrays2List {

	public static List<Integer> toListOf(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}

	public static List<Double> toListOf(double[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}

	public static List<String> toListOfString(char[][] arr) {
		 return Arrays.stream(arr).map(a->new String(a)).collect(Collectors.toList());
	}

	public static char[][] copyOf(char[][] grid) {
		char[][] newone = new char[grid.length][];
		for(int i=0; i<newone.length; i++) {
			newone[i] = Arrays.copyOf(grid[i], grid[i].length);
		}
		return newone;
	}

}
