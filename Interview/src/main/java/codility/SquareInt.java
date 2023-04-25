package codility;

import java.util.stream.IntStream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareInt {

	static public int solution(int A, int B) {
		return new Long(IntStream.range(A, B+1)
				.filter(n->pow2(sqrt(n)) == n)
				.filter(n-> print(n))
				.count()).intValue();
	}

	static private int pow2(int i) {
		return i*i;
	}

	static private int sqrt(int n) {
		return new Double(Math.sqrt(n)).intValue();
	}

	static private boolean print(int p) {
		System.out.println(p);
		return true;
	}

	@Test
	public void testSquareInt() {
		int A = 4, B = 17;
		System.out.println("In range ("+A+","+B+")");
		assertEquals(3, solution(A, B));
	}

}
