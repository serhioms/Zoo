package interview.deloit;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class DeloitTest {

	String name = "Valeriy Ivanov";

	@Test
	public void spellName1() {
		Arrays.stream(name.split("")).forEach(System.out::println);
	}

	@Test
	public void spellName2() {
		byte[] bytes = name.toLowerCase().getBytes();
		name.chars().mapToObj(c->(char)c).forEach(System.out::println);
	}

	@Test
	public void flipOrder1() {
		String[] split = name.split("");
		ArrayUtils.reverse(split);
		Arrays.stream(split).forEach(System.out::println);
	}

	@Test
	public void flipOrder2() {
		name.chars().mapToObj(c->(char)c).collect(
				Collectors.collectingAndThen(Collectors.toList(), list -> {
						Collections.reverse(list);
						return list.stream();
					})).forEach(System.out::println);
	}

}
