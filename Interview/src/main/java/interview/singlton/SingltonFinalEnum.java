package interview.singlton;

public enum SingltonFinalEnum {
	singlton;

	private final Greating instance = new Greating(1);
	
	public Greating instance() {
		return instance;
	}
	
	static public void start() {
		System.out.print("start.");
		singlton.instance().start();
	}

}
