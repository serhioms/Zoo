package codility;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SmsSeries {

	public int solution(String S, int K) {
		// write your code in Java SE 8
		String sms = "";
		int count = 0;

		for(String word: S.split(" ")) {
			if( word.length() > K ) {
				return 0;
			}
			String newsms = sms + (sms.isEmpty() ? "" : " ") + word;
			int length = newsms.length();
			if(length < K) {
				sms = newsms;
			} else if (length == K) {
				sms = newsms;
				++count;
				sms = "";
			} else {
				if( !sms.isEmpty() ) {
					++count;
				}
				sms = word;
			}
		}
		return sms.isEmpty()? count: count + 1;
	}


	@Test
	public void testSmsSeries() {
		assertEquals(0, solution("", 3));
		assertEquals(1, solution("1", 3));
		assertEquals(1, solution("123", 3));
		assertEquals(0, solution("1234", 3));
		assertEquals(2, solution("12 12", 3));
		assertEquals(1, solution("12 12", 5));
		assertEquals(2, solution("12 12 123", 5));
		assertEquals(2, solution("12 12 12345", 5));
		assertEquals(0, solution("12 12 123456", 5));
		assertEquals(0, solution("12 12 123456 6", 5));
		assertEquals(0, solution("12 12 12345 6", 2));
		assertEquals(3, solution("12 12 1 23 45 6", 5));
	}
}
