package ca.mss.streval;

public class EvalException extends Exception {
	
	private static final long serialVersionUID = 5928010318064590399L;

	public EvalException(String msg) {
		super(msg);
	}

	public EvalException(String expr, String msg) {
		super(msg+":\n"+expr);
	}

	public EvalException(String msg, Exception e) {
		super(msg, e);
	}

	public EvalException(String msg, Throwable e) {
		super(msg, e);
	}
}

