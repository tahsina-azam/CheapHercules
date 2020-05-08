/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class InitialScene extends Scene {

    private Parent layout;
    private Button playButton;
    private Button registerButton;
    private Button okButton;
    private TextField nickNameField;
    private ImageView backgroundImg;
    private PasswordField passField;
    JFrame frame;

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

    public InitialScene(Group layout, double width, double height,Scene gameScene,Stage Window) {
        super(layout, width, height);

        this.layout = layout;
        
        
         //text work
   Text text=new Text(); //new text object is created
   text.setText("CHEAP ");//here the text which will be displayed is passed as a parameter
   text.setX(120);//here the coordinate of x axis is passed as a parameter
   text.setY(110);//here the coordinate of y axis is passed as a parameter
   text.setFill(Color.GREEN);//here the color of the text is passed as parameter
   text.setStroke(Color.BLACK);//here the parameter is the border color of the text
   text.setStrokeWidth(1);//here the parameter is the border width.
   text.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 40));//the specification of the font of the text is passed as a parameter
   
   Text text1=new Text(); //new text object is created
   text1.setText(" HERCULES ");//here the text which will be displayed is passed as a parameter
   text1.setX(130);//here the coordinate of x axis is passed as a parameter
   text1.setY(160);//here the coordinate of y axis is passed as a parameter
   text1.setFill(Color.GREEN);//here the color of the text is passed as parameter
   text1.setStroke(Color.BLACK);//here the parameter is the border color of the text
   text1.setStrokeWidth(1);//here the parameter is the border width.
   text1.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 40));//the specification of the font of the text is passed as a parameter
   
 Text text2=new Text(); //new text object is created
   text2.setText("Email :");//here the text which will be displayed is passed as a parameter
   text2.setX(120);//here the coordinate of x axis is passed as a parameter
   text2.setY(280);//here the coordinate of y axis is passed as a parameter
   text2.setFill(Color.LIGHTBLUE);//here the color of the text is passed as parameter
   text2.setStroke(Color.BLACK);//here the parameter is the border color of the text
   text2.setStrokeWidth(1);//here the parameter is the border width.
   text2.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 20));//the specification of the font of the text is passed as a parameter
   
   Text text3=new Text(); //new text object is created
   text3.setText("Password :");//here the text which will be displayed is passed as a parameter
   text3.setX(120);//here the coordinate of x axis is passed as a parameter
   text3.setY(315);//here the coordinate of y axis is passed as a parameter
   text3.setFill(Color.LIGHTBLUE);//here the color of the text is passed as parameter
   text3.setStroke(Color.BLACK);//here the parameter is the border color of the text
   text3.setStrokeWidth(1);//here the parameter is the border width.
   text3.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 20));//the specification of the font of the text is passed as a parameter
   

        //image1 specification starts:
        Image image;
        try {
            image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\waterfall.gif")); //path of the image is given here for first scene;

            this.backgroundImg = new ImageView(image);

            backgroundImg.setFitHeight(600);
            backgroundImg.setFitWidth(650); //these values are set so that the image can fit the stage/scene;

            // imageView.setPreserveRatio(true); 
            //image2 specification ends..
            //->button1 specification starts:
            this.playButton = new Button("FORGET PASSWORD");//clicking on this playButton takes you to the next screen;
             playButton.setLayoutX(450);//position in the x axis.
            playButton.setLayoutY(390);//position in the Y axix;
            String styles =
         "-fx-background-radius:100;"
         +"-fx-background-color:LIGHTBLUE"
         ;//here the styles of the button is added
            playButton.setStyle(styles);//the style is passed as a parameter
                    
  
            this.registerButton=new Button("CLICK TO REGISTER");//the button name is passed here as a parameter 
            registerButton.setLayoutX(450);//the position of this button in x axis
            registerButton.setLayoutY(430);//the position of this button in Y axis
            registerButton.setStyle(styles);//the button style is passed as a parameter
            
             this.okButton= new Button("ENTER");//new button name is passed as parameter which would be visible
            okButton.setLayoutX(300);//the position in x axis is passed as parameter
            okButton.setLayoutY(350);//the position of y axia is paassed as parameter
            okButton.setStyle(styles);//the style for the buttons is passed as parameter

            //here we are adding a text field to take name as input from the user
            this.nickNameField = new TextField();

            nickNameField.setAlignment(Pos.CENTER);//the position of this field is passed
            nickNameField.setPrefWidth(200);//the width is passed as a parameter
            nickNameField.setLayoutX(240);//the position of it in x axis is the parameter
            nickNameField.setLayoutY(260);//the position of it in y axis is the parameter
            //adding completed..
            
            //here we are adding password field to take password as input fromt the user
            this.passField=new PasswordField();//password field is created
            passField.setAlignment(Pos.CENTER);//position in the stage is passed as parameter
            passField.setPrefWidth(200);//required width is passed as parameter
            passField.setLayoutX(240);//position in the x axis is passed as parameter
            passField.setLayoutY(295); //position in the y axis is passed as parameter       

            
            layout.getChildren().add(backgroundImg);//here the image1 is being added to the layout.
            layout.getChildren().add(playButton);//here button1 is being added to the layout.
            layout.getChildren().add(nickNameField);//here we are adding the textfield to the layout.
            layout.getChildren().add(registerButton);//registerButton is added to the layout
            layout.getChildren().add(passField);//passwordfield is added to the layout
            layout.getChildren().addAll(text1,text2,text3,text,okButton);//all the texts and ok button is added to the layout
            okButton.setOnAction(e->System.out.println("user_id "+nickNameField.getText()+"password "+passField.getText()));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(InitialScene.class.getName()).log(Level.SEVERE, null, ex);
        }
        //setting action for the ok button
        okButton.setOnAction(e-> {
      checkDB(nickNameField,passField,gameScene,Window);
    });
         playButton.setOnAction(e->{//-----------------------------------------new add
            try {
                System.out.println("in reset");
                ResetPassword.reset();
            } catch (MessagingException ex) {
                Logger.getLogger(InitialScene.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(e);
            }
        });
        
    }
    //creating a method to check if the email and password provided by the player is correct
    private void  checkDB(TextField email, PasswordField password,Scene scn,Stage window){
    
    
    //getting email and password
    String user=email.getText();
    String pass=password.getText();
        try{
            //sql command
            String cmd="Select * from staff where email=?";
            
            //connecting to the database
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "root");//address userid password
             PreparedStatement pst=connection.prepareStatement(cmd);
             //pasing email to the database
             pst.setString(1, user);
             ResultSet rs=pst.executeQuery();
             if(rs.next())
             {
                 //getting password from database
              String p =rs.getString("password");
              if(pass.equals(p))
              {
                  //-----------------------------------------------------------------------------------------------
                   window.setScene(scn);
                  // if the provided password and email are correct we will playbutton the access to our insttructionscene
               //   playButton.setOnMouseClicked(event -> {------------------------------------------
         //  window.setScene(scn);-----------------------------------------
           
       // });------------------------------------------------------------------------------------------------------------------
                  System.out.println("login done");
              }
              else
              {
               //  JOptionPane.showMessageDialog(frame,"Invalid Password");
                  String message="Invalid Password";
                  JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
        JOptionPane.ERROR_MESSAGE);
             }
             }
             else
             {
                 
                 // JOptionPane.showMessageDialog(frame,"Invalid email");
                 String message="Invalid Email";
                  JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
        JOptionPane.ERROR_MESSAGE);
             }
        
        }catch (SQLException ex) {
           System.out.println(ex.getMessage());
           
           
        }
    
}
}
