/**
 * 
 */
package Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Test;

import application.AbstractGame;
import application.Athletes;
import javafx.beans.binding.ListExpression;

/**
 * @author JinMing Liu s3596621
 *
 */
public class AbstractGameTest {
	
	private List<Athletes> athletes = new ArrayList<Athletes>();
	private List<AbstractGame> game = new ArrayList<AbstractGame>();
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();

	/**
	 * Test method for {@link application.AbstractGame#runGame()}.
	 */
	@Test()
	public void testRunGame() {
		for(Athletes athlete : athletes){
			double seconds = 1.11;
			athlete.setSeconds(seconds);
			athletsSecondResult.put("Sw0001", seconds);
			assertEquals("Sw0001", 1.11,athletsSecondResult );
		}
		
	}

}
