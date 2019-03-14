package ca.interview.question;

public class Test05 {

	/*
	 * Total hang!
	 */
	
	public static void main(String[] args) {
		new Test05().work();
	}

	public void work(){
		try {
			work();
		} finally {
			work();
		}
	}
}
