package application;
	

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


public class Main extends Application {
	public static Stage mainStage;
	public static Driver driver;
	public static Connection connection = null; 
	public static Statement statement=null;
	public static String offID="";
	public static String gameType="";
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
	      Main.alert("Error", "Cannot connect database.");
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
		Main.mainStage=new Stage();
		Main.driver=new Driver();
		Main.driver.loadPlayers();
		try {
			Main.driver.loadOffics();
		} catch (NoRefereeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.loadPage("myScene.fxml");
	}
	public static void alert(String header,String message)
	{
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("info");
	        alert.setHeaderText(header);
	        alert.setContentText(message);
	        alert.initOwner(Main.mainStage);
	        alert.show();
	    
	}
	
	public static void loadPage(String filename)
	{
		try {
			//BorderPane root = new BorderPane();
			java.net.URL url = Main.class.getResource(filename);
	        
	        Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();//mainStage鏄竴涓獥鍙ｄ竴鐩磋璋冪敤锛屾墍浠ヤ笉浼氬脊鍑烘柊鐨勭獥鍙�
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
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
	public static int getCountOfSwimming(int gametype)
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
			rs = Main.statement.executeQuery("select *  from result  group by GameID having GameID like '"+type+"%'");
			
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
}
