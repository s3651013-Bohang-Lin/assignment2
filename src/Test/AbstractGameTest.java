/**
 * 
 */
package Test;

import static org.junit.Assert.*;//静态引入,调用时不需要写Assert.
import static org.hamcrest.Matchers.*;
import java.nio.channels.NonWritableChannelException;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Test;

import application.AbstractGame;
import javafx.beans.binding.ListExpression;

/**
 * @author 10623
 *
 */
public class AbstractGameTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link application.AbstractGame#AbstractGame(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAbstractGame() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link application.AbstractGame#runGame()}.
	 */
	@Test(expected = new AbstractGame().TooFewAthleteException.)
	public void testRunGame() {
		AbstractGame game = null;
		assertThat(game.getAthlets().size(),lessThan(4));
	}

	/**
	 * Test method for {@link application.AbstractGame#saveGameResults()}.
	 */
	@Test
	public void testSaveGameResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link application.AbstractGame#displayAthletsResults()}.
	 */
	@Test
	public void testDisplayAthletsResults() {
		fail("Not yet implemented");
	}

}
