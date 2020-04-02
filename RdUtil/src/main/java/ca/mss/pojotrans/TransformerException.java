package ca.mss.pojotrans;

public class TransformerException extends Exception {

	private static final long serialVersionUID = -1894832044132547233L;

	public TransformerException() {
	}

	public TransformerException(String message) {
		super(message);
	}

	public TransformerException(Throwable cause) {
		super(cause);
	}

	public TransformerException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransformerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
