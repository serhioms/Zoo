package interview.multithreading;


class ThreadLocalDemo implements Runnable {
	
	static int counter = 0;
	
    static private final ThreadLocal<String> localThread = new ThreadLocal<String>(){
        @Override
        protected String initialValue(){
       		return "[I am #"+(++counter)+"]";
        }
    };
    
	private Thread t;

	public ThreadLocalDemo() {
		System.out.println("Creating " + localThread.get());
	}

	public void run() {
		System.out.println("Running " + localThread.get());
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + localThread.get() + ", " + i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + localThread.get() + " interrupted.");
		}
		System.out.println("Thread " + localThread.get() + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + localThread.get());
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	public static void main(String args[]) {

		ThreadLocalDemo R1 = new ThreadLocalDemo();
		ThreadLocalDemo R2 = new ThreadLocalDemo();

		R1.start();
		R2.start();
	}

}
