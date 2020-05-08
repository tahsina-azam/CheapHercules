package game1;

import static game1.GAME1.setupGame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class GameScene extends GAME1{
    private static int x = 2;
    private static int y = 2;
    private static int z = 2;
     static int playerScore=0;
      private static  Integer STARTTIME = 50;
    private static Timeline timeline;
    private static Label timerLabel = new Label();
    private static IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    private ArrayList<Line> lineArrayList;
     public static void gameScene(Group layout, Scene scn,Stage window) throws FileNotFoundException{
            //image2
       Image image1 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\surface.png"));//image2 file path is given here.
        ImageView img = new ImageView(image1);//passing image as the parameter

        //adding pictures to rectangle below:
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\shredder.png");
        Image img3 = new Image(input);//passing image object as parameter
        ImagePattern image_pattern = new ImagePattern(img3, 15, 15, 1, 1, true);//passing image object,coordinates,ratio as parameter
        Rectangle rect = new Rectangle(15, 15, 40, 40);//passing coordinates as parameters
        rect.setFill(image_pattern);//filling the rectangle with image pattern
       
        
        //adding picture to the coin
 FileInputStream inputCoin = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\download.jpg");
        Image imgCoin = new Image(inputCoin);
        ImagePattern image_Coin = new ImagePattern(imgCoin, 340, 350, 1,1 , true);        
       Circle circle1 = new Circle(); //creating circle as object
        circle1.setCenterX(330.0f);//setting the center of the circle
circle1.setCenterY(340.0f);
circle1.setRadius(10.0f);
circle1.setFill(image_Coin);


//diamond coin making
      FileInputStream inputCoind = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\vector-diamonds.png");
        Image imgCoind = new Image(inputCoind);
        ImagePattern image_Coind = new ImagePattern(imgCoind, 330, 350, 1,1 , true);        
       Circle circle2 = new Circle(); 
        circle2.setCenterX(250.0f);
circle2.setCenterY(50.0f);
circle2.setRadius(10.0f);
circle2.setFill(image_Coind);
Circle circle3=new Circle();
circle3.setCenterX(250.0f);
circle3.setCenterY(250.0f);
circle3.setRadius(10.0f);
circle3.setFill(image_Coin);


        //image2 specification starts:
        img.setFitHeight(600);
        img.setFitWidth(600);
        img.setPreserveRatio(true);
        //image2 specification ends.
        layout.getChildren().add(img);//adding image to the background
        layout.getChildren().add(rect);//adding rectangle to the background
        //maze making starts:
        ArrayList<Line> lineArrayList = new ArrayList<Line>();//declaration of a arraylist of line which will form the maze
        lineArrayList.add(new Line(2.0,3.00,598.0,3.0));//passing the coordinates of start and ending point of the line
        lineArrayList.add(new Line(2.0,598.00,598.00,597.00));
        lineArrayList.add(new Line(2.0,597.00,2.0,66.67));
        lineArrayList.add(new Line(598.0,3.0,598.0,533.33));
        lineArrayList.add(new Line(2.0,66.67,242.0,66.67));
        lineArrayList.add(new Line(242.0,66.67,242.0,133.34));
         lineArrayList.add(new Line(60.0,133.34,182.0,133.34));
          lineArrayList.add(new Line(60.0,200.01,60.0,533.34));
           lineArrayList.add(new Line(60.0,366.67,180.00,366.67));
            lineArrayList.add(new Line(120.0,598.00,120.0,466.66));
         lineArrayList.add(new Line(182.0,133.34,180.0,433.34));
          lineArrayList.add(new Line(180.0,433.34,240.00,433.34));
           lineArrayList.add(new Line(240.00,433.34,240.00,500.0));
            lineArrayList.add(new Line(240.00,500.0,180.0,500.0));
             lineArrayList.add(new Line(182.0,200.00,302.00,200.00));
              lineArrayList.add(new Line(302.00,266.64,302.00,2.00));
               lineArrayList.add(new Line(302.00,266.64,482.00,266.64));
                lineArrayList.add(new Line(482.00,266.64,482.00,66.67));
                 lineArrayList.add(new Line(482.00,66.67,362.00,66.67));
        lineArrayList.add(new Line(302.00,133.34,422.00,133.34));
         lineArrayList.add(new Line(422.00,133.34,422.00,200.01)); 
          lineArrayList.add(new Line(422.00,200.01,355.00,200.01)); 
           lineArrayList.add(new Line(540.00,66.67,540.00,598.00)); 
            lineArrayList.add(new Line(540.00,333.35,420,333.35)); 
             lineArrayList.add(new Line(362.00,266.64,362.00,433.34)); 
              lineArrayList.add(new Line(362.00,433.34,480.00,433.34)); 
               lineArrayList.add(new Line(480.00,433.34,480.00,500.00)); 
                lineArrayList.add(new Line(480.00,500.00,300.00,500.00)); 
                 lineArrayList.add(new Line(300.00,500.00,300.00,366.63)); 
                  lineArrayList.add(new Line(300.00,366.63,240.00,366.63)); 
                   lineArrayList.add(new Line(240.00,366.63,240.00,300.00)); 
                   
        
        layout.getChildren().addAll(lineArrayList);//adding all the lines to the layout passing arraylist as parameter
        layout.getChildren().add(circle2);//passing circle as parameter
      layout.getChildren().add(circle1);//passing circle as parameter
       layout.getChildren().add(circle3);//passing circle as parameter
       
       timerLabel.textProperty().bind(timeSeconds.asString());//label adding
        timerLabel.setTextFill(Color.BLACK);
        timerLabel.setPadding(new Insets(570,570, 390,390));
        timerLabel.setStyle("-fx-font-size: 1.3em;");
        if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds.set(STARTTIME);
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(STARTTIME++),
                        new KeyValue(timeSeconds, 0)));
                timeline.playFromStart();
                if(STARTTIME==0)
                {
                    JOptionPane.showMessageDialog(null, "Game Over", STYLESHEET_MODENA, 0);
                }
                layout.getChildren().add(timerLabel);
                Label timer=new Label("TIMER:");
                timer.setTextFill(Color.BLACK);//passing the color of the label as the parameter
                timer.setAlignment(Pos.BOTTOM_CENTER);//passing the position of the label
                timer.setPadding(new Insets(570,570, 340, 340));//passing the coordinates of the label ,first two for x and others are for y axis
                timer.setStyle("-fx-font-size: 1.3em;");
                layout.getChildren().add(timer);
       
       Label goal = new Label("GOAL:50");//the parameter is a string which will show the target of the player in the console
        goal.setTextFill(Color.BLACK);//passing the color of the label as the parameter
        goal.setAlignment(Pos.BOTTOM_CENTER);//passing the position of the label
        goal.setPadding(new Insets(570,570, 200, 200));//passing the coordinates of the label ,first two for x and others are for y axis
         goal.setStyle("-fx-font-size: 1.3em;");///newwwwllllyyy added
        layout.getChildren().add(goal);//adding the label by passing it's object
        Label score=new Label("SCORE:");//new label
        score.setTextFill(Color.BLACK);//passing color
        score.setAlignment(Pos.BOTTOM_CENTER);//passing position as parametere
        score.setPadding(new Insets(570,570, 270,270));//passing coordinates as parameter
        score.setStyle("-fx-font-size: 1.3em;");
        layout.getChildren().add(score);//adding to the console by passing label's object
        
         Label plrScore=new Label();//new label object
        plrScore.setTextFill(Color.BLACK);
        plrScore.setAlignment(Pos.BOTTOM_CENTER);
        plrScore.setText(Integer.toString(playerScore));//setting the score which is a variable and making it string
        plrScore.setPadding(new Insets(570,570,320,320));
        plrScore.setStyle("-fx-font-size: 1.3em;");
        layout.getChildren().add(plrScore);//adding the score
        
        EnemyClass.enemyChar(rect,layout,plrScore,1);//calling enemy class
        Enemy2.enemyChar(rect, layout,plrScore,1);//calling another
       Rectangle rect2= BossFarmer.BossChar(rect, layout);//calling method from another class to make other character
       
       //group and scene creation is done below for the second level:
       VBox root = new VBox(); 
       Scene sceneLevelTwo=new Scene(root,600,600);
        Group gp=new Group();
        
       //keyboard control of the main character of the game
        scn.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT) {
                    rect.setLayoutX(rect.getLayoutX() + 10);
      for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){//checking collision
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);//if rect touches the lines the line would be white
           rect.setLayoutX(rect.getLayoutX() - 10);//if the rect touches the lines it will stay at its place
       }
       else
       {
          lineArrayList.get(i).setStroke(Color.BLACK); //otherwise it will become black 
       }
      }
      if(rect.getBoundsInParent().intersects(circle1.getBoundsInParent())){//cheking collision for the coins
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));//adding value of the coins
          if(x==2){
              circle1.relocate(440, 465);//positions where the coins would appear
              x--;
          }
          else{
              circle1.relocate(328, 200);//positions where the coins would appear
              x++;
          }
      }
       if(rect.getBoundsInParent().intersects(circle2.getBoundsInParent())){
          System.out.println("diamond");
           plrScore.setText(Integer.toString(playerScore+=10));
           if(y==2){
              circle2.relocate(250, 167);
              y--;
               
          }
          else{
              circle2.relocate(90, 450);
              y++;
          }
      }
       if(rect.getBoundsInParent().intersects(circle3.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(z==2){
              circle3.relocate(510, 450);
              z--;
          }
          else{
              circle3.relocate(328,75);
              z++;
          }
           
      }
                } else if (event.getCode() == KeyCode.LEFT) {
                    rect.setLayoutX(rect.getLayoutX() - 10);
                    for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutX(rect.getLayoutX() + 10);
       }
       else
       {
          lineArrayList.get(i).setStroke(Color.BLACK);  
       }
      }
                    if(rect.getBoundsInParent().intersects(circle1.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(x==2){
              circle1.relocate(440, 465);
              x--;
          }
          else{
              circle1.relocate(328, 200);
              x++;
          }
                      
      }
       if(rect.getBoundsInParent().intersects(circle2.getBoundsInParent())){
          System.out.println("diamond");
           plrScore.setText(Integer.toString(playerScore+=10));
            if(y==2){
              circle2.relocate(250, 167);
              y--;
               
          }
          else{
              circle2.relocate(90, 450);
              y++;
          }
      }
        if(rect.getBoundsInParent().intersects(circle3.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(z==2){
              circle3.relocate(510, 450);
              z--;
          }
          else{
              circle3.relocate(328,75);
              z++;
          }
           
      }
                } else if (event.getCode() == KeyCode.UP) {
                    rect.setLayoutY(rect.getLayoutY() - 10);
                    for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutY(rect.getLayoutY() + 10);
       }
       else
       {
          lineArrayList.get(i).setStroke(Color.BLACK);  
       }
      }
                    if(rect.getBoundsInParent().intersects(circle1.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(x==2){
              circle1.relocate(440, 465);
              x--;
          }
          else{
              circle1.relocate(328, 200);
              x++;
          }
      }
       if(rect.getBoundsInParent().intersects(circle2.getBoundsInParent())){
          System.out.println("diamond");
           plrScore.setText(Integer.toString(playerScore+=10));
            if(y==2){
              circle2.relocate(250, 167);
              y--;
          }
          else{
              circle2.relocate(90, 450);
              y++;
          }
      }
        if(rect.getBoundsInParent().intersects(circle3.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(z==2){
              circle3.relocate(510, 450);
              z--;
          }
          else{
              circle3.relocate(328,75);
              z++;
          }
           
      }
                } else if (event.getCode() == KeyCode.DOWN) {
                    rect.setLayoutY(rect.getLayoutY() + 10);
                    for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutY(rect.getLayoutY() - 10);
       }
       else
       {
          lineArrayList.get(i).setStroke(Color.BLACK);  
       }
      }
                    if(rect.getBoundsInParent().intersects(circle1.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(x==2){
              circle1.relocate(440, 465);
              x--;
          }
          else{
              circle1.relocate(328, 200);
              x++;
          }
         
      }
       if(rect.getBoundsInParent().intersects(circle2.getBoundsInParent())){
          System.out.println("diamond");
           plrScore.setText(Integer.toString(playerScore+=10));
     if(y==2){
              circle2.relocate(250, 167);
              y--;
          }
          else{
              circle2.relocate(90, 450);
              y++;
          }
      }
        if(rect.getBoundsInParent().intersects(circle3.getBoundsInParent())){
          System.out.println("gold");
          plrScore.setText(Integer.toString(playerScore+=6));
          if(z==2){
              circle3.relocate(510, 450);
              z--;
          }
          else{
              circle3.relocate(328,75);
              z++;
          }
           
      }
        if(rect.getBoundsInParent().intersects(rect2.getBoundsInParent())){
           // window.setScene(sceneLevelTwo);/////////////////////////////////////////new add needs to be removed later
           timeline.stop();
            if(timeSeconds.getValue()>0 && playerScore>=5)
            {
                
                playerScore=0;
                
                JOptionPane.showMessageDialog(null, "YOU WIN");
                 setupGame("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\winning.wav");//activating music
                try {
                    LevelTwo.levelTwoScene(gp, sceneLevelTwo, root,window);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setScene(sceneLevelTwo);
                
            }
            else{
            JOptionPane.showMessageDialog(null, "YOU LOSE");
            rect.setLayoutX(7);
                rect.setLayoutY(2);
                timerStop();
                System.out.println(STARTTIME);
            }
        }
                }
            }
        });
     
          
      
  
} 
     
     public static void timerStop(){
         STARTTIME=50;
         /* timerLabel.textProperty().bind(timeSeconds.asString());//label adding
        timerLabel.setTextFill(Color.BLACK);
        timerLabel.setPadding(new Insets(570,570, 390,390));
        timerLabel.setStyle("-fx-font-size: 1.3em;");*/
        if (timeline != null) {
                    timeline.stop();
                }
        
                timeSeconds.set(STARTTIME);
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(STARTTIME++),
                        new KeyValue(timeSeconds, 0)));
                timeline.playFromStart();
                
     }
     
     }
    
    


