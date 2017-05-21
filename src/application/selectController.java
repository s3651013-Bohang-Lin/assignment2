package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
<h1> selectController <h1>
* selectController class used to select referees and game
* @version jdk1.8
* @author Bohang Lin s3651013
*/
public class selectController implements Initializable{
		@FXML
		private TextField texttest;
		@FXML
		private Button btntest;
		@FXML
		private Button home;
		@FXML
		private Stage primaryStage;
		@FXML
		private TableView officialsTable;
		
		public void swimmingClick(ActionEvent event)
		{
			String selOffic="";
			try{
			int row = officialsTable.getSelectionModel().getSelectedIndex();
			TableColumn col = (TableColumn)officialsTable.getColumns().get(0);
			selOffic= (String) col.getCellObservableValue(row).getValue();
			Ozlympic.offID=selOffic;
			Ozlympic.gameType="swimming";
			
				Ozlympic.loadPage("selectPlayers.fxml");
			}catch (Exception e) {
				Ozlympic.alert("Warning", "please chose one referee");
			}	
		}
		
		public void runningClick(ActionEvent event)
		{
			Boolean ok = true;
			String selOffic="";
			try{
			int row = officialsTable.getSelectionModel().getSelectedIndex();
			TableColumn col = (TableColumn)officialsTable.getColumns().get(0);
			selOffic= (String) col.getCellObservableValue(row).getValue();
			Ozlympic.offID=selOffic;
			Ozlympic.gameType="running";
				Ozlympic.loadPage("selectPlayers.fxml");	
				Ozlympic.driver.disPlayAllGameResult();
			}catch (Exception e) {
				Ozlympic.alert("Warning", "please chose one referee");
			}	
		}
		
		public void cyclingClick(ActionEvent event)
		{
			Boolean ok = true;
			String selOffic="";
			try{
			int row = officialsTable.getSelectionModel().getSelectedIndex();
			TableColumn col = (TableColumn)officialsTable.getColumns().get(0);
			selOffic= (String) col.getCellObservableValue(row).getValue();
			Ozlympic.offID=selOffic;
			Ozlympic.gameType="cycling";
				Ozlympic.loadPage("selectPlayers.fxml");	
				Ozlympic.driver.disPlayAllGameResult();
			}catch (Exception e) {
				Ozlympic.alert("Warning", "please chose one referee");
			}			
		}
		/**
		 * the  methods to get Official By ID
		 * @param ID String
		 * @return Officials
		 */
		public Officials getOfficialByID(String ID){
			ArrayList<Officials> officials=Ozlympic.driver.offics;
			Officials officials2;
			for(int i = 0; i <= officials.size();i++)
			{
				officials2= officials.get(i);
				if(officials2.getOffiID().equals(ID)){
					return officials2;
				}
			}
			return null;
		}
		/**
		 * set back button point to "selectGame.fxml"
		 * @param event ActionEvent
		 */
		public void backClick(ActionEvent event)
		{		
			Ozlympic.loadPage("myScene.fxml");	
		}
		/**
		 * set back button point to "myScene.fxml"
		 * @param event ActionEvent
		 */
		public void homeClick(ActionEvent event)
		{
			Ozlympic.loadPage("myScene.fxml");
				
		}
		/**
		 * initialize
		 * @param resources ResourceBundle
		 * @param location location
		 */
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			ObservableList list=FXCollections.observableArrayList();
			for (Officials object : Ozlympic.driver.offics) {
				list.add(object);
			}
			ObservableList<TableColumn> cols = officialsTable.getColumns();
			cols.get(0).setCellValueFactory(new PropertyValueFactory("offiID"));
			cols.get(1).setCellValueFactory(new PropertyValueFactory("offiName"));
			cols.get(2).setCellValueFactory(new PropertyValueFactory("offiAge"));
			cols.get(3).setCellValueFactory(new PropertyValueFactory("offiState"));
			officialsTable.setItems(list);
			
		}
		
	}
