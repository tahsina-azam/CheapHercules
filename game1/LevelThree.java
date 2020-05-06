/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import static game1.LevelTwo.playerScore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class LevelThree extends GAME1{
    private static int cnt=3;
    private static int x = 2;
    private static int y = 2;
    private static int z = 2;
    private static int k = 2;
    private static int p = 2;
     static int playerScore=0;
     static int labelX=570;
     static int labelY1=390;
     static int labelY2=390;
     static int labelY3=225;
     static int labelY4= 350; 
     private static  Integer STARTTIME3 = 70;
    private static Timeline timeLine3;
    private static Label timerLabel3 = new Label();
    private static ScrollPane scrollPane2 = new ScrollPane();
    private static IntegerProperty timeSeconds3 = new SimpleIntegerProperty(STARTTIME3);
    
     private static Rectangle eneMy1=EnemyClass.getEnemy1();
    private static Rectangle eneMy2=Enemy2.getEnemy2();
    private static Rectangle eneMy3=Level2Enemy3.getEnemy3();
    

                
    public static void levelThreeScene(Group gp,Scene scene,VBox root)throws FileNotFoundException{
        
        
       // adding new------------------------------------->
       final double targetRadius = 20 ;
        final double projectileRadius = 5 ;
          final double targetStartX = 20 ;
        final double targetY = 70 ;
        final double width = 840 ;
        final double height =720;
        Circle target = new Circle(targetStartX, targetY, targetRadius, Color.BLUE);
        TranslateTransition targetMotion = new TranslateTransition(Duration.seconds(2), target);
        targetMotion.setByX(350);
        targetMotion.setAutoReverse(true);
        targetMotion.setCycleCount(Animation.INDEFINITE);
     
        
      Image image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\surface.png")); //path of the image is given here for first scene;

            
            // ScrollPane scrollPane2 = new ScrollPane();
             scrollPane2.setFitToHeight(true);
             scrollPane2.setFitToWidth(true);
             scrollPane2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
             
             timerLabel3.textProperty().bind(timeSeconds3.asString());
        timerLabel3.setTextFill(Color.BLACK);
        timerLabel3.setLayoutX(390);
        timerLabel3.setLayoutY(0);
        timerLabel3.setStyle("-fx-font-size: 1.2em;");
        if (timeLine3 != null) {
                    timeLine3.stop();
                }
                timeSeconds3.set(STARTTIME3);
                timeLine3 = new Timeline();
                timeLine3.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME3+1),
                        new KeyValue(timeSeconds3, 0)));
                timeLine3.playFromStart();
                Label timer=new Label("TIMER:");
                timer.setTextFill(Color.BLACK);//passing the color of the label as the parameter
                timer.setLayoutX(340);
                timer.setLayoutY(0);
                timer.setStyle("-fx-font-size: 1.3em;");
               
             
             Label goal = new Label("GOAL:50");//the parameter is a string which will show the target of the player in the console
        goal.setTextFill(Color.BLACK);//passing the color of the label as the parameter
        goal.setStyle("-fx-font-size: 1.2em;");///newwwwllllyyy added
      goal.setLayoutX(200);
       goal.setLayoutY(0);
        Label score=new Label("SCORE:");//new label
        score.setTextFill(Color.BLACK);//passing col
        score.setStyle("-fx-font-size: 1.2em;");
      score.setLayoutX(270);
      score.setLayoutY(0);
      
         Label plrScore=new Label();//new label object
        plrScore.setTextFill(Color.BLACK);
        plrScore.setText(Integer.toString(playerScore));//setting the score which is a variable and making it string
        plrScore.setStyle("-fx-font-size: 1.2em;");
        plrScore.setLayoutX(320);
        plrScore.setLayoutY(0);
        
            ImageView img_exp=new ImageView(image);
        
        Group marks= new Group();
        marks.getChildren().add(img_exp);
        img_exp.setFitWidth(650); //th
        img_exp.setFitHeight(20);
        marks.getChildren().addAll(goal,score,plrScore,timer,timerLabel3); 
             
              ArrayList<Line> lineArrayList = new ArrayList<Line>();//declaration of a arraylist of line which will form the maze
        lineArrayList.add(new Line(2.0,3.00,838.0,3.0));//passing the coordinates of start and ending point of the line
        lineArrayList.add(new Line(2.0,731.00,838.00,731.00));
        lineArrayList.add(new Line(2.0,731.00,2.0,3.0));
        lineArrayList.add(new Line(838.0,3.0,838.0,731.0));
        lineArrayList.add(new Line(2.0,66.67,242.0,66.67));
        lineArrayList.add(new Line(242.0,66.67,242.0,133.34));
         lineArrayList.add(new Line(60.0,133.34,182.0,133.34));
          lineArrayList.add(new Line(60.0,200.01,60.0,533.34));
           lineArrayList.add(new Line(60.0,366.67,180.00,366.67));
           lineArrayList.add(new Line(121.0,133.34,121.0,266.68));//
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
           lineArrayList.add(new Line(540.00,66.67,540.00,590.00)); //
            lineArrayList.add(new Line(540.00,333.35,420,333.35)); 
             lineArrayList.add(new Line(362.00,266.64,362.00,433.34)); 
              lineArrayList.add(new Line(362.00,433.34,480.00,433.34)); 
               lineArrayList.add(new Line(480.00,433.34,480.00,500.00)); 
                lineArrayList.add(new Line(480.00,500.00,300.00,500.00)); 
                 lineArrayList.add(new Line(300.00,500.00,300.00,366.63)); 
                  lineArrayList.add(new Line(300.00,366.63,240.00,366.63)); 
                   lineArrayList.add(new Line(240.00,366.63,240.00,300.00)); 
                   lineArrayList.add(new Line(120.0,598.00,60.0,598.0));//32
                    lineArrayList.add(new Line(60.0,667.0,180.0,667.0));//33
         lineArrayList.add(new Line(180.0,667.00,180.0,561.0));//34
          lineArrayList.add(new Line(180.0,561.0,240.00,561.0));//35
          lineArrayList.add(new Line(240.00,561.0,240.00,667.0));//36
          lineArrayList.add(new Line(240.00,667.0,300.0,667.0));//37
          lineArrayList.add(new Line(60.0,667.0,60.0,731.00));//38
          lineArrayList.add(new Line(540.00,590.00,420.00,590.00));//39
          lineArrayList.add(new Line(600.0,266.64,600.0,660.0));//40
          lineArrayList.add(new Line(420.0,660.0,600.0,660.0));//41
          lineArrayList.add(new Line(600.0,266.64,720.0,266.64));//42
          lineArrayList.add(new Line(720.0,266.64,720,731.00));//43
          lineArrayList.add(new Line(660.0,333.35,660.0,731.0));//44
          lineArrayList.add(new Line(540.0,66.67,660.0,66.67));//45
          lineArrayList.add(new Line(660.0,133.34,660.0,3.0));//46
          lineArrayList.add(new Line(660.0,133.34,720.0,133.34));//47
          lineArrayList.add(new Line(720.0,133.34,720.0,66.67));//48
          lineArrayList.add(new Line(780.0,66.67,780.0,731.0));//49
          lineArrayList.add(new Line(660.0,133.34,600.0,133.34));//50
            lineArrayList.add(new Line(600.0,133.34,600.0,200.0));//50
            lineArrayList.add(new Line(780.0,200.0,700.00,200.0));//50
          for(int i=0;i<52;i++){
                 lineArrayList.get(i).setStrokeWidth(2);
             }
             
            ImageView backgroundImg = new ImageView(image);
            Rectangle rect=new Rectangle(10,10,40,40);
            FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\shredder.png");//adding image to the character
        Image img3 = new Image(input);//passing image object as parameter
        ImagePattern image_pattern = new ImagePattern(img3, 10, 10, 1, 1, true);//passing image object,coordinates,ratio as parameter
        
         FileInputStream inputBullet = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\ScrollingImage\\src\\bomb.png");//adding character to the bullet
        Image imgBullet = new Image(inputBullet);//passing image object as parameter
      //  ImagePattern imgptrn_bullet = new ImagePattern(imgBullet, projectileRadius, 10, 1, 1, true);//passing image object,coordinates,ratio as parameter
                 
            rect.setFill(image_pattern);//filling the character with image pattern
              backgroundImg.setFitHeight(734);
            backgroundImg.setFitWidth(840); //th
            gp.getChildren().add(backgroundImg);
            gp.getChildren().add(rect);
            gp.getChildren().addAll(lineArrayList);
          //  gp.getChildren().addAll(sb1,sb2);
            //adding new---------------------------------------------------------------------------------------------------------------->
             Rotate rectRotation=new Rotate(0,rect.getLayoutX()+30,rect.getLayoutY()+30);
            rect.getTransforms().add(rectRotation);
       
        scrollPane2.setContent(gp);
       //// scrollPane2.setHbarPolicy(ScrollBarPolicy.NEVER);
       // scrollPane2.setVbarPolicy(ScrollBarPolicy.ALWAYS);
       
     
        
       
        //scrollPane.
        
        root.getChildren().addAll(scrollPane2,marks);
        //scene.setRoot(root);
         EnemyClass.enemyChar(rect,gp,plrScore,3);//calling enemy class---------------------------------------------->
        Enemy2.enemyChar(rect,gp,plrScore,3);//calling another--------------------------------------------------------->
        Level2Enemy3.enemyChar(rect, gp, plrScore,3);
        Rectangle rect2=HomeChar.homeChar(rect, gp);
        
        Rectangle rectShield=ProtectiveSuit.suitCreation(gp);//-------------------------------------------------------------------->sheild
        Rectangle shootingSkull=ShootingSkull.skullCreation(gp, rect);//------------------------------------------------------------------------>adding pistol
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
        circle2.setCenterX(200.0f);
