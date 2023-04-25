package interview.singlton;

public class SingltonFinal {

	private static final Greating instance = new Greating(1);
	
	public static Greating instance() {
		return instance;
	}
	
	public static void start() {
		System.out.print("start.");
		instance().start();
	}

}
