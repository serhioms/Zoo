package ca.mss.index;

public class RingIndex {

	final int size;
	
	public RingIndex(int size) {
		this.size = size;
	}

	final public int next(int index) {
		return ++index >= size? 0: index;
	}
}
