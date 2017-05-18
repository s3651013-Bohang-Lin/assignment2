package application;

import java.util.HashMap;
import java.util.Map;
/**
 *  because the game can choose more than one election each time the same game Id need to change 
 * So through the factory class to create the game 
 * @author Bohang Lin s3651013
 *
 */
public class GameFactory {
	//Save the current number of games used to generate the game ID 
	private  static Map<GameEnum, Integer> gameMap = new HashMap<GameEnum, Integer>();
	
	static{//Initialize to 0 
		for(GameEnum gameEnum : GameEnum.values()){
			gameMap.put(gameEnum, 0);
		}
	}
	
	/**
	 * Create a game based on the selected game type 
	 * @param gameType
	 * @return
	 */
	
	public static AbstractGame createAGame(GameEnum gameType){
		int nowNum = 0;
		switch(gameType){
		  case SWIMMING:
			  nowNum = Main.getCountOfSwimming(1) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Swimming(gameType.getGameIdPre() + nowNum);
		  case RUNNING:
			  nowNum = Main.getCountOfSwimming(2) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Running(gameType.getGameIdPre() + nowNum);
		  case CYCLING:
			  nowNum = Main.getCountOfSwimming(3) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Cycling(gameType.getGameIdPre() + nowNum);
		  default:
			  return null;
		}
	}
}
