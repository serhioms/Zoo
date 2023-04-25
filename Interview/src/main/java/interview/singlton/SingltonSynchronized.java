package interview.singlton;

public class SingltonSynchronized {

	private static volatile Greating instance;

	public static synchronized Greating instance() {
		if( instance == null ){
			instance = new Greating(2);
		}
		return instance;
	}

	public static void start() {
		System.out.print("start.");
		instance().start();
	}

}
