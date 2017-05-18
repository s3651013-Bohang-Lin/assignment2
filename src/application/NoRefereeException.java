package application;
/**
 * <h1>NoRefereeException</h1>
 * NoRefereeException class is a user-defined exception class 
 * Inheriting the Exception class.
 * When trying run a game which has no official appointed.
 * @version jdk1.8
 * @author Bohang Lin s3651013
 */
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
