package application;

/**
 * <h1>Swimming</h1>
 * Swimming class provides general behavior to generate random seconds of swimmers
 * @version jdk1.8
 * @author JinMing Liu s3596621
 *
 */
public class Swimming extends AbstractGame{

	public Swimming(String gameId) {
		super(gameId, "swimming");
	}

	/**
	 * Randomly generated seconds of Swimming
	 */
	@Override
	public double compete() {
		//Generating random numbers from 100 to 200 and keep two decimal places 
		return (double)Math.round(((Math.random()*101) + 100)*100)/100.0;  
	}


}
