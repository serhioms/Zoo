package ca.mss.game.poker;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class OrderCountMap extends HashMap<Integer, AtomicInteger>{

	public AtomicInteger get(Integer order) {
		if( super.containsKey(order)) {
			return super.get(order);
		} else {
			AtomicInteger zero = new AtomicInteger(0);
			super.put(order, zero);
			return zero;
		}
	}


	
}
