package ca.interview.singlton;

public enum SingltonFinalFastEnum {
	singlton;

	public final Greating instance = new Greating(0);

	static public void start() {
		System.out.print("start.");
		singlton.instance.start();
	}

}
