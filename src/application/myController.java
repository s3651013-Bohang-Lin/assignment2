package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * <h1>myController</h1>
 * myController class use Initializable interface
 * @version jdk1.8
 * @author Bohang Lin s3651013
 *
 */
public class myController  extends Application implements Initializable {
	@FXML
	private TextField texttest;
	@FXML
	private Button btntest;
	public void selectClick(ActionEvent event)
	{
		Ozlympic.loadPage("selectGame.fxml");
	}

	public void resultsClick(ActionEvent event)
	{
		Ozlympic.loadPage("scoreScene.fxml");
	}

	public void exitClick(ActionEvent event)
	{
		System.exit(0);
	}
	@Override //添加图片
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setId("pane");
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
