package application;

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
