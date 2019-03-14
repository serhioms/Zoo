package java8.lambda.collection;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class EightQueens {

	@Test
	public void generate() {
		
		int[] N = new int[] {1,2,3,4,5,6,7,8};
		
		Arrays.stream(N).forEach(i -> {Arrays.stream(N).forEach(j -> {
				if( i<j ) {
					System.out.print("f"+i+""+j+" = [");
					
					AtomicInteger count = new AtomicInteger(0);
					
					Arrays.stream(N).forEach(fi -> {
						Arrays.stream(N).forEach(fj ->{
							if(fi != fj ) {
								if( Math.abs(fi-fj) != (j-i) ) {
									System.out.print((count.incrementAndGet()>1?",":"")+"["+fi+","+fj+"]");
								}
							}
						});
					});
					
					System.out.println("]");
				}
			});
		});
		
		fail("Not yet implemented");
	}

}
