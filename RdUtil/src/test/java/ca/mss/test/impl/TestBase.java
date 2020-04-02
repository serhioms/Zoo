package ca.mss.test.impl;

public class TestBase {

	public long max = Long.parseLong(System.getProperty("max", "1"));

	public void test(String method, Runnable test) {
		long start = System.currentTimeMillis();
		
		test.run();
		
		if( max > 1 ){
			System.out.printf("%s #1: %.3f mls\n", method, 1.0*(System.currentTimeMillis() - start));
		}
		
		start = System.currentTimeMillis();
		
		for(long i=0; i<max; i++){
			test.run();
		}

		if( max > 1 ){
			System.out.printf("%s #%,d: %.3f mls\n", method, max, 1.0*(System.currentTimeMillis() - start)/max);
		}
	}
}
