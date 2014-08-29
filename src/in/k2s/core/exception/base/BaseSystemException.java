package in.k2s.core.exception.base;

public class BaseSystemException extends BaseException {

	private static final long serialVersionUID = 2067300923198289144L;

	public BaseSystemException() {
		super();
	}

	public BaseSystemException(Throwable cause) {
		super(cause);
	}

	public BaseSystemException(String message) {
		super(message);
	}

	public BaseSystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
