package application;
/**
<h1> resultsBean </h1>
* resultsBean class inherit Athletes class and add two attributes: game ID and official ID
* to provide for scoreController class
* @version jdk1.8
* @author JinMing Liu s3596621
*/

public class resultsBean extends Athletes{
	private String gameID;
	private String offiID;
	
	public String getGameID() {
		return gameID;
	}
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	public String getOffiID() {
		return offiID;
	}
	public void setOffiID(String offiID) {
		this.offiID = offiID;
	}
	
}
