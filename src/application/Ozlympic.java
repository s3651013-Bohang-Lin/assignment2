package application;

import javafx.application.Application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;

/**
 * <h1>Ozlympic</h1>
 * Ozlympic class inherit Application class to implement application level global variables 
 * this class used to create and connect a database to store information of Athletes and officials
 * and load a page.
 * @version jdk1.8
 * @author Bohang Lin s3651013
 *
 */
public class Ozlympic extends Application {
	/**
	 * @param mainStage Stage
	 * @param driver Driver
	 * @param connection Connection
	 * @param statement Statement
	 * @param offID String
	 * @param gameType String
	 * */
	public static Stage mainStage;
	public static Driver driver;
	public static Connection connection = null; 
	public static Statement statement=null;
	public static String offID="";
	public static String gameType="";
	
	/**
	 *start method used to create and connect a database to store information of Athletes and officials
	 *@param primaryStage Stage
	 *@return Nothing.
	 *@throws SQLException An exception that provides information on a database access error or other errors.
	 *@throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using: 
	 *@throws NoRefereeException when trying run a game which has no official appointed.
	 */
	@Override
	public void start(Stage primaryStage) {
	    try  
	    {  
	    	Class.forName("org.sqlite.JDBC");
	      // create a database connection  
	      connection = DriverManager.getConnection("jdbc:sqlite:test.db");  
	      statement = connection.createStatement();  
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.  
	      statement.executeUpdate("create table if not exists result (GameID string,OfficialID string,AthleteID string,Result double,Score integer)");  
	      statement.executeUpdate("delete from result");  //delete previous data
	      
	    }  
	    catch(SQLException e)  
	    {  
	      System.err.println(e.getMessage());  
	      Ozlympic.alert("Error", "Cannot connect database.");
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    finally  
	    {  
	      if(connection != null) 
		{
			//connection.close();  
		}  
	    }  
	    Ozlympic.mainStage=new Stage();
	    Ozlympic.driver=new Driver();
	    Ozlympic.driver.loadPlayers();
		try {
			Ozlympic.driver.loadOffics();
		} catch (NoRefereeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ozlympic.loadPage("myScene.fxml");
	}
	/**
	 *alert method used to Popup warning window 
	 *@param header String
	 *@param message String
	 */
	public static void alert(String header,String message)
	{
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("info");
	        alert.setHeaderText(header);
	        alert.setContentText(message);
	        alert.initOwner(Ozlympic.mainStage);
	        alert.show();
	    
	}
	
	/**
	 *load method used to create a new page of GUI
	 *@param filename String
	 *@throws Exception The class Exception and its subclasses are a form of Throwable that indicates 
	 *conditions that a reasonable application might want to catch. 
	 *@throws SQLException An exception that provides information on a database access error or other errors.
	 */
	public static void loadPage(String filename)
	{
		try {
			//BorderPane root = new BorderPane();
			java.net.URL url = Ozlympic.class.getResource(filename);
	        
	        Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,650,650);
			scene.getStylesheets().add(Ozlympic.class.getResource("application.css").toExternalForm());
			Ozlympic.mainStage.setScene(scene);
			Ozlympic.mainStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void loadPage(Scene scene)
	{
		try {
			Ozlympic.mainStage.setScene(scene);
			Ozlympic.mainStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *insertResult method used to insert data in database
	 *@param sql String
	 *@throws SQLException An exception that provides information on a database access error or other errors.
	 */
	public static void insertResult(String sql)
	{
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			Statement  statement = connection.createStatement();  
			statement.executeUpdate(sql); 
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
	}
	/**
	 *getCountOfGameType method used to create game ID
	 *@param gametype int 
	 *@throws SQLException An exception that provides information on a database access error or other errors.
	 */
	public static int getCountOfGameType(int gametype)
	{
		int num=0;
		ResultSet rs ;
		String type="";
		if(gametype==1)
		{
			type="S";
		}else if(gametype==2)
		{
			type="R";
		}else if(gametype==3)
		{
			type="C";
		}
		try {
			rs = Ozlympic.statement.executeQuery("select *  from result  group by GameID having GameID like '"+type+"%'");
			
			while(rs.next())  
		      {  
				num++;
		      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return num;
	}
	public static void main(String[] args) {
		launch(args);
	}

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
