package java8.lambdas;

import static org.junit.Assert.assertEquals;

import java.util.stream.DoubleStream;

import org.junit.Test;

public class StreamTest {
	
	@Test
	public void foreach() {
		
		double profit = 10.0;
		int womenNearby = 5;
		
		// Now introduce negative factors (each women nearby
        // implies a cumulative 10% profit reduction)
		double totalProfit = DoubleStream.iterate(profit, p -> p * 0.90)
                .limit(womenNearby + 1)
                .min()
                .orElse(profit);
		
		System.out.println(totalProfit);
		
		assertEquals(10*0.9*0.9*0.9*0.9*0.9, totalProfit, 0.1);
	}

}
