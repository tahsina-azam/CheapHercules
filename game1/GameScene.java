package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class GameScene extends GAME1{
    private static int x = 2;
    private static int y = 2;
    private static int z = 2;
    private static int playerScore=0;
    private ArrayList<Line> lineArrayList;
     public static void gameScene(Group layout, Scene scn) throws FileNotFoundException{
            //image2
       Image image1 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\surface.png"));//image2 file path is given here.
        ImageView img = new ImageView(image1);

        //adding pictures to rectangle below:
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\shredder.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 15, 15, 1, 1, true);
        Rectangle rect = new Rectangle(15, 15, 40, 40);
        rect.setFill(image_pattern);
        
 FileInputStream inputCoin = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\download.jpg");
        Image imgCoin = new Image(inputCoin);
        ImagePattern image_Coin = new ImagePattern(imgCoin, 330, 350, 1,1 , true);        
       Circle circle1 = new Circle(); 
        circle1.setCenterX(330.0f);
circle1.setCenterY(340.0f);
circle1.setRadius(10.0f);
circle1.setFill(image_Coin);


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
        layout.getChildren().add(img);
        layout.getChildren().add(rect);
        ArrayList<Line> lineArrayList = new ArrayList<Line>();
        lineArrayList.add(new Line(2.0,3.00,598.0,3.0));
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
                   
        
        layout.getChildren().addAll(lineArrayList);
        layout.getChildren().add(circle2);
      layout.getChildren().add(circle1);
       layout.getChildren().add(circle3);
       
       Label goal = new Label("GOAL:50");
        goal.setTextFill(Color.BLUE);
       goal.setAlignment(Pos.BOTTOM_CENTER);
        goal.setPadding(new Insets(570,570, 225, 225));
        layout.getChildren().add(goal);
        Label score=new Label("SCORE:");
        score.setTextFill(Color.DARKBLUE);
        score.setAlignment(Pos.BOTTOM_CENTER);
        score.setPadding(new Insets(570,570, 350,350));
        layout.getChildren().add(score);
        
         Label plrScore=new Label();
        plrScore.setTextFill(Color.DARKBLUE);
        plrScore.setAlignment(Pos.BOTTOM_CENTER);
        plrScore.setText(Integer.toString(playerScore));
        plrScore.setPadding(new Insets(570,570,390,390));
        layout.getChildren().add(plrScore);
        
        EnemyClass.enemyChar(rect,layout);//calling enemy class
        Enemy2.enemyChar(rect, layout);//calling another
       Rectangle rect2= BossFarmer.BossChar(rect, layout);
        
        scn.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT) {
                    rect.setLayoutX(rect.getLayoutX() + 10);
      for(int i=0;i<lineArrayList.size();i++){
       if(rect.getBoundsInParent().intersects(lineArrayList.get(i).getBoundsInParent())){
    
           lineArrayList.get(i).setStroke(Color.ANTIQUEWHITE);
           rect.setLayoutX(rect.getLayoutX() - 10);
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
              circle1.relocate(510, 450);
              z--;
          }
          else{
              circle1.relocate(328,75);
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
              circle1.relocate(510, 450);
              z--;
          }
          else{
              circle1.relocate(328,75);
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
              circle1.relocate(510, 450);
              z--;
          }
          else{
              circle1.relocate(328,75);
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
              circle1.relocate(510, 450);
              z--;
          }
          else{
              circle1.relocate(328,75);
              z++;
          }
           
      }
        if(rect.getBoundsInParent().intersects(rect2.getBoundsInParent())){
            if(playerScore>=50)
            JOptionPane.showMessageDialog(null, "YOU LOSE");
            else
            JOptionPane.showMessageDialog(null, "YOU WIN");
        }
                }
            }
        });
      
  
} 
     
     
     
     }
    
    


