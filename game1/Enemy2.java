/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
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
     public static void enemyChar(Rectangle rect,Group layout) throws FileNotFoundException{
       Rectangle rect2 = new Rectangle(20,20,40,40);
       FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\rocksteady.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 20, 20, 1, 1, true);
       rect2.setFill(image_pattern);
       javafx.scene.shape.Path path = new javafx.scene.shape.Path();
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
        path.getElements().add(new LineTo(328,25));
        path.getElements().add(new LineTo(510,25));
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

        javafx.animation.PathTransition pathTransition = new javafx.animation.PathTransition();
        pathTransition.setDuration(Duration.millis(15000));
        Node cbTypeCrc;
        pathTransition.setNode(rect2);
        pathTransition.setPath(path);
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        layout.getChildren().add(rect2);
        
         ObservableBooleanValue colliding = Bindings.createBooleanBinding(new Callable<Boolean>() {

        @Override
        public Boolean call() throws Exception {
            return rect.getBoundsInParent().intersects(rect2.getBoundsInParent());
        }

    }, rect.boundsInParentProperty(), rect2.boundsInParentProperty());

    colliding.addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs,
                Boolean oldValue, Boolean newValue) {
            if (newValue) {
                JOptionPane.showMessageDialog(null, "Game over");
            } 
        }
    });
        
        
    }
    
    
}
