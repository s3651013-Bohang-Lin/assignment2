package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
/**
<h1> scoreController </h1>
* scoreController class used to display All game results and scores of Athletes
* @version jdk1.8
* @author JinMing Liu s3596621
*/
public class scoreController implements Initializable {
	@FXML
	private TableView score;
	/**
	 * initialize
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList list=FXCollections.observableArrayList();
		ResultSet rs ;
		try {
			rs = Ozlympic.statement.executeQuery("select * from result");
			while(rs.next())  
		      {  
		        resultsBean result = new resultsBean();
		        result.setGameID(rs.getString("GameID"));
		        result.setAthID(rs.getString("AthleteID"));
		        result.setOffiID(rs.getString("OfficialID"));
		        result.setScore(rs.getInt("Score"));
		        result.setSeconds(rs.getDouble("Result"));
		        list.add(result);
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		ObservableList<TableColumn> cols = score.getColumns();
		cols.get(0).setCellValueFactory(new PropertyValueFactory("gameID"));
		cols.get(1).setCellValueFactory(new PropertyValueFactory("uniqueID"));
		cols.get(2).setCellValueFactory(new PropertyValueFactory("offiID"));
		cols.get(3).setCellValueFactory(new PropertyValueFactory("seconds"));
		cols.get(4).setCellValueFactory(new PropertyValueFactory("score"));
		score.setItems(list);
	}
	/**
	 * set back button point to "selectGame.fxml"
	 * @param event ActionEvent
	 */
	public void backClick(ActionEvent event)
	{		
		Ozlympic.loadPage("selectGame.fxml");	
	}
	/**
	 * set back button point to "myScene.fxml"
	 * @param event ActionEvent
	 */
	public void homeClick(ActionEvent event)
	{
		Ozlympic.loadPage("myScene.fxml");	
	}
}
