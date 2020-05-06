/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
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
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Enemy2 {
         private static  Integer STARTTIME5 = 2;
    private static Timeline timeLine5;
    private static Label timerLabel5 = new Label();
    private static IntegerProperty timeSeconds5 = new SimpleIntegerProperty(STARTTIME5);
    private static Rectangle rect3;
   private static javafx.animation.PathTransition pathTransition;
     public static void enemyChar(Rectangle rect,Group layout,Label plrScore,int r) throws FileNotFoundException{
        rect3 = new Rectangle(20,20,40,40);//creating enemy object
       //adding pictures to the enemy
       FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\rocksteady.png");
        Image img3 = new Image(input);
       
        ImagePattern image_pattern = new ImagePattern(img3, 20, 20, 1, 1, true);
       rect3.setFill(image_pattern);
       //image addition has been completed successfully
       javafx.scene.shape.Path path = new javafx.scene.shape.Path();//creating path for the enemy to move it randomly
        path.getElements().add(new MoveTo(328,25));
        path.getElements().add(new LineTo(328,100.67));
        path.getElements().add(new LineTo(450,100.67));
        path.getElements().add(new LineTo(450,240));
       path.getElements().add(new LineTo(328,240));
        path.getElements().add(new LineTo(328,160));
        path.getElements().add(new LineTo(390,160));
       path.getElements().add(new LineTo(328,160));
        path.getElements().add(new LineTo(328,240));
        path.getElements().add(new LineTo(450,240));
        path.getElements().add(new LineTo(450,100));
        path.getElements().add(new LineTo(328,100));
        path.getElements().add(new LineTo(328,30));
        path.getElements().add(new LineTo(510,30));
        path.getElements().add(new LineTo(510,310));
        path.getElements().add(new LineTo(388,310));
        path.getElements().add(new LineTo(388,400));
        path.getElements().add(new LineTo(510,400));
        path.getElements().add(new LineTo(510,540));
        path.getElements().add(new LineTo(276,540));
        path.getElements().add(new LineTo(276,391));
       path.getElements().add(new LineTo(206,391));
       path.getElements().add(new LineTo(206,225.64));
       path.getElements().add(new LineTo(277,225.64));

         pathTransition = new javafx.animation.PathTransition();
        pathTransition.setDuration(Duration.millis(15000));//setting the time for path transition
        Node cbTypeCrc;
        pathTransition.setNode(rect3);//setting node for path transition
        pathTransition.setPath(path);//setting patha for path transition
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);//enemey will move until we stop the program
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        layout.getChildren().add(rect3);//adding enemy to the layout
        
        
         timerLabel5.textProperty().bind(timeSeconds5.asString());
        timerLabel5.setTextFill(Color.BLACK);
        timerLabel5.setLayoutX(410);
        timerLabel5.setLayoutY(25);
        timerLabel5.setStyle("-fx-font-size: 1.2em;");
          if (timeLine5 != null) {
                    timeLine5.stop();
                }
                timeSeconds5.set(STARTTIME5);
                timeLine5 = new Timeline();
                timeLine5.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME5+1),
                        new KeyValue(timeSeconds5, 0)));
                timeLine5.playFromStart();
     //layout.getChildren().add(timerLabel5);
        
        rect3.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
        @Override
        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
            if(rect.getBoundsInParent().intersects(newValue)){
               // System.out.println("Collide ============= Collide");
                //JOptionPane.showMessageDialog(null, "Game over");
                //setting the score to zero when rect will collide with rect3
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
                  else if(r==2 && timeSeconds5.getValue()==0)
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
                  else if(r==3 && timeSeconds5.getValue()==0)
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
            }
        }
    });
        
    }
     public static void startTimer(){
     STARTTIME5=15;
        if (timeLine5 != null) {
                    timeLine5.stop();
                }
                timeSeconds5.set(STARTTIME5);
                timeLine5 = new Timeline();
                timeLine5.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME5+1),
                        new KeyValue(timeSeconds5, 0)));
                timeLine5.playFromStart();
     }
      public static Rectangle getEnemy2(){
     return rect3;
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
    
    
    

