package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
<h1> resultsController <h1>
* resultsController class used to display All game results and scores of Athletes
* @version jdk1.8
* @author Bohang Lin s3651013
*/
public class resultsController implements Initializable {
	@FXML
	private TextArea resultsTextArea;
	@FXML
	private Button back;
	@FXML
	private Button home;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		resultsTextArea.setText(Ozlympic.driver.disPlayAllGameResult()+Ozlympic.driver.message);
		Ozlympic.driver.message="";
		Ozlympic.driver.calThePlayerScores();		
	}
	
	public void backClick(ActionEvent event)
	{	
		Ozlympic.loadPage("selectGame.fxml");		
	}
	public void homeClick(ActionEvent event)
	{
		Ozlympic.loadPage("myScene.fxml");		
	}
}
