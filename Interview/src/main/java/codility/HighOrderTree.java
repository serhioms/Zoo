package codility;

import java.util.Arrays;

public interface HighOrderTree {
	
	public Runnable combine(Runnable... trees);
	
	static public HighOrderTree tree(){
		return trees -> () -> Arrays.stream(trees).forEach(Runnable::run);
	}

}
