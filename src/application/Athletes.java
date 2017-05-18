package application;

import javafx.scene.control.CheckBox;

/**
 * Athletes class
 * @author JinMing Liu s3596621
 *
 */
public class Athletes extends Participants {
	private CheckBox checkbox=new CheckBox();
	public CheckBox getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(CheckBox checkbox) {
		this.checkbox = checkbox;
	}

	private Integer score = 0;
	public double seconds = 0;
	public Athletes(String athID,String athName,int athAge,String athState, String athType)
	{
		super(athID, athName, athAge, athState, athType);
	}
	
	public Athletes()
	{
		this("","",0,"","");
		
	}
	
	public double getSeconds(){
		return seconds;
	}
	
	public void setSeconds(double seconds){
		this.seconds = seconds;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	//overriding
	public String getAthID()
	{
		return super.getUniqueID();
	}
	public void setAthID(String athID)
	{
		super.setUniqueID(athID);
	}
	public String getAthName() {
		return super.getName();
	}
	public void setAthName(String name) {
		super.setName(name);
	}
	public int getAthAge() {
		return super.getAge();
	}
	public void setAthAge(int age) {
		super.setAge(age);
	}
	public String getAthState() {
		return super.getState();
	}
	public void setAthState(String state) {
		super.setState(state);
	}
	public String getAthType(){
		return super.getType();
	}
	public void setAthType(String athType){
		super.setType(athType);
	}
	 /**
     * @return The Id, name, age and state together.
     */
	public String getDetails()
	{
		return "ID:" + getAthID() + " Name:" + getAthName() + "  age:" + getAge()
		+ " state:" + getAthState() + " type:"+getAthType();
    }
	
	 @Override
	    public String toString(){
	    	return getDetails();
	    }
}
