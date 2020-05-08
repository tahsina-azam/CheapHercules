/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import static game1.GAME1.setupGame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JOptionPane;


public class Level2Enemy3 {
     private static  Integer STARTTIME6 = 2;
    private static Timeline timeLine6;
    private static Label timerLabel6 = new Label();
    private static IntegerProperty timeSeconds6 = new SimpleIntegerProperty(STARTTIME6);
    private static Rectangle rect4;
    private static javafx.animation.PathTransition pathTransition;
    public static void enemyChar(Rectangle rect,Group layout,Label plrScore,int r) throws FileNotFoundException{
        rect4 = new Rectangle(20,20,40,40);//creating anime object
        //adding pictures to rectangle below:
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\rocksteady.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 20, 20, 1, 1, true);
       rect4.setFill(image_pattern);
       javafx.scene.shape.Path path = new javafx.scene.shape.Path();//creating path for the enemy to move
        path.getElements().add(new MoveTo(104,695));//passing coordinates of the ending and starting point of the line
        path.getElements().add(new LineTo(634,695));
        path.getElements().add(new LineTo(634,308));//prob
        path.getElements().add(new LineTo(694,308));//prob
        path.getElements().add(new LineTo(694,695));
        path.getElements().add(new LineTo(694,308));
        path.getElements().add(new LineTo(634,308));//prob
        path.getElements().add(new LineTo(634,695));//prob
        path.getElements().add(new LineTo(104,695));
        path.getElements().add(new LineTo(394,694));
        path.getElements().add(new LineTo(394,627));
        path.getElements().add(new LineTo(574,627));
        path.getElements().add(new LineTo(574,230));//prob
        path.getElements().add(new LineTo(754,230));
        path.getElements().add(new LineTo(754,695));
        /*path.getElements().add(new LineTo(277,335));
        path.getElements().add(new LineTo(330,335));
        path.getElements().add(new LineTo(330,465));
        path.getElements().add(new LineTo(440,465));
       // path.getElements().add(new LineTo(300,465));*/
       

         pathTransition = new javafx.animation.PathTransition();
        pathTransition.setDuration(Duration.millis(17000));//setting path duration time , sending it as parameter
        Node cbTypeCrc;
        pathTransition.setNode(rect4);//passing rect4 as parameter and selecting it as the node for path transition
        pathTransition.setPath(path);//selecting path for the enemy to move
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);//setting that the enemy would move indefinitely
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(true);//the enemy also would reversely move
        pathTransition.play();
        layout.getChildren().add(rect4);//passing enemy object as parameter and adding it to the layoout
        
        timerLabel6.textProperty().bind(timeSeconds6.asString());
        timerLabel6.setTextFill(Color.BLACK);
        timerLabel6.setLayoutX(410);
        timerLabel6.setLayoutY(25);
        timerLabel6.setStyle("-fx-font-size: 1.2em;");
          if (timeLine6 != null) {
                    timeLine6.stop();
                }
                timeSeconds6.set(STARTTIME6);
                timeLine6 = new Timeline();
                timeLine6.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME6+1),
                        new KeyValue(timeSeconds6, 0)));
                timeLine6.playFromStart();
   //  layout.getChildren().add(timerLabel6);
        
        
     
    rect4.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
        @Override
        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
            if(rect.getBoundsInParent().intersects(newValue)){
                //setting the score to zero when rect will collide with rect3
                   if(r==2 && timeSeconds6.getValue()==0)
                  {
                      JOptionPane.showMessageDialog(null, "Game over");
                       setupGame("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\lose.wav");//activating music
                      LevelTwo.timerStop();
                      LevelTwo.autoScroll();
                      int zero=0;
                       plrScore.setText(Integer.toString(zero));
                rect.setLayoutX(7);
                rect.setLayoutY(2);
                GameScene.playerScore=0;
                      
                  }
                  else if(r==3 && timeSeconds6.getValue()==0)
                  {
                      JOptionPane.showMessageDialog(null, "Game over");
                       setupGame("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\lose.wav");//activating music
                      LevelThree.timerStop();
                      LevelThree.autoScroll2();
                      int zero=0;
                      plrScore.setText(Integer.toString(zero));
                rect.setLayoutX(7);
                rect.setLayoutY(2);
                GameScene.playerScore=0;
                
                      
                  }
            }
        }

           
    });
        
    }
  public static void startTimer(){
     STARTTIME6=15;
        if (timeLine6 != null) {
                    timeLine6.stop();
                }
                timeSeconds6.set(STARTTIME6);
                timeLine6 = new Timeline();
                timeLine6.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME6+1),
                        new KeyValue(timeSeconds6, 0)));
                timeLine6.playFromStart();
     }
          
    public static Rectangle getEnemy3(){
     return rect4;
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

    

