package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class selectPlayersController implements Initializable{

	@FXML private TableColumn checklist;
	@FXML private TableView playersTable;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//checklist.setCellFactory(CheckBoxTableCell.forTableColumn(checklist));
		ObservableList list=FXCollections.observableArrayList();
		// TODO Auto-generated method stub
		ArrayList<Athletes> temparr=null;
		if(Main.gameType.equals("swimming"))
		{
			temparr=Main.driver.swimmingAths;
		}else if(Main.gameType.equals("running"))
		{
			temparr=Main.driver.runningAths;
					
		}else if(Main.gameType.equals("cycling"))
		{
			temparr=Main.driver.cyclingAths;
		}
		for (Athletes object : temparr) {
			list.add(object);
		}
		ObservableList<TableColumn> cols = playersTable.getColumns();
		cols.get(0).setCellValueFactory(new PropertyValueFactory("checkbox"));
		cols.get(1).setCellValueFactory(new PropertyValueFactory("name"));
		playersTable.setItems(list);
	}
	public void StartGame(ActionEvent event)
	{
		ArrayList<Athletes> ath = new ArrayList<Athletes>();
		AbstractGame game = null;
		ArrayList<Athletes> temparr=null;
		if(Main.gameType.equals("swimming"))
		{
			game = GameFactory.createAGame(GameEnum.getGameByIndex(1));
			temparr=Main.driver.swimmingAths;
		}else if(Main.gameType.equals("running"))
		{
			game = GameFactory.createAGame(GameEnum.getGameByIndex(2));
			temparr=Main.driver.runningAths;
					
		}else if(Main.gameType.equals("cycling"))
		{
			game = GameFactory.createAGame(GameEnum.getGameByIndex(3));
			temparr=Main.driver.cyclingAths;
		}
		for (Athletes object : temparr) {
			if(object.getCheckbox().isSelected()) //判断是否被选中
			{
				ath.add(object);
				//System.out.println(object.getName());
			}
		}
		game.setOffi(getOfficialByID(Main.offID));
		game.setAthlets(ath);
	
		try {
			game.runGame();
			game.getOffi().calScores(game);
			game.saveGameResults();
		} catch (TooFewAthleteException e) {
			System.err.println(e.getMessage());
			
		} catch (NoRefereeException e) {
			
			System.err.println(e.getMessage());
		} catch (GameFullException e) {
			System.err.println(e.getMessage());
		}
		catch (WrongTypeException e) {
			System.err.println(e.getMessage());
		}
		
		Main.loadPage("scoreScene.fxml");
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
	public void backClick(ActionEvent event)
	{
		
		Main.loadPage("selectGame.fxml");
			
	}
	public void homeClick(ActionEvent event)
	{

		Main.loadPage("myScene.fxml");
			
	}
}
