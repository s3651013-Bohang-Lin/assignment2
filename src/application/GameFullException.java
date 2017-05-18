package application;

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
