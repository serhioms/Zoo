package ca.mss.test.index;

import java.util.concurrent.atomic.AtomicInteger;

import ca.mss.index.RingIndex;

public class TestRingIndex {

	public static void main(String[] args) {
		
		int ringSize = 1000, max = 100_0000_000;
		int i, ring1, index;
		long time;
		
		// Too slow
		AtomicInteger indeks = new AtomicInteger(ringSize+1);
		
		time = System.currentTimeMillis();
		for(i=0, ring1 = ringSize-1; i<max; i++) {
			indeks.updateAndGet(val->{
				return val == 0? ringSize: --val;
			});
			//System.out.println("idx = "+idx); 
		}
		time = System.currentTimeMillis() - time;

		System.out.println("AtomicInteger.updateAndGet, mls = "+time); // 1367

		index = -1;
		
		time = System.currentTimeMillis();
		for(i=0; i<max; i++) {
			index = ++index % ringSize;
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;

		System.out.println("++index % ringSize, mls = "+time); // 1119, 1121

		index = -1;
		
		time = System.currentTimeMillis();
		for(i=0; i<max; i++) {
			if( ++index == ringSize ) {
				index = 0;
			}
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("if( ++index == ringSize ), mls = "+time); // 114.7, 117.5

		index = ringSize;
		time = System.currentTimeMillis();
		for(i=0, ring1 = ringSize-1; i<max; i++) {
			if( --index < 0 ) {
				index = ring1;
			}
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("if( --index < 0 ), mls = "+time); // 115.0, 115.7

		index = ringSize;

		time = System.currentTimeMillis();
		for(i=0, ring1 = ringSize-1; i<max; i++) {
			if( --index ==-1 ) {
				index = ring1;
			}
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("if( --index ==-1 ), mls = "+time); // 115.8, 117.2

		index = -1;
		
		// minimum
		time = System.currentTimeMillis();
		for(i=0; i<max; i++) {
			index = ++index == ringSize? 0: index;
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		// minimum--
		time = System.currentTimeMillis();
		for(i=0; i<max; i++) {
			index = getNext(index,ringSize);
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("getNext(++index == ringSize? 0: index), mls = "+time); // 114.7, 116.3

		// minimum----
		RingIndex ri = new RingIndex(ringSize);
		time = System.currentTimeMillis();
		for(i=0; i<max; i++) {
			index = ri.next(index);
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("ri.getNext(index), mls = "+time); // 114.7, 116.3
		
		index = ringSize;
		
		time = System.currentTimeMillis();
		for(i=0, ring1 = ringSize-1; i<max; i++) {
			index =  --index <0? ring1: index;
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("--index <0? ring1: index, mls = "+time); // 114.5, 114.8
		
		index = ringSize;
		
		time = System.currentTimeMillis();
		for(i=0, ring1 = ringSize-1; i<max; i++) {
			index =  --index ==-1? ring1: index;
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("--index ==-1? ring1: index, mls = "+time); // 114.5, 115.9
		
		index = ringSize;
		
		time = System.currentTimeMillis();
		for(i=0, ring1 = 1-ringSize; i<max; i++) {
			index -=  index == 0? ring1: 1;
			//System.out.println(index); 
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("index == 0? ring1, mls = "+time); // 114.5, 115.9
	}

	private static int getNext(int index, int ringSize) {
		return ++index == ringSize? 0: index;
	}

}
