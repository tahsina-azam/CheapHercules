/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class HomeChar {
    public static Rectangle homeChar(Rectangle rect,Group layout) throws FileNotFoundException{
       Rectangle rect2 = new Rectangle(788,680,50,50);
        //adding pictures to rectangle below:
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\farmhouse.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 570, 575, 1, 1, true);
       rect2.setFill(image_pattern);
       
        layout.getChildren().add(rect2);
        
     return rect2;//returning the object of bossfarmer for further control check
        
    }
    
}
