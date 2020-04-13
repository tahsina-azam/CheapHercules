/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author USER
 */
public class InitialScene extends Scene {

    private Parent layout;
    private Button playButton;
    private Button registerButton;
    private TextField nickNameField;
    private ImageView backgroundImg;
    private PasswordField passField;

    public Parent getLayout() {
        return layout;
    }

    public void setLayout(Parent layout) {
        this.layout = layout;
    }

    public Button getPlayButton() {
        return playButton;
    }
    public Button getRegisterButton(){
        return registerButton;
    }

    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }
    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
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

    public InitialScene(Group layout, double width, double height) {
        super(layout, width, height);

        this.layout = layout;
        
        
         //text work
   Text text=new Text(); 
   text.setText("CHEAP ");
   text.setX(120);
   text.setY(110);
   text.setFill(Color.GREEN);
   text.setStroke(Color.BLACK);
   text.setStrokeWidth(1);
   text.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 40));
   
   Text text1=new Text(); 
   text1.setText(" HERCULES ");
   text1.setX(130);
   text1.setY(160);
   text1.setFill(Color.GREEN);
   text1.setStroke(Color.BLACK);
   text1.setStrokeWidth(1);
   text1.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 40));
   
 Text text2=new Text(); 
   text2.setText("User Name :");
   text2.setX(120);
   text2.setY(280);
   text2.setFill(Color.GREEN);
   text2.setStroke(Color.BLACK);
   text2.setStrokeWidth(1);
   text2.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 20));
   
   Text text3=new Text(); 
   text3.setText("Password :");
   text3.setX(120);
   text3.setY(315);
   text3.setFill(Color.GREEN);
   text3.setStroke(Color.BLACK);
   text3.setStrokeWidth(1);
   text3.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 20));
   

        //image1 specification starts:
        Image image;
        try {
            image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\waterfall.gif")); //path of the image is given here for first scene;

            this.backgroundImg = new ImageView(image);

            backgroundImg.setFitHeight(600);
            backgroundImg.setFitWidth(600); //these values are set so that the image can fit the stage/scene;

            // imageView.setPreserveRatio(true); 
            //image2 specification ends..
            //->button1 specification starts:
            this.playButton = new Button("CLICK TO PLAY");//clicking on this playButton takes you to the next screen;
             playButton.setLayoutX(400);//position in the x axis.
            playButton.setLayoutY(390);//position in the Y axix;
            String styles =
         "-fx-background-radius:100;"
         +"-fx-background-color:LIGHTBLUE"
         ;
            playButton.setStyle(styles);
  
            this.registerButton=new Button("CLICK TO REGISTER");
            registerButton.setLayoutX(400);
            registerButton.setLayoutY(430);
            registerButton.setStyle(styles);
            
            Button okButton= new Button("ENTER");
            okButton.setLayoutX(400);
            okButton.setLayoutY(350);
            okButton.setStyle(styles);

            //here we are adding a text field to take name as input from the user
            this.nickNameField = new TextField();

            nickNameField.setAlignment(Pos.CENTER);
            nickNameField.setPrefWidth(200);
            nickNameField.setLayoutX(240);
            nickNameField.setLayoutY(260);
            //adding completed..
            
            this.passField=new PasswordField();
            passField.setAlignment(Pos.CENTER);
            passField.setPrefWidth(200);
            passField.setLayoutX(240);
            passField.setLayoutY(295);        

            //<<button1 specification ends..
            layout.getChildren().add(backgroundImg);//here the image1 is being added to the layout.
            layout.getChildren().add(playButton);//here button1 is being added to the layout.
            layout.getChildren().add(nickNameField);//here we are adding the textfield to the layout.
            layout.getChildren().add(registerButton);
            layout.getChildren().add(passField);
            layout.getChildren().addAll(text1,text2,text3,text,okButton);
            okButton.setOnAction(e->System.out.println("user_id "+nickNameField.getText()+"password "+passField.getText()));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(InitialScene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
