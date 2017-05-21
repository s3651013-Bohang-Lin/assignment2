/**
 * 
 */
package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.*;
import org.junit.*;
import application.AbstractGame;
import application.Cycling;
import application.Running;
import application.Swimming;

/**
 * @author 10623
 *
 */
public class GameFactoryTest {

	/**
	 * Test method for {@link application.GameFactory#createAGame(application.GameEnum)}.
	 */
	@Test
	public void testCreateAGame() {
		//fail("Not yet implemented");
		Swimming s = new Swimming("S1");
		s.setGameName("swimming");
		assertEquals("swimming",s.getGameName());
		Running r = new Running("R1");
		r.setGameName("running");
		assertEquals("running", r.getGameName());
		Cycling c = new Cycling("C1");
		c.setGameName("cycling");
		assertEquals("cycling", c.getGameName());
		
	}

}
