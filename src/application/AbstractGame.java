package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.text.SimpleDateFormat;
import javafx.application.Application;
/**
 *Game abstract class provides general behavior and some subclasses to achieve their abstract method
 * @author Bohang Lin s3651013
 *
 */
public abstract class AbstractGame {
	private String gameId;     //game ID
	private String gameName;   //game name
	private Officials offi;	
	private boolean isRun = false; 
	private List<Athletes> athletes = new ArrayList<Athletes>();
	private Map<String, Double> athletsSecondResult = new HashMap<String, Double>();
	
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
	 *the method of calculating result cause it is different, need the concrete class to achieve that method 
	 */
	public abstract double compete();
	
	/**
	 * To start the game, you will call a random score to generate the results of each player 
	 * Save to map for later query use 
	 */
	public void runGame(){
		isRun = true;   //Modify the operation flag bit true, said the implementation of the rungame steps

		if(athletes.size() < 4){
			System.out.println("==========================================================");
			System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
			System.out.println("the game is not run because athletes is less than 4");
			return;
		}
		
		for(Athletes athlete : athletes){
			double seconds = compete();
			athletsSecondResult.put(athlete.getAthID(), seconds);
		}
		saveGameResults();
	}
	
	public void saveGameResults()
{
		FileWriter out = null;
		
		try {
			
			out = new FileWriter("gameResults.txt");
			String newline = System.getProperty("line.seperator");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String line = gameId + " " + gameName + " " + sdf + "\r\n";
			out.write(line);
			for(int i = 0; i < athletes.size(); i++)
			{
				line = athletes.get(i).getAthID() + " " +athletes.get(i).getAthName() + " " +
						athletsSecondResult.get(athletes.get(i).getAthID()) + " " +
						athletes.get(i).getScore() + "\r\n";
				out.write(line);
			}
			
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	/**
	 * Show all the players participating in the game 
	 * Query results by query map
	
	/**
	 * Show all the players participating in the game 
	 * Query results by query map 
	 */
	public void displayAthletsResults(){
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
		System.out.println("==========================================================");
		System.out.println("game id:"+this.getGameId() + ", name:"+this.gameName);
		Officials offi = this.getOffi();
		System.out.println("officials: "+offi);
		for(Athletes ath : athletes){
			double second = athletsSecondResult.get(ath.getAthID());
			System.out.println(ath+" "+ second +"s");
		}
	}
}
