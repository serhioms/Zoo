package interview.singlton;

public class Greating {

	public static final long _100000000L = 100000000l;
	
	private int n;
	private long counter = 0l;
	public long start = 0l;

	public void start() {
		start = System.currentTimeMillis();
	}
	
	
	public Greating(int n) {
		this.n = n;
		System.out.print(String.format("new(%d).", n));
	}
	
	public void hi(String who){
		System.out.println(String.format("%s hi(%d) = %d mls", who, n, System.currentTimeMillis()-start));
	}

	public boolean next() {
		if( counter++ == 0 ){
			start();
		} else if( counter >= _100000000L){
			counter = 0;
			return false;
		}
		return true;
	}

	public void work() {
	}
	
}
