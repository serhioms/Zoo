package codility;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

public class CodilityTest10_28_2019 {

	public int solution1(int[] A) {
		// write your code in Java SE 8
		if( A == null || A.length == 0 ) {
			throw new RuntimeException("Input array must not be empty.");
		}
		boolean minus=false;
		for(int n: A){
			if( n < 0 ) {
				minus = !minus;
			} else if( n == 0 ) {
				return 0;
			}
		}
		return minus? -1: 1;
	}

	@Test
	public void testSolution1() {
		assertEquals(1, solution1(new int[] { 1, 2, 3 }));
		assertEquals(-1, solution1(new int[] { -1, 2, 3 }));
		assertEquals(1, solution1(new int[] { -1, -2, 3 }));
		assertEquals(0, solution1(new int[] { -1, 0, 3 }));
		assertEquals(-1, solution1(new int[] { -100, Integer.MAX_VALUE }));
		assertEquals(1, solution1(new int[] { 100, Integer.MAX_VALUE }));
	}

	public String solution2(String S) {
		// write your code in Java SE 8
		Set<Character> set = new HashSet<>();

		Optional<Character> max = S.chars().mapToObj(c -> (char) c)
			.filter(c->{
				if( set.contains(c) ) {
					return false;
				}
				set.add(c);
				return set.contains(Character.toUpperCase(c)) &&  set.contains(Character.toLowerCase(c));
			})
			.map(c->Character.toLowerCase(c))
			.max((a, b) -> Character.compare(a, b));

		System.out.println(set);
		return max.isPresent()?max.get().toString().toUpperCase(): "NO";
	}

	@Test
	public void testSolution2() {
		assertEquals("D",solution2("aaBabcDad"));
		assertEquals("B",solution2("aaBabcDaA"));
		assertEquals("NO",solution2(""));
		assertEquals("NO",solution2("Codility"));
		assertEquals("T",solution2("WeTestCodErs"));
		assertEquals("Z",solution2("WeTestCodErszZ"));
	}

	public int solution3(String S, int K) {
		// write your code in Java SE 8
		Sms sms = new Sms();
		Long k = java.util.Arrays.stream(S.split(" ")).filter(s -> sms.addAndCompare(s, K)).count();
		return sms.getResult(S, K, k);
	}

	static class Sms {

		private String sms = "";
		private boolean result = true;

		public boolean addAndCompare(String s, int K) {
			String newsms = sms + (sms.isEmpty() ? "" : " ") + s;
			if (newsms.length() > K) {
				result &= s.length() <= K;
				sms = s;
				return result;
			} else if (newsms.length() == K) {
				sms = "";
				return result;
			} else {
				sms = newsms;
				return false;
			}
		}

		public int getResult(String S, int K, Long k) {
			if (result) {
				if (S.length() > 0) {
					if (sms.length() <= K) {
						return k.intValue() + (sms.isEmpty() ? 0 : 1);
					}
				}
			}
			return -1;
		}

	}

	@Test
	public void testSolution3() {
		assertEquals(-1, solution3("", 3));
		assertEquals(1, solution3("1", 3));
		assertEquals(1, solution3("123", 3));
		assertEquals(-1, solution3("1234", 3));
		assertEquals(2, solution3("12 12", 3));
		assertEquals(1, solution3("12 12", 5));
		assertEquals(2, solution3("12 12 123", 5));
		assertEquals(2, solution3("12 12 12345", 5));
		assertEquals(-1, solution3("12 12 123456", 5));
		assertEquals(3, solution3("12 12 12345 6", 5));
		assertEquals(-1, solution3("12 12 12345 6", 2));
		assertEquals(3, solution3("12 12 1 23 45 6", 5));
	}

}