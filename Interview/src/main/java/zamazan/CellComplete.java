package zamazan;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.lambdas.Arrays2List;

public class CellComplete {

	@Test
	public void test1() {
		assertEquals(Arrays2List.toListOf(new int[]{0,1,0,0,1,0,1,0}), cellCompete(new int[]{0,1,0,0,1,0,1,0}, 0));
		assertEquals(Arrays2List.toListOf(new int[]{0,1,0,0,1,0,1,0}), cellCompete(new int[]{0,1,0,0,1,0,1,0}, 1));
		assertEquals(Arrays2List.toListOf(new int[]{0,0,0,0,0,1,1,0}), cellCompete(new int[]{0,0,0,0,0,1,1,0}, 2));
	}

	public List<Integer> cellCompete(int[] states, int days) {
		int[] states2 = new int[states.length];
		int[] result = states;
		for (int d = 0; d < days; d++) {
			for (int i = 0, max = states.length - 1; i <= max; i++) {
				if (i == 0) {
					states2[i] = 0 == states[i + 1] ? 0 : 1;
				} else if (i == max) {
					states2[i] = states[i - 1] == 0 ? 0 : 1;
				} else {
					states2[i] = states[i - 1] == states[i + 1] ? 0 : 1;
				}
			}
			result = states2;
			states2 = states;
			states = result;
		}
		return Arrays.stream(result).boxed().collect(Collectors.toList());
	}
}
