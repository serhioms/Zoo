package codility;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CodilityTest10_28_2019 {

	public static void main(String[] args) {
		System.out.println("solution1: " + (1 == solution1(new int[] { 1, 2, 3 })));
		System.out.println("solution1: " + (-1 == solution1(new int[] { -1, 2, 3 })));
		System.out.println("solution1: " + (1 == solution1(new int[] { -1, -2, 3 })));
		System.out.println("solution1: " + (0 == solution1(new int[] { -1, 0, 3 })));
		System.out.println("solution1: " + (-1 == solution1(new int[] { -100, Integer.MAX_VALUE })));
		System.out.println("solution1: " + (1 == solution1(new int[] { 100, Integer.MAX_VALUE })));
		System.out.println("");
		System.out.println("solution2: " + (equals("D",solution2("aaBabcDad"))));
		System.out.println("solution2: " + (equals("B",solution2("aaBabcDaA"))));
		System.out.println("solution2: " + (equals("NO",solution2(""))));
		System.out.println("solution2: " + (equals("NO",solution2("Codility"))));
		System.out.println("solution2: " + (equals("T",solution2("WeTestCodErs"))));
		System.out.println("solution2: " + (equals("Z",solution2("WeTestCodErszZ"))));
	}

	private static String equals(String exp, String sol) {
		return exp.equals(sol)+": expected "+exp+" but got "+sol;
	}

	public static int solution1(int[] A) {
		// write your code in Java SE 8
		MyInteger myint = new MyInteger();
		java.util.Arrays.stream(A).forEach(e -> myint.mul(e));
		return myint.signum();
	}

	static public class MyInteger {
		int mul = 1;

		public void mul(int e) {
			mul *= Integer.signum(e);
		}

		public int signum() {
			return mul;
		}
	}

	public static String solution2(String S) {
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
}