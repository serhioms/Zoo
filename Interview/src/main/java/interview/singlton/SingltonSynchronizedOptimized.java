package interview.singlton;

public class SingltonSynchronizedOptimized {

	static private volatile Greating instance;
	
	public static Greating instance() {
		if( instance == null ){
			synchronized( Greating.class ){
				if( instance == null ){
					instance = new Greating(3);
				}
			}
		}
		return instance;
	}

	public static void start() {
		System.out.print("start.");
		instance().start();
	}

}
