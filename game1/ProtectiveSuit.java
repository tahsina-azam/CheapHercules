/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author USER
 */
public class ProtectiveSuit {
   static int x;
   static int y;
    public static Rectangle suitCreation(Group layout) throws FileNotFoundException{
        Random rand=new Random();
        int upperBound=4;
        int intRandom=rand.nextInt(upperBound);
      if(intRandom==0){
          x=615;
          y=390;
      }
      else if(intRandom==1){
          x=670;
          y=308;
      }
      else if(intRandom==2){
          x=276;
          y=391;
      }
      else{
          x=420;
          y=604;
      }
         Rectangle rectShield=new Rectangle(x,y,40,40);
        FileInputStream inputShield = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\bulletproof-vest.png");//adding image to the character
        Image imgShield = new Image(inputShield);//passing image object as parameter
        ImagePattern image_Shield = new ImagePattern(imgShield, 156,390, 1, 1, true);//passing image object,coordinates,ratio as parameter
       rectShield.setFill(image_Shield);
       layout.getChildren().add(rectShield);
       return rectShield;
    }
/*  public static void rectCollisin(Rectangle shot,Rectangle rect)
  {
      shot.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
        @Override
        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
            if(rect.getBoundsInParent().intersects(newValue)){
               // System.out.println("Collide ============= Collide");
                 
                System.out.println("hit");
                       
            }
        }

         
    });
      
  
  }*/
    
}
