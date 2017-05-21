package application;

/**
 * </h1>Participant</h1> 
 * Participant class is a superclass about athletes class and officials class
 * @version jdk1.8
 * @author JinMing Liu s3596621
 */
public class Participants {
	/** 
	 * @param uniqueID String
	 * @param name String
	 * @param age int
	 * @param state String
	 * @param type String
	 */
	private String uniqueID;
	private String name;
	private int age;
	private String state;
	private String type; //athletes and referees belong to
	/** 
	 * The constructor with parameters 
	 * @param ID 
	 * Ref String
	 * @param Name 
	 * Ref String
	 * @param Age 
	 * Ref int
	 * @param State 
	 * Ref String
	 * @param Type 
	 * Ref String
	 */
	public Participants(String ID, String Name, int Age, String State, String Type)
	{
		setUniqueID(ID);
		setName(Name);
		setAge(Age);
		setState(State);
		setType(Type);
	}
	
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
