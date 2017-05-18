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

public class resultsController implements Initializable {
	@FXML
	private TextArea resultsTextArea;
	@FXML
	private Button back;
	@FXML
	private Button home;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		resultsTextArea.setText(Main.driver.disPlayAllGameResult()+Main.driver.message);
		Main.driver.message="";
		Main.driver.calThePlayerScores();
		
		
	}
	
	public void backClick(ActionEvent event)
	{
		
		Main.loadPage("selectGame.fxml");
			
	}
	public void homeClick(ActionEvent event)
	{

		Main.loadPage("myScene.fxml");
			
	}
}