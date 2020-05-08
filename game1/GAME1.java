package game1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author USER
 */
public class GAME1 extends Application { 

    Stage window;//window is a stage type variable
    
    private InitialScene initialScene;
    private InstructionScene instructionScene;
    private RegistrationScene registrationScene;
   // private GameScene gameScene;
    Scene scn;//scn and initialScene are two scene type variables
    private int x = 25;
    private int y = 25;
    private int speedX = 1;
    private int speedY = 1;
  
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        this.window = primaryStage;
         Group layout2 = new Group();
        scn = new Scene(layout2, 600, 600);
     //   GameScene.gameScene(layout2,scn,window);
        
         Group instructionSceneLayout=new Group();
        this.instructionScene=new InstructionScene(instructionSceneLayout,600,600);

        Group initialSceneLayout = new Group();
        this.initialScene = new InitialScene(initialSceneLayout, 650, 600,instructionScene,window);//here all the components of scene1 is being integrated.
        
        Button playButton = initialScene.getPlayButton();
        Button registerButton=initialScene.getRegisterButton();
    
        registerButton.setOnMouseClicked(event -> {
          window.setScene(registrationScene);
          
           
        });
       
        registerButton.setOnKeyPressed(//settinh keyboard control for register button
                event -> {
                    switch (event.getCode()) {
                        case ENTER:
                            window.setScene(registrationScene);
                           
                    }
                }
        );
     
        
        
        Button InstructionButton=instructionScene.getPlayButton();//calling the getter setter function to retrieve the button form another class
       // InstructionButton.setOnAction(e ->{window.setScene(scn)});//adding action to instructionButton
       InstructionButton.setOnMouseClicked(event -> {
            try { 
                GameScene.gameScene(layout2,scn,window);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GAME1.class.getName()).log(Level.SEVERE, null, ex);
            }
          window.setScene(scn);

        });
//adding complete.


//adding registration scene:
GridPane registrationSceneLayout=new GridPane();//creating gridpane
        this.registrationScene=new RegistrationScene(registrationSceneLayout);//passing layout as parameter
        Button regiCompleteButton=registrationScene.backLoginButton();//getter setter function call to retrieve a button
        regiCompleteButton.setOnAction(e -> window.setScene(initialScene));//adding control to the button
        //adding complete.

             
        window.setScene(initialScene);//passing the scene as parameter which the user will se first
        setupGame("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\IntroMusic.wav");//activating music
        window.show();
        
        
    }

    public static void main(String[] args) {
        //setupGame("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\IntroMusic.wav");//activating music
        launch(args);
    }

    //adding audio to the file:
    public static void setupGame(String filePath) { 
        InputStream music;
        try {
            music = new FileInputStream(new File(filePath));//adding music file
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }
    
    

} 

//method name should not be the same as class name
//variable name should have camel case
//the code logic seems alright
//but as you can see, the whole code has become massive
//The easiest thing to do would be to move scn and initialScene to different classes
//Let me show you an example
//try to use easy to understand variable names
//all fields should be private 
//they should be accessed from outside via getters and setters