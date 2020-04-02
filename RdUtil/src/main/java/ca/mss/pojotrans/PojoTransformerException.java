package ca.mss.pojotrans;

public class PojoTransformerException extends Exception {

	private static final long serialVersionUID = 6425682876893423068L;

	public PojoTransformerException() {
	}

	public PojoTransformerException(String message) {
		super(message);
	}

	public PojoTransformerException(Throwable cause) {
		super(cause);
	}

	public PojoTransformerException(String message, Throwable cause) {
		super(message, cause);
	}

	public PojoTransformerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
