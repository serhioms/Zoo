package interview.task;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeNumberGen {

	@Test
	public void testPrimeNumber() {
		assertTrue (isPrime(2));
		assertTrue (isPrime(3));
		assertFalse(isPrime(4));
		assertTrue (isPrime(17));
		assertFalse(isPrime(18));
		assertTrue (isPrime(19));
		assertFalse(isPrime(20));

		assertFalse(isPrime(561)); // Minimal Karlmike number
	}

	boolean isPrime(int n) {
		if( n<2 ) return false;
		
		int q = (int )Math.floor(Math.sqrt((double )n));
		for(int i=2; i<= q; i++) {
			if( n % i == 0 ) {
				return false;
			}
		}
		return true;
	}
}
