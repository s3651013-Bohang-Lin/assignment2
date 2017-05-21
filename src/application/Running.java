package application;

/**
 * <h1>Running</h1>
 * Running class provides general behavior to generate random seconds of sprinters
 * @version jdk1.8
 * @author JinMing Liu s3596621
 *
 */
public class Running extends AbstractGame{

	public Running(String gameId) {
		super(gameId, "running");
	}

	/**
	 * Randomly generated seconds of Running
	 */
	@Override
	public double compete() {
		//Generating random numbers from 10 to 20 and keep two decimal places
		return (double)Math.round(((Math.random()*11) + 10)*100)/100.0;   
	}
}
