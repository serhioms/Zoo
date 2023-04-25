package interview.question;

public class TotalTryFinallyHang {

	/*
	 * Total hang!
	 */
	
	public static void main(String[] args) {
		new TotalTryFinallyHang().work();
	}

	public void work(){
		try {
			work();
		} finally {
			work();
		}
	}
}
