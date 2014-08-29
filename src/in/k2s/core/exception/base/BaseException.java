package in.k2s.core.exception.base;

public class BaseException extends Exception {
	
	private static final long serialVersionUID = 3161997233243613928L;

	public BaseException() {
		super();
	}
	
	public BaseException(Throwable cause) {
		super(cause);
	}
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
	                                    

}
