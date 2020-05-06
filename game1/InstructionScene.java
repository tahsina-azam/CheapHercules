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
public class InstructionScene extends Scene{
    private Parent layout2;
    private Button playButton;
    private TextField nickNameField;
    private ImageView backgroundImg;

    public Parent getLayout() {
        return layout2;
    }

    public void setLayout(Parent layout) {
        this.layout2 = layout;
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

    public InstructionScene(Group layout2, double width, double height) {
        super(layout2, width, height);

        this.layout2 = layout2;

        //image1 specification starts:
        Image image;
        try {
            image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\instructionscene.gif")); //path of the image is given here for first scene;

            this.backgroundImg = new ImageView(image);

            backgroundImg.setFitHeight(600);
            backgroundImg.setFitWidth(600); //these values are set so that the image can fit the stage/scene;
            
            //this string is used for making button a little bit round and setting background color
   String styles =
         "-fx-background-radius:100;"
         +"-fx-background-color:LIGHTBLUE"
         ;
   
             this.playButton = new Button("READY TO PLAY");//clicking on this playButton takes you to the next screen;

            playButton.setLayoutX(225);//position in the x axis.
            playButton.setLayoutY(450);//position in the Y axix;
            playButton.setStyle(styles);
            layout2.getChildren().add(backgroundImg);//here the image1 is being added to the layout.
            layout2.getChildren().add(playButton);
            
  } catch (FileNotFoundException ex) {
            Logger.getLogger(InstructionScene.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
    }
    
}
