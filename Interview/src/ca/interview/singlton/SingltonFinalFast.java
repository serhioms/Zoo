package ca.interview.singlton;

public class SingltonFinalFast {

	static public final Greating instance = new Greating(0);

	public static void start() {
		System.out.print("start.");
		instance.start();
	}

}
