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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
/**
<h1> selectPlayersController </h1>
* selectPlayersController class used to select Athletes
* @version jdk1.8
* @author Bohang Lin s3651013
*/
public class selectPlayersController implements Initializable{

	@FXML private TableColumn checklist;
	@FXML private TableView playersTable;
	public static int sort=1;
	/**
	 * initialize
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList list=FXCollections.observableArrayList();
		ArrayList<Athletes> temparr=null;
		if(Ozlympic.gameType.equals("swimming"))
		{
			temparr=Ozlympic.driver.swimmingAths;
		}else if(Ozlympic.gameType.equals("running"))
		{
			temparr=Ozlympic.driver.runningAths;
					
		}else if(Ozlympic.gameType.equals("cycling"))
		{
			temparr=Ozlympic.driver.cyclingAths;
		}
		for (Athletes object : temparr) {
			list.add(object);
		}
		ObservableList<TableColumn> cols = playersTable.getColumns();
		cols.get(0).setCellValueFactory(new PropertyValueFactory("checkbox"));
		cols.get(1).setCellValueFactory(new PropertyValueFactory("uniqueID"));
		cols.get(2).setCellValueFactory(new PropertyValueFactory("name"));
		cols.get(3).setCellValueFactory(new PropertyValueFactory("type"));
		cols.get(4).setCellValueFactory(new PropertyValueFactory("age"));
		cols.get(5).setCellValueFactory(new PropertyValueFactory("state"));
		playersTable.setItems(list);
	}
	
	/**
	 * start game
	 * @param event ActionEvent
	 */
	public void StartGame(ActionEvent event)
	{
		ArrayList<Athletes> ath = new ArrayList<Athletes>();
		AbstractGame game = null;
		ArrayList<Athletes> temparr=null;
		if(Ozlympic.gameType.equals("swimming"))
		{
			game = GameFactory.createAGame(GameEnum.getGameByIndex(1));
			temparr=Ozlympic.driver.swimmingAths;
		}else if(Ozlympic.gameType.equals("running"))
		{
			game = GameFactory.createAGame(GameEnum.getGameByIndex(2));
			temparr=Ozlympic.driver.runningAths;
					
		}else if(Ozlympic.gameType.equals("cycling"))
		{
			game = GameFactory.createAGame(GameEnum.getGameByIndex(3));
			temparr=Ozlympic.driver.cyclingAths;
		}
		for (Athletes object : temparr) {
			if(object.getCheckbox().isSelected()) //Determine whether or not you are selected
			{
				ath.add(object);
			}
		}
		game.setOffi(getOfficialByID(Ozlympic.offID));
		game.setAthlets(ath);
	
		try {
			game.runGame();
			game.getOffi().calScores(game);
			this.showGame(game);
			game.saveGameResults();
		} catch (TooFewAthleteException e) {
			System.err.println(e.getMessage());
			Ozlympic.alert("Error", e.getMessage());
			
		} catch (NoRefereeException e) {
			
			System.err.println(e.getMessage());
			Ozlympic.alert("Error", e.getMessage());
		} catch (GameFullException e) {
			System.err.println(e.getMessage());
			Ozlympic.alert("Error", e.getMessage());
		}
		catch (WrongTypeException e) {
			System.err.println(e.getMessage());
			Ozlympic.alert("Error", e.getMessage());
		}
			
	}
	/**
	 * show game
	 * @param game AbstractGame
	 */
	public void showGame(AbstractGame game)
	{
		
		sort=1;
		BorderPane border=new BorderPane();
		GridPane gridPane=new GridPane();
		Button button=new Button();
		button.setText("ShowResult");
		button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            	Ozlympic.loadPage("scoreScene.fxml");
            }
        });
		gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		gridPane.setHgap(5.5);
		gridPane.setVgap(5.5);
		gridPane.add(button, 15, 55);
		border.setBottom(gridPane);
		Scene scene=new Scene(border, 650, 650);
	    int count=0;
	    Text[] texts=new Text[game.getAthlets().size()];
	    for(Athletes a:game.getAthlets())
	    {  	
		    final Text t=new Text();
		    t.setText(a.getAthName()+" "+a.getAthID());
		    t.setX(20);
		    t.setY(30+40*count);
		    texts[count]=t;
		    border.getChildren().add(t); 
		    final Line line=new Line(20,35+40*count,630,35+40*count);
		    line.setStrokeWidth(2);
		    line.setStroke(Color.RED);
		    border.getChildren().add(line);
		    
		    count++;
		    //Create a timeline  
		    final Timeline timeline=new Timeline();
		    timeline.onFinishedProperty();{
		    	
		    }
		    //timeline.setCycleCount(Timeline.INDEFINITE);//setup cycle repeats 
		    //timeline.setAutoReverse(true);//Set the auto-return effect of the animation 
		    EventHandler onFinished = new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent ac) {
	                 //stack.setTranslateX(java.lang.Math.random()*200-100);
	                 //reset counter
	                 //i = 0;
	            	t.setText(a.getAthName()+"=="+a.getSeconds()+"s  number"+sort);
	            	sort++;
	            }
	        };
		      
		    //Move the x position within 500ms to 300
		    final KeyValue kv=new KeyValue(t.xProperty(), 430);  
		    final KeyFrame kf=new KeyFrame(Duration.millis(a.getSeconds()*1000),onFinished, kv);  
		    //Add key frames to the timeline
		    timeline.getKeyFrames().add(kf);  
		    timeline.play();//run  
		    
	    }
	    
	    final Line line1=new Line(20,35,20,39*count);
	    line1.setStrokeWidth(5);
	    line1.setStroke(Color.BLACK);
	    border.getChildren().add(line1);
	    final Line line2=new Line(430,35,430,39*count);
	    line2.setStrokeWidth(5);
	    line2.setStroke(Color.BLACK);
	    border.getChildren().add(line2);
			Ozlympic.loadPage(scene);
	}
	/**
	 * the  methods to get Official By ID
	 * @param ID String
	 * @author Bohang Lin s3651013
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
