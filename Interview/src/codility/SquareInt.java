package codility;

import java.util.stream.IntStream;

import org.junit.Test;

public class SquareInt {
	
	@Test
	public void squarint() {
		int A = 4, B = 17;
		
		System.out.println("In range ("+A+","+B+")");
		
   		Long count = IntStream.range(A, B+1)
			.filter(n->pow2(new Double(Math.sqrt(n)).intValue()) == n)
			.filter(n->trueprint(n))
			.count();
   		
		System.out.println("N="+count.intValue());
	}

	private boolean trueprint(int p) {
		System.out.println(p);
		return true;
	}

	private int pow2(int i) {
		return i*i;
	}
}
