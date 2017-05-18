package application;
/**
 * <h1>WrongTypeException</h1>
 * WrongTypeException class is a user-defined exception class 
 * Inheriting the Exception class.
 * when trying to add an athlete to a wrong type of game e.g assigning a 
 * swimmer to a running game. Note, super athletes can participate in all three types of games.
 * This exception is also for attempts of assigning an athlete as an official or assigning an 
 * official to a game.
 * @version jdk1.8
 * @author Bohang Lin s3651013
 */
public class WrongTypeException extends Exception {

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
