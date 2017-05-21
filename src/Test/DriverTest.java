/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Driver;
import application.NoRefereeException;

/**
 * @author 10623
 *
 */
public class DriverTest {

	/**
	 * Test method for {@link application.Driver#selectGame()}.
	 */
	@Test
	public void testcheckOffiID() {
		Driver driver=new Driver();
		try {
			driver.loadOffics();
		} catch (NoRefereeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, driver.checkOffiID(driver.offics, "Of0001"));
	}

	

}
