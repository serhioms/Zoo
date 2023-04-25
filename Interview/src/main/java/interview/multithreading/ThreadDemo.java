package interview.multithreading;

class ThreadDemo extends Thread {

	ThreadDemo(String name) {
		super(name);
		System.out.println("Creating " + super.getName());
	}

	public void run() {
		System.out.println("Running " + super.getName());
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + super.getName() + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + super.getName() + " interrupted.");
		}
		System.out.println("Thread " + super.getName() + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + super.getName());
		super.start();
	}

	public static void main(String args[]) {

		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.start();

		ThreadDemo T2 = new ThreadDemo("Thread-2");
		T2.start();
	}
}