package application;

public class NoRefereeException extends Exception {
	private static final long serialVersionUID = 1L;

    public NoRefereeException() {
        super();
    }
    
    public NoRefereeException(String msg) {
        super(msg);
    }
    
    public NoRefereeException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public NoRefereeException(Throwable cause) {
        super(cause);
    }
}
