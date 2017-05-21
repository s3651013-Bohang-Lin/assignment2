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
		Swimming s=new Swimming("S1");
		s.setGameName("eee");
		assertEquals("eee",s.getGameName());
	}

}
