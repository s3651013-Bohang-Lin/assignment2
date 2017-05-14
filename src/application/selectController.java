package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
public class selectController implements Initializable{
		@FXML
		private TextField texttest;
		@FXML
		private Button btntest;
		@FXML
		private Stage primaryStage;
		@FXML
		private TableView officialsTable;
		public void swimmingClick(ActionEvent event)
		{
			//Driver driver = new Driver();
			//driver.selectGame();
			String selOffic="";
			try{
			int row = officialsTable.getSelectionModel().getSelectedIndex();
			TableColumn col = (TableColumn)officialsTable.getColumns().get(0);
			selOffic= (String) col.getCellObservableValue(row).getValue();
			
			//Main.alert("test", data);
			ArrayList arrayList=new ArrayList();
			int count=Main.driver.swimmingAths.size();
			for(int i=0;i<Main.driver.swimmingAths.size();i++)
			{
				arrayList.add(Main.driver.swimmingAths.get(i));
				if((i+1)%8==0)
				{
					AbstractGame game = GameFactory.createAGame(GameEnum.getGameByIndex(1));
					  game.setOffi(this.getOfficialByID(selOffic));
					  game.setAthlets((ArrayList)arrayList.clone());
					  game.runGame();
					  Main.driver.games.add(game);
					  arrayList.clear();
					  count=count-8;
				}else {
					if(count<4)
					{
						Main.alert("Warning", "athletes are less than 4");
					}else if(count<8&&i==Main.driver.swimmingAths.size()-1){
						AbstractGame game = GameFactory.createAGame(GameEnum.getGameByIndex(1));
						  game.setOffi(this.getOfficialByID(selOffic));
						  game.setAthlets((ArrayList)arrayList.clone());
						  game.runGame();
						  Main.driver.games.add(game);
						  arrayList.clear();
					}
				}
			}
			//Main.driver.runningTheGames();
			Main.driver.disPlayAllGameResult();
			}catch (Exception e) {
				Main.alert("Warning", "please chose one row");
			}
			
				
		}
		/**
		 * the  methods to get Official By ID
		 * @param ID String
		 * @author Bohang Lin s3651013
		 * @return Officials
		 */
		public Officials getOfficialByID(String ID){
			ArrayList<Officials> officials=Main.driver.offics;
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
		public void runningClick(ActionEvent event)
		{
			
		}
		/*
		public void selectClick(ActionEvent event)
		{
			try {
				primaryStage = new Stage();
				//BorderPane root = new BorderPane();
				java.net.URL url = getClass().getResource("selectGame.fxml");
		        
		        Parent root = FXMLLoader.load(url);
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}*/
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			Main.driver.loadOffics();
			ObservableList list=FXCollections.observableArrayList();
			// TODO Auto-generated method stub
			for (Officials object : Main.driver.offics) {
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
