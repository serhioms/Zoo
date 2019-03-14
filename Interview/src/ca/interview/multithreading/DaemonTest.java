package ca.interview.multithreading;

public class DaemonTest {

	public static void main(String[] args) {
		new WorkerThread().start();
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
		}
		System.out.println("Main Thread ending");
	}

}

class WorkerThread extends Thread {
	public WorkerThread() {
		setDaemon(true); // When false, (i.e. when it's a user thread),
		// the Worker thread continues to run.
		// When true, (i.e. when it's a daemon thread),
		// the Worker thread terminates when the main
		// thread terminates.
	}

	public void run() {
		int count = 0;
		for(int i=0; i<5; i++) {
			System.out.println("Hello from "+getName()+" " + count++);
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(getName()+" is ending");
	}
}