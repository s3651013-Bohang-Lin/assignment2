package application;
/**
 * <h1>TooFewAthleteException</h1>
 * TooFewAthleteException class is a user-defined exception class 
 * Inheriting the Exception class.
 * When trying to run a game, which has less than 4 athletes registered.
 * @version jdk1.8
 * @author Bohang Lin s3651013
 */
public class TooFewAthleteException extends Exception {
	
	    private static final long serialVersionUID = 1L;

	    public TooFewAthleteException() {
	        super();
	    }
	    
	    public TooFewAthleteException(String msg) {
	        super(msg);
	    }
	    
	    public TooFewAthleteException(String msg, Throwable cause) {
	        super(msg, cause);
	    }
	    
	    public TooFewAthleteException(Throwable cause) {
	        super(cause);
	    }
	
}
