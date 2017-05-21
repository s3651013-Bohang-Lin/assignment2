/**
 * 
 */
package Test;

import static org.junit.Assert.*;//静态引入,调用时不需要写Assert.
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
 * @author 10623
 *
 */
public class AbstractGameTest {
	
	private List<Athletes> athletes = new ArrayList<Athletes>();
	private List<AbstractGame> game = new ArrayList<AbstractGame>();
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

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

	/**
	 * Test method for {@link application.AbstractGame#saveGameResults()}.
	 */
	@Test
	public void testSaveGameResults() {
		
	}

	/**
	 * Test method for {@link application.AbstractGame#displayAthletsResults()}.
	 */
	@Test
	public void testDisplayAthletsResults() {
		
	}

}
