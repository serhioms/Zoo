package ca.interview.finalize;

public class Finalization {

	protected void finalize() throws Throwable {

		try {

			// Perform some cleanup. If it fails for some reason, it is ignored.
			// doCleanup(); 

		} finally {

			super.finalize(); // Call finalize on the parent object

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Throwable {
		Finalization fin = new Finalization();
		
		fin.finalize();
	}

}
