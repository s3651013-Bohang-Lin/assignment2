package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class myController implements Initializable{
	@FXML
	private TextField texttest;
	@FXML
	private Button btntest;
	public void selectClick(ActionEvent event)
	{
		Main.loadPage("selectGame.fxml");
	}
	public void predictClick(ActionEvent event)
	{
		
	}
	public void startClick(ActionEvent event)
	{
		
	}
	public void resultsClick(ActionEvent event)
	{
		Main.loadPage("scoreScene.fxml");
	}
	public void pointsClick(ActionEvent event)
	{
		
	}
	public void exitClick(ActionEvent event)
	{
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
