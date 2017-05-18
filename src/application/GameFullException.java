package application;
/**
 * <h1>GameFullException</h1>
 * GameFullException class is a user-defined exception class 
 * Inheriting the Exception class.
 * trying to add an athlete to a game which already has 8 athletes registered
 * @version jdk1.8
 * @author Bohang Lin s3651013
 */
public class GameFullException extends Exception {
		private static final long serialVersionUID = 1L;

	    public GameFullException() {
	        super();
	    }
	    
	    public GameFullException(String msg) {
	        super(msg);
	    }
	    
	    public GameFullException(String msg, Throwable cause) {
	        super(msg, cause);
	    }
	    
	    public GameFullException(Throwable cause) {
	        super(cause);
	    }

}
