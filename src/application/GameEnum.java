package application;

/**
 * Game type enumeration
 * @author Bohang Lin s3651013
 *
 */
public enum GameEnum {
	SWIMMING(1, "swimming", "S"),
	RUNNING(2, "running", "R"),
	CYCLING(3, "cycling", "C");
	
	private int value;
	private String name;
	private String gameIdPre;
	
    GameEnum(int value, String name, String pre){
		this.setValue(value);
		this.setName(name);
		this.setGameIdPre(pre);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGameIdPre() {
		return gameIdPre;
	}

	public void setGameIdPre(String gameIdPre) {
		this.gameIdPre = gameIdPre;
	}
	/**
	 * Game type enumeration
	 * return GameEnum
	 */
	public static GameEnum getGameByIndex(int index)
	{
		GameEnum[] games = values();
		for(GameEnum gameEnum : games)
		{
			if(index == gameEnum.value)
			{
				return gameEnum;
			}
		}
		return null;
	}
}
