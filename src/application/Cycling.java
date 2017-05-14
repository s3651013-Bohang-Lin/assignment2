package application;

/**
 * Cyclng class
 * @author JinMing Liu s3596621
 *
 */
public class Cycling extends AbstractGame{
	public Cycling(String gameId) {
		super(gameId, "cycling");
	}
	
	/**
	 * Randomly generated seconds of cycling
	 */
	@Override
	public double compete() {
		//Generating random numbers from 500 to 800 and keep two decimal places 
		return (double)Math.round(((Math.random()*301) + 500)*100)/100.0;  
	}
}
