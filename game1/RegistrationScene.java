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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author USER
 */
public class RegistrationScene extends Scene{
     private GridPane grid;
      TextField emailField=new TextField();
      TextField nameField=new TextField();
      TextField birthdayField=new TextField();
      TextField passwordField=new TextField();
      TextField mobilePhoneNoField=new TextField();
      
      //Creating buttons
      Button submitButton=new Button("Sign in");//passing a string as parameter which will be shown as the name
      Button clearButton=new Button("Clear");//passing a string as parameter which will be shown as the name
      Button backLogin=new Button("Go back and login");//passing a string as parameter which will be shown as the name


    public GridPane getLayout() {
        return grid;
    }

    public void setLayout(Parent layout) {
        this.grid = grid;
    }

    public Button backLoginButton() {
        return backLogin;
    }
    
    public void setbackLogin(Button playButton) {
        this.backLogin = playButton;
    }

 

    public RegistrationScene(GridPane grid) throws FileNotFoundException {
        super(grid);

        this.grid = grid;
        
         //creating text;
      Text text=new Text(); 
      text.setText("REGISTRATION FORM ");//passing a string as parameter which will be shown as the name
      text.setFill(Color.LIGHTGREEN);//passing the color name as the parameter
      text.setStroke(Color.BLACK);//passing the color name as the parameter
      text.setStrokeWidth(1);//passing the border width of text as a parameter
      text.setFont(Font.font("abc", FontWeight.BOLD,FontPosture.ITALIC, 25));//font of the text as parameter
   
      //creating email,name,password,birthday text
      Text email=new Text("Email:");//passing a string as parameter which will be shown as the name
    //  email.setStroke(Color.WHITE);//passing color as a parameter
      Text name=new Text("UserName:");//passing a string as parameter which will be shown as the name
     // name.setStroke(Color.WHITE);//passing color as a parameter
      Text birthday=new Text("Birthdate:");//passing a string as parameter which will be shown as the name
      //birthday.setStroke(Color.WHITE);//passing color as a parameter
      Text password =new Text("Password:");//passing a string as parameter which will be shown as the name
     // password.setStroke(Color.WHITE);//passing color as parameter
      Text mobilePhoneNo=new Text("Mobile Phone No:");//passing a string as parameter which will be shown as the name
       // mobilePhoneNo.setStroke(Color.WHITE);//passing color as parameter
     
      
      //adding image to the gridpane:
      Image image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\interface.jpg")); //path of the image is given here for first scene;
grid.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));
          
   String styles =
         "-fx-background-radius:100;"
         +"-fx-background-color:LIGHTGREEN"
         ;//fixing the styles of the buttons
   submitButton.setStyle(styles);//adding style to the button
   clearButton.setStyle(styles);//adding style to the button
   backLogin.setStyle(styles);//adding style to the button
   
      grid.setMinSize(650,600);//passing the desired length and width of gridpane
      
      
      //Setting the vertical and Horizontal gaps between the columns
      grid.setVgap(25);//setting vertical gap
      grid.setHgap(15);//setting horizontal gap 
      
     
      //Setting the grid allignment
      grid.setAlignment(Pos.CENTER);//passing alignment position of the gridpane as parameters
      grid.add(text,0,0);//passing text and its coordinates as parameters
      grid.add(email,0,1);//passing text and its coordinates as parameters
      grid.add(emailField, 1, 1);//passing fieldname and its coordinates as parameters
      grid.add(mobilePhoneNo,0,2);//passing text and its coordinates as parameters
      grid.add(mobilePhoneNoField,1,2);//passing fieldname and its coordinates as parameters
      grid.add(name, 0, 3);//passing text and its coordinates as parameters
      grid.add(nameField,1,3);//passing fieldname and its coordinates as parameters
      grid.add(birthday,0,4);//passing text and its coordinates as parameters
      grid.add(birthdayField,1,4);//passing fieldname and its coordinates as parameters
      grid.add(password,0,5);//passing text and its coordinates as parameters
      grid.add(passwordField,1,5);//passing fieldname and its coordinates as parameters
     
      grid.add(submitButton,0,6);//passing button name and its coordinates as parameters
      grid.add(clearButton,1,6);//passing buttons name and its coordinates as parameters
      grid.add(backLogin,0,7);//passing button name and its coordinates as parameters
      
      
      //setting action for the clear button
      clearButton.setOnAction(e-> clearFields());
      //setting action for the submitButton
      submitButton.setOnAction(e->{
          try {
              connectDB();//try catch statement to store data in the database and to check if its done right

          } catch (SQLException ex) {
              Logger.getLogger(RegistrationScene.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
   

       
    } 
     //method for clear button
   public void clearFields(){
       emailField.setText(null);
       nameField.setText(null);
       birthdayField.setText(null);
       passwordField.setText(null);
       mobilePhoneNoField.setText(null); 
   }
   //helping method for  registration button
       public void connectDB() throws SQLException{
        //Connect to MySQL
        try{
            // connecting to the database
            try(Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/javadb","root",""))
            {
               
               String birthdaysql= birthdayField.getText();
                String passwordsql=passwordField.getText();
                String namesql=nameField.getText();
                String emailsql=emailField.getText();
                String mobilePhoneNosql=mobilePhoneNoField.getText();
                
                //command for adding data in mysql database
                
            String sql="insert into staff (email,mobilePhoneNo,name,birthdate,password)  values(?,?,?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            
               statement.setString(1,emailsql);
               statement.setString(2,mobilePhoneNosql);
               statement.setString(3,namesql);
               statement.setString(4,birthdaysql);
               statement.setString(5,passwordsql);
               
               statement.execute();
                System.out.println("DB updated");

             
        }
        }
        
        catch(SQLException e){
            System.out.println("DB failed!");
            System.out.println(e.getMessage());
            
        }
        
       }
  
}
