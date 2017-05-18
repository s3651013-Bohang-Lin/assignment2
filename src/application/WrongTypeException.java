package application;

public class WrongTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WrongTypeException() {
        super();
    }
    
    public WrongTypeException(String msg) {
        super(msg);
    }
    
    public WrongTypeException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public WrongTypeException(Throwable cause) {
        super(cause);
    }
}
