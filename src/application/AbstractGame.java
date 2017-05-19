package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import java.io.*;
import java.text.SimpleDateFormat;
import javafx.application.Application;
/**
 * <h1>AbstractGame</h1>
 * Game abstract class provides general behavior 
 * and some subclasses to achieve their abstract method
 * @version jdk1.8
 * @author Bohang Lin s3651013
 *
 */
public abstract class AbstractGame {
	/**
	 * @param gameId String
	 * @param gameName String
	 * @param offi Officials
	 * @param isRun boolean
	 * @param athletes List<Athletes>
	 * @param athletsSecondResult Map<String, Double>
	 * */
	private String gameId;     //game ID
	private String gameName;   //game name
	private Officials offi;	
	private boolean isRun = false; 
	private List<Athletes> athletes = new ArrayList<Athletes>();
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();
	/** 
	 * The constructor with parameters 
	 * @param gameId
	 * Ref String 
	 * @param gameName 
	 * Ref String
	 */
	public AbstractGame(String gameId, String gameName) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
	}
	
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Officials getOffi() {
		return offi;
	}
	public void setOffi(Officials offi) {
		this.offi = offi;
	}
	public List<Athletes> getAthlets() {
		return athletes;
	}
	public void setAthlets(List<Athletes> athlets) {
		this.athletes = athlets;
	}
	public Map<String, Double> getAthletsSecondResult() {
		return athletsSecondResult;
	}
	public void setAthletsSecondResult(Map<String, Double> athletsSecondResult) {
		this.athletsSecondResult = athletsSecondResult;
	}
	
	/**
	 *the method of calculating result cause it is different, 
	 *need the concrete class to achieve that method 
	 *@return Nothing.
	 */
	public abstract double compete();
	
	/**
	 * To start the game, you will call a random score to generate the results of each player 
	 * Save to map for later query use 
	 * @throws TooFewAthleteException when trying to run a game, which has less than 4 athletes registered.
	 * @throws NoRefereeException when trying run a game which has no official appointed.
	 * @throws GameFullException when trying to add an athlete to a game which already has 8 athletes registered
	 * @throws WrongTypeException when trying to add an athlete to a wrong type of game e.g assigning a swimmer 
	 * to a running game. Note, super athletes can participate in all three types of games. 
	 * This exception is also for attempts of assigning an athlete as an official or assigning an official to a game.
	 *
	 */
	public void runGame() throws TooFewAthleteException, NoRefereeException, GameFullException,WrongTypeException{
		isRun = true;   //Modify the operation flag bit true, said the implementation of the rungame steps

		if(athletes.size() < 4)
		{
			throw new TooFewAthleteException("Warning: athletes are less than 4");
			//System.out.println("==========================================================");
			//System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			//System.out.println("the game is not run because athletes is less than 4");
			//return;
		}
		
		if(athletes.size() > 8)
		{
			throw new GameFullException("Warning: athletes are more than 8");
			//System.out.println("==========================================================");
			//System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			//System.out.println("the game is not run because athletes is less than 4");
			//return;
		}
		for(Athletes athlete : athletes){
			double seconds = compete();
			athlete.setSeconds(seconds);
			athletsSecondResult.put(athlete.getAthID(), seconds);
		}
	}
	
	/**
	 *This method is used to save results in "gameResults.txt"
	 */
	public void saveGameResults() {
		FileWriter out = null;

		try {
			
			out = new FileWriter("gameResults.txt",true);
			//String newline = System.getProperty("line.seperator");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			String line = gameId + " " + gameName + " " + sdf.format(new Date()) + "\r\n";
			out.write(line);
			for(int i = 0; i < athletes.size(); i++)
			{
				line = athletes.get(i).getAthID() + " " +athletes.get(i).getAthName() + " " +
						athletsSecondResult.get(athletes.get(i).getAthID()) + " " +
						athletes.get(i).getScore() + "\r\n";
				out.write(line);
			}
			out.write("\r\n");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (Athletes ath : athletes) 
			{
//				Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");  
//				Statement  statement = connection.createStatement();  
				Ozlympic.statement.executeUpdate("insert into result values('"+getGameId()+"', '"+getOffi().getOffiID()+"', '"+ath.getAthID()+"', " +ath.getSeconds()+", " +ath.getScore()+")"); 
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	
	}
	
	/**
	 * Show all the players participating in the game 
	 * Query results by query map 
	 * @return res String
	 */
	public String displayAthletsResults(){
//		if(!isRun){//If you do not select the 3 run the game can not show results
//			System.out.println("==========================================================");
//			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
//			System.out.println("the game is not run please select the menu to start the games.");
//			return;
//		}
//		
//		if(athletes.size() < 4){//If the player is less than 4, you can't run the game 
//			System.out.println("==========================================================");
//			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
//			System.out.println("the game is not run because athletes is less than 4");
//			return;
//		}
		String res="";
		res+="==========================================================\r\n";
		res+="game id:"+this.getGameId() + ", name:"+this.gameName+"\r\n";
		Officials offi = this.getOffi();
		res+="officials: "+offi+"\r\n";
		for(Athletes ath : athletes){
			double second = athletsSecondResult.get(ath.getAthID());
			res+=ath+" "+ second +"s"+"\r\n";
			
		}
		System.out.println(res);
		return res;
	}
}
