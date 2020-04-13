package game1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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

        Group initialSceneLayout = new Group();
        this.initialScene = new InitialScene(initialSceneLayout, 600, 600);//here all the components of scene1 is being integrated.
        
        Button playButton = initialScene.getPlayButton();
        Button registerButton=initialScene.getRegisterButton();
        playButton.setOnAction(e -> window.setScene(instructionScene));//here i used lambda expression to switch between the scenes;
        //registerButton.setOnAction(e-> window.setScene(registrationScene));
        registerButton.setOnMouseClicked(event -> {
           window.setScene(registrationScene);
           
        });
         
        //->here i am joining the button with enter key below.
        playButton.setOnKeyPressed(
                event -> {
                    switch (event.getCode()) {
                        case ENTER:
                            window.setScene(instructionScene);
                    }
                }
        );
        registerButton.setOnKeyPressed(
                event -> {
                    switch (event.getCode()) {
                        case ENTER:
                            window.setScene(registrationScene);
                           
                    }
                }
        );
     
        
        //<<joining the button1 with keyboard's enter key is complete..*/

        //adding instruction scene:
        Group instructionSceneLayout=new Group();
        this.instructionScene=new InstructionScene(instructionSceneLayout,600,600);
        Button InstructionButton=instructionScene.getPlayButton();
        InstructionButton.setOnAction(e -> window.setScene(scn));
//adding complete.


//adding registration scene:
Group registrationSceneLayout=new Group();
        this.registrationScene=new RegistrationScene(registrationSceneLayout,600,600);
        Button regiCompleteButton=registrationScene.getPlayButton();
        regiCompleteButton.setOnAction(e -> window.setScene(instructionScene));
        //adding complete.

              Group layout2 = new Group();
        scn = new Scene(layout2, 600, 600);
        GameScene.gameScene(layout2,scn);
        window.setScene(initialScene);
        window.show();
   
    }

    public static void main(String[] args) {
      //  setupGame("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\IntroMusic.wav");
        launch(args);
    }

    //adding audio to the file:
    public static void setupGame(String filePath) { 
        InputStream music;
        try {
            music = new FileInputStream(new File(filePath));
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