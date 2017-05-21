/**
 * 
 */
package application;

import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author 10623
 *
 */
public class GameAnimationController {
	public void initialize(URL location, ResourceBundle resources) {
		
		BorderPane border=new BorderPane(); 
		Scene scene=new Scene(border, 400, 400);
		//创建矩形，起点在x=100,y=50的位置  
	    final Rectangle rect=new Rectangle(5, 200, 5, 5);  
	    rect.setFill(Color.RED);  
	    border.getChildren().add(rect); 
	    
	    final Text t=new Text();
	    t.setText("Tom");
	    t.setX(100);
	    t.setY(100);
	    border.getChildren().add(t); 
	    final Line line=new Line(0,105,500,105);
	    line.setStrokeWidth(5);
	    line.setStroke(Color.BLACK);
	    border.getChildren().add(line); 
	    //创建时间轴  
	    final Timeline timeline=new Timeline();  
	    timeline.setCycleCount(Timeline.INDEFINITE);//设置周期运行循环往复  
	    timeline.setAutoReverse(true);//设置动画的自动往返效果  
	      
	    //将x的位置在500ms内移动到300处  
	    final KeyValue kv=new KeyValue(t.xProperty(), 300);  
	    final KeyFrame kf=new KeyFrame(Duration.millis(50000), kv);  
	    //将关键帧加到时间轴中  
	    timeline.getKeyFrames().add(kf);  
	    timeline.play();//运行  
	    Ozlympic.mainStage.setScene(scene);
	    Ozlympic.mainStage.show();
	}
}
