package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test2 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetGameName() {
		Cycling game=new Cycling("123");
		assertEquals("1234",game.getGameId());
	}

}
