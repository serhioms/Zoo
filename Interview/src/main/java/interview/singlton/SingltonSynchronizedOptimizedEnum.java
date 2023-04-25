package interview.singlton;

public enum SingltonSynchronizedOptimizedEnum {
	singlton;

	private volatile Greating instance;
	
	public Greating instance() {
		if( instance == null ){
			synchronized( Greating.class ){
				if( instance == null ){
					instance = new Greating(3);
				}
			}
		}
		return instance;
	}

	static public void start() {
		System.out.print("start.");
		singlton.instance().start();
	}

}
