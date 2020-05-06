/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import static game1.GameScene.playerScore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JOptionPane;


public class EnemyClass extends GameScene{
      private static  Integer STARTTIME4 = 2;
    private static Timeline timeLine4;
    private static Label timerLabel4 = new Label();
    private static IntegerProperty timeSeconds4 = new SimpleIntegerProperty(STARTTIME4);
    private static Rectangle rect2;
    private static javafx.animation.PathTransition pathTransition;
  public static void enemyChar(Rectangle rect,Group layout,Label plrScore,int r) throws FileNotFoundException{
        rect2 = new Rectangle(20,20,40,40);//creating anime object
        //adding pictures to rectangle below:
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\rocksteady.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 20, 20, 1, 1, true);
       rect2.setFill(image_pattern);
       javafx.scene.shape.Path path = new javafx.scene.shape.Path();//creating path for the enemy to move
        path.getElements().add(new MoveTo(274,25));//passing coordinates of the ending and starting point of the line
        path.getElements().add(new LineTo(274,167));
        path.getElements().add(new LineTo(215,167));
        path.getElements().add(new LineTo(215,90));
        path.getElements().add(new LineTo(30,90));
        path.getElements().add(new LineTo(30,540));
        path.getElements().add(new LineTo(90,540));
        path.getElements().add(new LineTo(90,390));
        path.getElements().add(new LineTo(156,390));
        path.getElements().add(new LineTo(156,540));
        path.getElements().add(new LineTo(276,540));
        path.getElements().add(new LineTo(276,391));
        path.getElements().add(new LineTo(206,391));
        path.getElements().add(new LineTo(206,225.64));
        path.getElements().add(new LineTo(277,225.64));
        path.getElements().add(new LineTo(277,335));
        path.getElements().add(new LineTo(330,335));
        path.getElements().add(new LineTo(330,465));
        path.getElements().add(new LineTo(440,465));
       // path.getElements().add(new LineTo(300,465));
       

         pathTransition = new javafx.animation.PathTransition();
        pathTransition.setDuration(Duration.millis(20000));//setting path duration time , sending it as parameter
        Node cbTypeCrc;
        pathTransition.setNode(rect2);//passing rect2 as parameter and selecting it as the node for path transition
        pathTransition.setPath(path);//selecting path for the enemy to move
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);//setting that the enemy would move indefinitely
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(true);//the enemy also would reversely move
        pathTransition.play();
        layout.getChildren().add(rect2);//passing enemy object as parameter and adding it to the layoout
        
        
       
            timerLabel4.textProperty().bind(timeSeconds4.asString());
        timerLabel4.setTextFill(Color.BLACK);
        timerLabel4.setLayoutX(410);
        timerLabel4.setLayoutY(25);
        timerLabel4.setStyle("-fx-font-size: 1.2em;");
          if (timeLine4 != null) {
                    timeLine4.stop();
                }
                timeSeconds4.set(STARTTIME4);
                timeLine4 = new Timeline();
                timeLine4.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME4+1),
                        new KeyValue(timeSeconds4, 0)));
                timeLine4.playFromStart();
   //  layout.getChildren().add(timerLabel4);
       
    
      rect2.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
        @Override
        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
            if(rect.getBoundsInParent().intersects(newValue)){
               // System.out.println("Collide ============= Collide");
                
               
                    if(r==1)
                    {
                        JOptionPane.showMessageDialog(null, "Game over");
                        GameScene.timerStop();
                        int zero=0;
                plrScore.setText(Integer.toString(zero));
                rect.setLayoutX(7);
                rect.setLayoutY(2);
                GameScene.playerScore=0;
                        
                    }
                  else if(r==2 && timeSeconds4.getValue()==0)
                  {
                      JOptionPane.showMessageDialog(null, "Game over");
                      LevelTwo.timerStop();
                      LevelTwo.autoScroll();
                      int zero=0;
                       plrScore.setText(Integer.toString(zero));
                rect.setLayoutX(7);
                rect.setLayoutY(2);
                GameScene.playerScore=0;
                 
                  }
                  else if(r==3 && timeSeconds4.getValue()==0)
                  {
                      JOptionPane.showMessageDialog(null, "Game over");
                      LevelThree.timerStop();
                      LevelThree.autoScroll2();
                      int zero=0;
                      plrScore.setText(Integer.toString(zero));
                rect.setLayoutX(7);
                rect.setLayoutY(2);
                GameScene.playerScore=0;
                        
                  }
                //setting the score to zero when rect will collide with rect3
               
            }
        }
    });
      
  
        
    }
  
 public static void startTimer(){
     STARTTIME4=15;
        if (timeLine4 != null) {
                    timeLine4.stop();
                }
                timeSeconds4.set(STARTTIME4);
                timeLine4 = new Timeline();
                timeLine4.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME4+1),
                        new KeyValue(timeSeconds4, 0)));
                timeLine4.playFromStart();
               
 }
 public static Rectangle getEnemy1(){
     return rect2;
 }
 public static void getTransition(){
          Timeline playtime = new Timeline(
    new KeyFrame(Duration.seconds(0.1), event -> pathTransition.play()),            
    new KeyFrame(Duration.seconds(1), event -> pathTransition.pause()),
    new KeyFrame(Duration.seconds(15), event -> pathTransition.play())
);
playtime.play();
     }
    
}
