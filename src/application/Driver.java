package application;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
/**
 * <h1>Driver</h1>
 * Driver Class provides the main methods to run the game
 * @version jdk1.8
 * @author Bohang Lin s3651013
 *
 */
public class Driver {
	
	/**
	 * @param gameId String
	 * @param gameName String
	 * @param offi Officials
	 * @param isRun boolean
	 * @param athletes List<Athletes>
	 * @param athletsSecondResult Map<String, Double>
	 * */
	private String info = new String("");
	public  ArrayList<Officials> offics = new ArrayList<Officials>();
	public List<AbstractGame> games = new ArrayList<AbstractGame>();
	private ArrayList<Athletes> aths = new ArrayList<Athletes>();
	public ArrayList<Athletes> swimmingAths = new ArrayList<Athletes>();
	public ArrayList<Athletes> runningAths = new ArrayList<Athletes>();
	public ArrayList<Athletes> cyclingAths = new ArrayList<Athletes>();
	private ArrayList<Athletes> superAths = new ArrayList<Athletes>();
	public String message = "";
	private Athletes predictWinner;
	
	/**
	* This method will be executed when user needs to start this system.
	* It will read information from a text file called "ozlympic.txt" automatically.
	* Then it will provide a menu so that one can operate the system.
	*/
	public void startSystem()
	{
		boolean exit = false;
		while(!exit)
		{
			String option = getKeyboard().nextLine();
			switch(option)
			{
				case "1":
					selectGame();
					Ozlympic.display();
					break;
				case "2":
					predictGame();
					Ozlympic.display();
					break;
				case "3":
					runningTheGames();
					Ozlympic.display();
					break;
				case "4":
					disPlayAllGameResult();
					Ozlympic.display();
					break;
				case "5":
					calThePlayerScores();
					Ozlympic.display();
					break;
				case "6":
					System.out.println("You have exited.");
		            exit = true;
					break;
				default:
					System.out.println("Invalid option! Please choose the option from 1 to 6!");
		            break;
			}
		}
	}
	  private Scanner getKeyboard(){
	    	return new Scanner(System.in);
	    }
	  
	  //case1��select project and  determine whether to add new players
	  public void selectGame()
	  {
		  info = "please enter a game you want to run:\n";
		  for(GameEnum game : GameEnum.values())
			  info += game.getValue() + " : " + game.getName() + " ";
		  //info += ":\n";
		  System.out.println(info);
		  int gameIndex = getKeyboard().nextInt();
		  GameEnum gameType = GameEnum.getGameByIndex(gameIndex);
		  while(gameType == null)
		  {
			  System.out.println("your input is invalid, please input again");
			  gameIndex = getKeyboard().nextInt();
			  gameType = GameEnum.getGameByIndex(gameIndex);
		  }
		  
		  info = "please select an official for this game:\n";
		  int i = 1;
		  for(Officials offic : offics){
			  info += (i++) + " : " + offic + "\n";
		  }
		  System.out.println(info);
		  int input = getKeyboard().nextInt();
		  while(input > offics.size() || input < 1){
			  System.out.println(info);
			  input = getKeyboard().nextInt();
		  }
		  Officials selOffic = offics.get(input-1);
		  System.out.println("you have select the official: "+selOffic);
		  
		  AbstractGame game = GameFactory.createAGame(gameType);
		  game.setOffi(selOffic);
		  System.out.println("you selected the game " +game.getGameName() + ", id:"+game.getGameId());
		  games.add(game);
	  }
	  
