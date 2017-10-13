/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author owner
 */
class AlienFighter implements Movable{
    private Rectangle body;
    private Ellipse tip;
    private Line left1;
    private Line left2;
    private Line right1;
    private Line right2;
    private Rectangle wingR;
    private Rectangle wingL;
    private Line bar;
    private int speed;
    private int mode;
    private boolean isAlive;
    private Pane cosmos;
    private AlienNation alienNation;
    private boolean movingRight;
    
    public AlienFighter(Pane cos, double x, double y, AlienNation nation){
        cosmos = cos;
        alienNation = nation;
        isAlive = true;
        movingRight = true;
        body = new Rectangle();
        tip = new Ellipse();
        left1 = new Line();
        left2 = new Line();
        right1 = new Line();
        right2 = new Line();
        wingR = new Rectangle();
        wingL = new Rectangle();
        
        body.setWidth(10);
        body.setHeight(20);
        body.setFill(Color.GREEN);
        body.setLayoutX(x);
        body.setLayoutY(y);
        
        tip.setRadiusX(5);
        tip.setRadiusY(12.5);
        tip.setFill(Color.GREEN);
        tip.setCenterX(body.getLayoutX() + 5);
        tip.setCenterY(body.getLayoutY() + 18);
        
        left1.setStartX(body.getLayoutX());
        left1.setStartY(body.getLayoutY() + 1);
        left1.setEndX(body.getLayoutX() - 10);
        left1.setEndY(body.getLayoutY() + 1);
        left1.setStroke(Color.YELLOW);
        
        left2.setStartX(body.getLayoutX());
        left2.setStartY(body.getLayoutY() + 1);
        left2.setEndX(body.getLayoutX() - 10);
        left2.setEndY(body.getLayoutY() + 10);
        left2.setStroke(Color.YELLOW);
        
        right1.setStartX(body.getLayoutX() + 10);
        right1.setStartY(body.getLayoutY() + 1);
        right1.setEndX(body.getLayoutX() + 20);
        right1.setEndY(body.getLayoutY() + 1);
        right1.setStroke(Color.YELLOW);
        
        right2.setStartX(body.getLayoutX() + 10);
        right2.setStartY(body.getLayoutY() + 1);
        right2.setEndX(body.getLayoutX() + 20);
        right2.setEndY(body.getLayoutY() + 10);
        right2.setStroke(Color.YELLOW);
        
        wingL.setWidth(3);
        wingL.setHeight(15);
        wingL.setFill(Color.GREEN);
        wingL.setLayoutX(left1.getEndX() - 3);
        wingL.setLayoutY(left1.getEndY() - 1);
        
        wingR.setWidth(3);
        wingR.setHeight(15);
        wingR.setFill(Color.GREEN);
        wingR.setLayoutX(right1.getEndX());
        wingR.setLayoutY(right1.getEndY() - 1);
        
        cosmos.getChildren().add(tip);
        cosmos.getChildren().add(body);
        cosmos.getChildren().add(left1);
        cosmos.getChildren().add(left2);
        cosmos.getChildren().add(right1);
        cosmos.getChildren().add(right2);
        cosmos.getChildren().add(wingR);
        cosmos.getChildren().add(wingL);
        //move();
    }
    
    public double getCenterBodyX(){
        return (body.getLayoutX() + 5);
    }
    
    public double getCenterBodyY(){
        return body.getLayoutY() + 10;
    }
    
    //Move method that tests boundries
    @Override
    public void move(){
        
        if (movingRight){
            
            body.setLayoutX(body.getLayoutX() + 2);
            body.setLayoutY(body.getLayoutY());
                
            if (body.getLayoutX() > 700 && isAlive){
                alienNation.setMovingRight(false);   
            }
        }
        // If Moving Left
        if(!movingRight){
            
            body.setLayoutX(body.getLayoutX() - 2);
            body.setLayoutY(body.getLayoutY());
             
            if (body.getLayoutX() < 0 && isAlive){
                
                alienNation.setMovingRight(true);
            }
        }
        
        tip.setCenterX(body.getLayoutX() + 5);
        tip.setCenterY(body.getLayoutY() + 18);
        
        left1.setStartX(body.getLayoutX());
        left1.setStartY(body.getLayoutY() + 1);
        left1.setEndX(body.getLayoutX() - 10);
        left1.setEndY(body.getLayoutY() + 1);
        
        left2.setStartX(body.getLayoutX());
        left2.setStartY(body.getLayoutY() + 1);
        left2.setEndX(body.getLayoutX() - 10);
        left2.setEndY(body.getLayoutY() + 10);
        
        right1.setStartX(body.getLayoutX() + 10);
        right1.setStartY(body.getLayoutY() + 1);
        right1.setEndX(body.getLayoutX() + 20);
        right1.setEndY(body.getLayoutY() + 1);
        
        right2.setStartX(body.getLayoutX() + 10);
        right2.setStartY(body.getLayoutY() + 1);
        right2.setEndX(body.getLayoutX() + 20);
        right2.setEndY(body.getLayoutY() + 10);
        
        wingL.setLayoutX(left1.getEndX() - 3);
        wingL.setLayoutY(left1.getEndY() - 1);
        
        wingR.setLayoutX(right1.getEndX());
        wingR.setLayoutY(right1.getEndY() - 1);
    }

    //Destorys aliens that are hit
    void setIsAlive(boolean alive) {
        isAlive = alive;
        if(!alive){
            //set everything invisible
            body.setVisible(false);
            tip.setVisible(false);
            left1.setVisible(false);
            left2.setVisible(false);
            right1.setVisible(false);
            right2.setVisible(false);
            wingL.setVisible(false);
            wingR.setVisible(false);
            
        }
            
    }

    boolean getIsAlive() {
        return isAlive;
    }

    //Used for start/pause methods
    void setVisible(boolean b) {
        if (isAlive == true){
            body.setVisible(b);
            tip.setVisible(b);
            left1.setVisible(b);
            left2.setVisible(b);
            right1.setVisible(b);
            right2.setVisible(b);
            wingL.setVisible(b);
            wingR.setVisible(b);
        }
    }

    public void setMovingRight(boolean movingRtTemp) {
        movingRight = movingRtTemp;
    }
    
}
