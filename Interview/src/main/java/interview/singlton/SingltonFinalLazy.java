package interview.singlton;

public class SingltonFinalLazy {

	public static Greating instance() {
		return LazyHolder.instance;
	}

    private static class LazyHolder {
        private static final Greating instance = new Greating(4);
    }

	public static void start() {
		System.out.print("start.");
		instance().start();
	}

}
