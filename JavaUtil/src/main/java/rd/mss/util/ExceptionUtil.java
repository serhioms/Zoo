package rd.mss.util;

public class ExceptionUtil extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2444063424316461963L;

	public ExceptionUtil() {
	}

	public ExceptionUtil(String message) {
		super(message);
	}

	public ExceptionUtil(Throwable cause) {
		super(cause);
	}

	public ExceptionUtil(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionUtil(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