circle2.setCenterY(635.0f);
circle2.setRadius(10.0f);
circle2.setFill(image_Coind);
Circle circle3=new Circle();
circle3.setCenterX(250.0f);
circle3.setCenterY(250.0f);
circle3.setRadius(10.0f);
circle3.setFill(image_Coin);
            gp.getChildren().addAll(circle1,circle2,circle3);
            
          
        
            scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT) {
                    rect.setLayoutX(rect.getLayoutX() + 10);
                    scrollPane2.setHvalue(scrollPane2.getHvalue()+0.02);
                     
      for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){//checking collision
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);//if rect touches the lines the line would be white
           rect.setLayoutX(rect.getLayoutX() - 10);//if the rect touches the lines it will stay at its place
            scrollPane2.setHvalue(scrollPane2.getHvalue()-0.02);//scrollpane will stay at its place
             
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
              circle1.relocate(634, 695);//positions where the coins would appear
              x++;
          }
      }
       if(rect.getBoundsInParent().intersects(circle2.getBoundsInParent())){
          System.out.println("diamond");
           plrScore.setText(Integer.toString(playerScore+=10));
           if(y==2){
              circle2.relocate(574, 627);
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
       
       if(rect.getBoundsInParent().intersects(rectShield.getBoundsInParent())){
           
          //gp.getChildren().remove(rectShield);
           if(k==2){
              rectShield.setLayoutX(rectShield.getLayoutX()+60);
              rectShield.setLayoutY(rectShield.getLayoutY()-66.67);
              k--;
          }
          else{
              rectShield.setLayoutX(rectShield.getLayoutX()-60);
              rectShield.setLayoutY(rectShield.getLayoutY()+66.67);
              k++;
          }
          EnemyClass.startTimer();
          Enemy2.startTimer();
          Level2Enemy3.startTimer();
          
        }
      
       
                } else if (event.getCode() == KeyCode.LEFT) {
                    rect.setLayoutX(rect.getLayoutX() - 10);
                    scrollPane2.setHvalue(scrollPane2.getHvalue()-0.02);
                   
                     
                    for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutX(rect.getLayoutX() + 10);
           scrollPane2.setHvalue(scrollPane2.getHvalue()+0.02);
           
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
              circle1.relocate(634, 695);
              x++;
          }
                      
      }
       if(rect.getBoundsInParent().intersects(circle2.getBoundsInParent())){
          System.out.println("diamond");
           plrScore.setText(Integer.toString(playerScore+=10));
            if(y==2){
              circle2.relocate(574, 627);
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
        if(rect.getBoundsInParent().intersects(rectShield.getBoundsInParent())){
           
          //gp.getChildren().remove(rectShield);
           if(k==2){
              rectShield.setLayoutX(rectShield.getLayoutX()+60);
              rectShield.setLayoutY(rectShield.getLayoutY()-66.67);
              k--;
          }
          else{
              rectShield.setLayoutX(rectShield.getLayoutX()-60);
              rectShield.setLayoutY(rectShield.getLayoutY()+66.67);
              k++;
          }
          EnemyClass.startTimer();
          Enemy2.startTimer();
          Level2Enemy3.startTimer();
        }
                } else if (event.getCode() == KeyCode.UP) {
                    rect.setLayoutY(rect.getLayoutY() - 10);
                     scrollPane2.setVvalue(scrollPane2.getVvalue()-0.02);
                    for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutY(rect.getLayoutY() + 10);
            scrollPane2.setVvalue(scrollPane2.getVvalue()+0.02);
           
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
              circle1.relocate(634, 695);
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
              circle2.relocate(574, 672);
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
        if(rect.getBoundsInParent().intersects(rectShield.getBoundsInParent())){
           
         // gp.getChildren().remove(rectShield);
         if(k==2){
              rectShield.setLayoutX(rectShield.getLayoutX()+60);
              rectShield.setLayoutY(rectShield.getLayoutY()-66.67);
              k--;
          }
          else{
              rectShield.setLayoutX(rectShield.getLayoutX()-60);
              rectShield.setLayoutY(rectShield.getLayoutY()+66.67);
              k++;
          }
          EnemyClass.startTimer();
          Enemy2.startTimer();
          Level2Enemy3.startTimer();
        }
                } else if (event.getCode() == KeyCode.DOWN) {
                    rect.setLayoutY(rect.getLayoutY() + 10);
                    scrollPane2.setVvalue(scrollPane2.getVvalue()+0.02);
                    for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutY(rect.getLayoutY() - 10);
           scrollPane2.setVvalue(scrollPane2.getVvalue()-0.02);
           
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
              circle1.relocate(634, 695);
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
              circle2.relocate(574, 647);
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
           
            if(playerScore>=5 && timeSeconds3.getValue()>0)
            {
                
                JOptionPane.showMessageDialog(null, "YOU WIN");
                
            }
            else
            JOptionPane.showMessageDialog(null, "YOU LOSE");
            timerStop();
                  rect.setLayoutX(7);
                rect.setLayoutY(2);
                scrollPane2.setHvalue(0);
                scrollPane2.setVvalue(0);
               playerScore=0;
                 if(k==2){
              rectShield.setLayoutX(rectShield.getLayoutX()+60);
              rectShield.setLayoutY(rectShield.getLayoutY()-66.67);
              k--;
          }
          else{
              rectShield.setLayoutX(rectShield.getLayoutX()-60);
              rectShield.setLayoutY(rectShield.getLayoutY()+66.67);
              k++;
          }       
                
        }
        if(rect.getBoundsInParent().intersects(rectShield.getBoundsInParent())){
           
         // gp.getChildren().remove(rectShield);
          if(k==2){
              rectShield.setLayoutX(rectShield.getLayoutX()+60);
              rectShield.setLayoutY(rectShield.getLayoutY()-66.67);
              k--;
          }
          else{
              rectShield.setLayoutX(rectShield.getLayoutX()-60);
              rectShield.setLayoutY(rectShield.getLayoutY()+66.67);
              k++;
          }
          EnemyClass.startTimer();
          Enemy2.startTimer();
          Level2Enemy3.startTimer();
        }
        
        
                }
                
                 else if(event.getCode() == KeyCode.SHIFT){
                    if(rectRotation.getAngle() - 90>=0)
                rectRotation.setAngle(rectRotation.getAngle() + 90);
                else if(rectRotation.getAngle() + 90<=360){
                    rectRotation.setAngle(rectRotation.getAngle()-90);
                    System.out.println("Angle"+rectRotation.getAngle());
                   
                    
                }
                     if(cnt==0){
                       
                        cnt=1;
                         System.out.println(cnt);
                    }
                     else if(cnt==1){
                       
                        cnt=2;
                        System.out.println(cnt);
                    }
                     else if(cnt==2){
                       
                        cnt=3;
                        System.out.println(cnt);
                    }
                   else if(cnt==3){
                      
                        cnt=0;
                        System.out.println(cnt);
                    }
                }
                if (event.getCode() == KeyCode.SPACE) {

                Point2D weaponEnd = rect.localToParent(rect.getLayoutY(),rect.getLayoutX());
                
                
        
        ImagePattern imgptrn_bullet = new ImagePattern(imgBullet,rect.getLayoutX()+30 ,rect.getLayoutY()+30 , 1, 1, true);//passing image object,coordinates,ratio as parameter

                Circle projectile = new Circle(rect.getLayoutX()+30, rect.getLayoutY()+30, projectileRadius*2);
               
                projectile.setFill(imgptrn_bullet);

                TranslateTransition shot = new TranslateTransition(Duration.seconds(1), projectile);
                if(cnt==1)
                {
                    shot.setByX(Math.tan(Math.toRadians(rectRotation.getAngle())) * (-height));
               shot.setByY(-rect.getLayoutY());
                }
                else if(cnt==3)
                {
                   shot.setByX(Math.tan(Math.toRadians(rectRotation.getAngle())) * (height));
               shot.setByY(height); 
                }
                else if(cnt==0){
               shot.setByX(width);
                }
                else{
               shot.setByX(-rect.getLayoutX());
                }
                
                shot.setOnFinished(e-> gp.getChildren().remove(projectile));

                gp.getChildren().add(projectile);
                shot.play();
                  projectile.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
        @Override
        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
            if(shootingSkull.getBoundsInParent().intersects(newValue)){
               // System.out.println("Collide ============= Collide");
                  gp.getChildren().remove(projectile);
                  shot.stop();
                System.out.println("hit");
                Random rand=new Random();
        int upperBound=3;
         int intRandom=rand.nextInt(upperBound);
         gp.getChildren().remove(shootingSkull);
         if(intRandom==0){
             shootingSkull.setLayoutX(340);
                shootingSkull.setLayoutY(225);
                gp.getChildren().add(shootingSkull);
                EnemyClass.getTransition();
         }
         else if(intRandom==1){
           shootingSkull.setLayoutX(400);
                shootingSkull.setLayoutY(15);
                gp.getChildren().add(shootingSkull);
                Enemy2.getTransition();  
         }
         else if(intRandom==2){
           shootingSkull.setLayoutX(530);
                shootingSkull.setLayoutY(60);
                gp.getChildren().add(shootingSkull);
                Level2Enemy3.getTransition();    
         }
                
                       
            }
        }

                    

         
    });
               
                   
            }
            }
        });
             
        
    }
     
   
  public static void timerStop(){
         STARTTIME3=70;
         /* timerLabel.textProperty().bind(timeSeconds.asString());//label adding
        timerLabel.setTextFill(Color.BLACK);
        timerLabel.setPadding(new Insets(570,570, 390,390));
        timerLabel.setStyle("-fx-font-size: 1.3em;");*/
        if (timeLine3 != null) {
                    timeLine3.stop();
                }
        
                timeSeconds3.set(STARTTIME3);
                timeLine3 = new Timeline();
                timeLine3.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(STARTTIME3++),
                        new KeyValue(timeSeconds3, 0)));
                timeLine3.playFromStart();
                
     }             
     
                
     public static void autoScroll2(){
                scrollPane2.setHvalue(0);
                scrollPane2.setVvalue(0);  
                playerScore=0;
     }
    
}
