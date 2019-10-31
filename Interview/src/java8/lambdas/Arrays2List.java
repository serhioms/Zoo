package java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arrays2List {

	public static List<Integer> toListOfInteger(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}

	public static List<String> toListOfString(char[][] arr) {
		 return Arrays.stream(arr).map(a->new String(a)).collect(Collectors.toList());
	}

}
