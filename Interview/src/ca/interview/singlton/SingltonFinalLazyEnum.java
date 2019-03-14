package ca.interview.singlton;

public enum SingltonFinalLazyEnum {
	singlton;

	public Greating instance() {
		return LazyHolder.hi;
	}

    private static class LazyHolder {
        private static final Greating hi = new Greating(4);
    }

	static public void start() {
		System.out.print("start.");
		singlton.instance().start();
	}

}
