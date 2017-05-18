package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * officials class
 * @author JinMing Liu s3596621
 *
 */
public class Officials extends Participants {
	public Officials(String offiID,String offiName,int offiAge,String offiState, String gameType)
	{
		super(offiID, offiName, offiAge, offiState, gameType);
	}
	
	//overriding 
			public String getOffiID() {
				return super.getUniqueID();
			}
			public void setOffiID(String athID) {
				super.setUniqueID(athID);
			}
			public String getOffiName() {
				return super.getName();
			}
			public void setOffiName(String name) {
				super.setName(name);
			}
			public int getOffiAge() {
				return super.getAge();
			}
			public void setOffiAge(int age) {
				super.setAge(age);;
			}
			public String getOffiState() {
				return super.getState();
			}
			public void setOffiState(String state) {
				super.setState(state);
			}
			public String getGameType(){ 
				return super.getType();
			}
			public void setGameType(String gameType){
				super.setType(gameType);
			}
			
			public void calScores(AbstractGame game){
				List<Athletes> athletes = game.getAthlets();
				Map<String, Double> athletsSecondResult = game.getAthletsSecondResult();
				for(Athletes ath : athletes){
					Double seconds = athletsSecondResult.get(ath.getAthID());
					if(seconds == null){//If the player does not score the game may not be running or other reasons the game does not count scores 
						continue;//Skip yourself 
					}
					int ranking = 1; //Default first place
					 for(Entry<String, Double> entry : athletsSecondResult.entrySet()){
					    if(entry.getKey() == ath.getAthID()){
					    	continue;  //Skip yourself 
					   	}
					   	if(entry.getValue() < seconds){ //There are others faster than themselves
					   		ranking ++;
					   	}
					    if(ranking == 1 ){
					    	ath.setScore(ath.getScore() + 5);
					    }
					    if(ranking == 2){
					    	ath.setScore(ath.getScore() + 2);
					    }
					    if(ranking == 3){
					    	ath.setScore(ath.getScore() + 1);
					    }
					 }
				}
				
				
			}
			  public String getDetails()
			    {
					return "ID:" + this.getOffiID() + " Name:" + this.getOffiName() + "  age:" + this.getAge()
					+ " state:" + this.getOffiState();
			    }
			    
			    @Override
			    public String toString(){
			    	return getDetails();
			    }
}
