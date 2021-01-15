package coworkersdility.splittext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SplitText {

	public int splitText(String S, int K) {
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
	public void testSplitText() {
		assertEquals(-1, splitText("", 3));
		assertEquals(1, splitText("1", 3));
		assertEquals(1, splitText("123", 3));
		assertEquals(-1, splitText("1234", 3));
		assertEquals(2, splitText("12 12", 3));
		assertEquals(1, splitText("12 12", 5));
		assertEquals(2, splitText("12 12 123", 5));
		assertEquals(2, splitText("12 12 12345", 5));
		assertEquals(-1, splitText("12 12 123456", 5));
		assertEquals(3, splitText("12 12 12345 6", 5));
		assertEquals(-1, splitText("12 12 12345 6", 2));
		assertEquals(3, splitText("12 12 1 23 45 6", 5));
	}
}
