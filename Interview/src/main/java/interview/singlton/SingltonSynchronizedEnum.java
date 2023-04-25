package interview.singlton;

public enum SingltonSynchronizedEnum {
	singlton;

	private volatile Greating instance;

	public synchronized Greating instance() {
		if( instance == null ){
			instance = new Greating(2);
		}
		return instance;
	}

	static public void start() {
		System.out.print("start.");
		singlton.instance().start();
	}

}
