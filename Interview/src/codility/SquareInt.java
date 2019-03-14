package codility;

import java.util.stream.IntStream;

import org.junit.Test;

public class SquareInt {
	
	@Test
	public void squarint() {
		int A = 4, B = 17;
		
		System.out.println("In range ("+A+","+B+")");
		
        int n =  new Long(IntStream.range(A, B+1).filter(p-> {
			int q = new Double(Math.sqrt(p)).intValue();
			boolean ifSquareInt = q*q == p;
			
			if( ifSquareInt ){
				System.out.println(p);
			}
			return ifSquareInt;
		}).count()).intValue();

		System.out.println("N="+n);
	}
}
