package application;
	

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage mainStage;
	public static Driver driver;
	@Override
	public void start(Stage primaryStage) {
		// load the sqlite-JDBC driver using the current class loader  
	    try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	  
	    Connection connection = null;  
	    try  
	    {  
	      // create a database connection  
	      connection = DriverManager.getConnection("jdbc:sqlite:test.db");  
	      Statement statement = connection.createStatement();  
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.  
	  
	      //statement.executeUpdate("drop table if exists person");  
	      statement.executeUpdate("create table if not exists person (id integer, name string)");  
	      statement.executeUpdate("insert into person values(3, 'leo')");  
	      statement.executeUpdate("insert into person values(4, 'yui')");  
	      ResultSet rs = statement.executeQuery("select * from person");  
	      while(rs.next())  
	      {  
	        // read the result set  
	        System.out.println("name = " + rs.getString("name"));  
	        System.out.println("id = " + rs.getInt("id"));  
	      }  
	    }  
	    catch(SQLException e)  
	    {  
	      // if the error message is "out of memory",   
	      // it probably means no database file is found  
	      System.err.println(e.getMessage());  
	    }  
	    finally  
	    {  
	      try  
	      {  
	        if(connection != null)  
	          connection.close();  
	      }  
	      catch(SQLException e)  
	      {  
	        // connection close failed.  
	        System.err.println(e);  
	      }  
	    }  
		Main.mainStage=new Stage();
		Main.driver=new Driver();
		Main.driver.loadPlayers();
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
			Main.mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