	  /**
		 * case3:
		 * Run all races
		 * Statistical performance of athlete
		 */
	  public void runningTheGames() {
		  System.out.println(" now has "+games.size()+" games");
		  for(AbstractGame game : games){
			  List<Athletes> players = new ArrayList<Athletes>();
			  if(game instanceof Swimming){
				  players.addAll(swimmingAths);
			  }
			  if(game instanceof Running){
				  players.addAll(runningAths);
			  }
			  if(game instanceof Cycling){
				  players.addAll(cyclingAths);
			  }
			  players.addAll(superAths);
			  game.setAthlets(players);
			  try{ 
				  game.runGame();
				 }catch (TooFewAthleteException e) {
					// TODO: handle exception
					 e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
				}catch (NoRefereeException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			  catch (GameFullException e) {
					//System.err.println("Warning: athletes are more than 8");
					e.printStackTrace();
				}
			  catch (WrongTypeException e) {
					
					e.printStackTrace();
				}
		  }
	  }
	  
	  /**
	     * case 2:
	     * predict winner
	     */
	  public void predictGame(){
		  String msg = "";
		  int i = 0;
		  for(Athletes a : aths){
			  msg += (++i) + " : " + a + "\n";
		  }
		  System.out.println("please choose the winner athletes you predict\n"+msg );
		  int input = getKeyboard().nextInt();
		  while(input > aths.size() || input<1){
				System.out.println("please choose the winner athletes you predict\n"+msg );
				input = getKeyboard().nextInt();
		  }
		  predictWinner = aths.get(input - 1);
		  System.out.println("you have predict that "+predictWinner.getAthName() + " is the winner");
		  
	  }
	  
	  /**
		 * case 4:
		 * Show the results of all athletes
		 * @return String
	  */
	  public String disPlayAllGameResult(){
		  String res="";
		  for(AbstractGame game : games){
			  res+=game.displayAthletsResults();
		  }
		  return res;
	  }
	  
	  /**
		 * case 5:
		 * Calculated fraction
		 */
	  public void calThePlayerScores(){
		  for(AbstractGame game : games){//Each game can only be scored by the referee statistics
			  game.getOffi().calScores(game);
		  }
		  for(Athletes ath : aths){
			  System.out.println(ath + " scores:" +ath.getScore());
		  }
		//Sort by fraction
		  Collections.sort(aths, new Comparator<Athletes>() {

			@Override
			public int compare(Athletes o1, Athletes o2) {
				return o2.getScore() - o1.getScore();
			}
		  });
		  Athletes realWinner = aths.get(0);
		  System.out.println("the realWinner is "+realWinner);
		  
		  if(predictWinner == null){// the user does not predict so it do not execute following code 
			  return;
		  }
		  if(predictWinner.getAthID().equals(realWinner.getAthID())){
			  System.out.println("Congratulations! your predict is correct");
		  }else{
			  System.out.println("Sorry! your predict is inCorrect");
		  }
	  }
		  /*
		  * read athlete data from text
		 */
			public void loadPlayers(){
				
			  String content = null;
			  try {
				  content = FileUtils.readFile("participants.txt");
				  String[] lines = content.split(";");	
				  for(String line : lines)
				  {
					 String[] values = line.split(", ");
					  
					 
					 Athletes ath = new Athletes();
					 ath.setAthID(values[0]);
					 ath.setAthName(values[2]);
					 ath.setAge(Integer.parseInt(values[3]));
					 ath.setAthState(values[4]);
					 ath.setAthType(values[1]);
					 
					 if(!"".equals(ath.getAthType()))
					 {
						 if("swimmer".equals(ath.getAthType())){
							 swimmingAths.add(ath);
						 }
						 if("cyclist".equals(ath.getAthType())){
							 cyclingAths.add(ath);
						 }
						 if("sprinter".equals(ath.getAthType())){
							 runningAths.add(ath);
						 }
						 if("super".equals(ath.getAthType())){
							// superAths.add(ath);
							 swimmingAths.add(ath);
							 cyclingAths.add(ath);
							 runningAths.add(ath);
						 }
						 if(!"officer".equals(ath.getAthType()))
							 aths.add(ath);
					 }	  
				  }
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				 
				  
//				 System.out.println("there are "+aths.size()+" athletes");
//				 for(Athletes a : aths){
//					System.out.println(a);
//				 }
//				 System.out.println("");
			}
			
			
			/**
			 * loading referee
			 * @throws NoRefereeException when trying run a game which has no official appointed.
			 */
			public void loadOffics() throws NoRefereeException{
				
				  String content=null;
				  try {
					  content = FileUtils.readFile("participants.txt");
					  String[] lines = content.split(";");	
					  for(String line : lines){
						 String[] values = line.split(", ");
						  
						 if(("officer".equals(values[1])))
						 {
							 Officials offic = new Officials(values[0], values[2], Integer.parseInt(values[3]),
									 values[4], "");
							 
							 offics.add(offic);
						 }
						 
					  }
					  if(offics.size()==0)
					  {
						  throw new NoRefereeException("Warning: There is no officials.");
					  }
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				  
				  
//				 System.out.println("there are "+offics.size()+" officials");
//				 for(Officials offic : offics){
//					System.out.println(offic);
//				 }
//				 System.out.println("");
			}
			public int add(int a,int b)
			{
				return a+b;
			}
}
