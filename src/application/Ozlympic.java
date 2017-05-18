package application;

/**
 * Main program entry
 * offer Input prompt
 * @author Bohang Lin
 *
 */
public class Ozlympic {
	
	private static Driver driver;
	static{
		driver = new Driver();
		driver.loadPlayers();
		try {
			driver.loadOffics();
		} catch (NoRefereeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		display();
//	}
	
	public static void display()
	{
		System.out.println();
		System.out.println("Ozlympic Game");
		System.out.println("===================================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the games");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		driver.startSystem();
	}
}
