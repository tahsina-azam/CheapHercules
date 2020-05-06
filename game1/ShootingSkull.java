/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import static game1.ProtectiveSuit.x;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author USER
 */
public class ShootingSkull {
     private static  Integer STARTTIME7 = 2;
    private static Timeline timeLine7;
    private static Label timerLabel7 = new Label();
    public static IntegerProperty timeSeconds7 = new SimpleIntegerProperty(STARTTIME7);
    private static Rectangle rect2;
    private static Rectangle eneMy1=EnemyClass.getEnemy1();
    private static Rectangle eneMy2=Enemy2.getEnemy2();
    private static Rectangle eneMy3=Level2Enemy3.getEnemy3();
    private static int i=2;
    public static Rectangle skullCreation(Group layout, Rectangle rect) throws FileNotFoundException{
        Rectangle shootingPistol=new Rectangle(15,340,40,40);
        FileInputStream inputShield = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\skull (1).png");//adding image to the character
        Image imgShield = new Image(inputShield);//passing image object as parameter
        ImagePattern image_Shield = new ImagePattern(imgShield, 156,390, 1, 1, true);//passing image object,coordinates,ratio as parameter
       shootingPistol.setFill(image_Shield);
       layout.getChildren().add(shootingPistol);
       timerLabel7.textProperty().bind(timeSeconds7.asString());
        timerLabel7.setTextFill(Color.BLACK);
        timerLabel7.setLayoutX(410);
        timerLabel7.setLayoutY(25);
        timerLabel7.setStyle("-fx-font-size: 1.2em;");
          if (timeLine7 != null) {
                    timeLine7.stop();
                }
                timeSeconds7.set(STARTTIME7);
                timeLine7 = new Timeline();
                timeLine7.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME7+1),
                        new KeyValue(timeSeconds7, 0)));
                timeLine7.playFromStart();
       
               return shootingPistol; 
                
    }
     public static void startTimer(){
     STARTTIME7=2;
        if (timeLine7 != null) {
                    timeLine7.stop();
                }
                timeSeconds7.set(STARTTIME7);
                timeLine7 = new Timeline();
                timeLine7.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME7+1),
                        new KeyValue(timeSeconds7, 0)));
                timeLine7.playFromStart();
     }
     
 
    
}
