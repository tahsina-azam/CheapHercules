/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author USER
 */
public class RegistrationScene extends Scene{
     private Parent layout3;
    private Button playButton;
    private TextField nickNameField;
    private ImageView backgroundImg;

    public Parent getLayout() {
        return layout3;
    }

    public void setLayout(Parent layout) {
        this.layout3 = layout;
    }

    public Button getPlayButton() {
        return playButton;
    }
    
    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }

    public TextField getNickNameField() {
        return nickNameField;
    }

    public void setNickNameField(TextField nickNameField) {
        this.nickNameField = nickNameField;
    }

    public ImageView getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(ImageView backgroundImg) {
       this.backgroundImg = backgroundImg;
    }

    public RegistrationScene(Group layout3, double width, double height) {
        super(layout3, width, height);

        this.layout3 = layout3;

        //image1 specification starts:
        Image image;
        try {
            image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\totoro (2).gif")); //path of the image is given here for first scene;

            this.backgroundImg = new ImageView(image);

            backgroundImg.setFitHeight(600);
            backgroundImg.setFitWidth(600); //these values are set so that the image can fit the stage/scene;

            // imageView.setPreserveRatio(true); 
            //image2 specification ends..
            //->button1 specification starts:
            this.playButton = new Button("REGISTRATION DONE");//clicking on this playButton takes you to the next screen;

            playButton.setLayoutX(250);//position in the x axis.
            playButton.setLayoutY(350);//position in the Y axix;

           

            //<<button1 specification ends..
            layout3.getChildren().add(backgroundImg);//here the image1 is being added to the layout.
            layout3.getChildren().add(playButton);//here button1 is being added to the layout.
           

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(InitialScene.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
  
}
