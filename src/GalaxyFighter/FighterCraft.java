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
class FighterCraft extends Line {
    private Ellipse body;
    private Rectangle wingR;
    private Rectangle wingL;
    private Rectangle tail;
    private Line wingTipR;
    private Line wingTipL;
    private int speed = 10;
    private Pane cosmos;
    private PhotonTorpedo[] torpedoes;
    private int maxTorpedoes = 5;
    private int currentTorpedoes;
    private PhotonTorpedo torp;
    
    //Creates ship and torpedoes
    public FighterCraft(Pane cos){
        this.cosmos = cos;
        body = new Ellipse();
        wingR = new Rectangle();
        wingL = new Rectangle();
        tail = new Rectangle();
        wingTipR = new Line();
        wingTipL = new Line();
        torp = new PhotonTorpedo();
        torpedoes = new PhotonTorpedo[maxTorpedoes];
       
        body.setRadiusX(25);
        body.setRadiusY(18);
        body.setFill(Color.GRAY);
        body.setStroke(Color.BLUE);
        body.setCenterX(350);
        body.setCenterY(620);
        
        tail.setFill(Color.GRAY);
        tail.setWidth(16);
        tail.setHeight(25);
        tail.setLayoutX(342);
        tail.setLayoutY(635);
        
        wingL.setFill(Color.GRAY);
        wingL.setHeight(30);
        wingL.setWidth(8);
        wingL.setLayoutX(325);
        wingL.setLayoutY(635);
        
        wingR.setFill(Color.GRAY);
        wingR.setHeight(30);
        wingR.setWidth(8);
        wingR.setLayoutX(368);
        wingR.setLayoutY(635);
        
        wingTipR.setFill(Color.GRAY);
        wingTipR.setEndX(360);
        wingTipR.setEndY(655);
        wingTipR.setStartX(370);
        wingTipR.setStartY(643);
        wingTipR.setStroke(Color.GRAY);
        
        wingTipL.setFill(Color.GRAY);
        wingTipL.setEndX(341);
        wingTipL.setEndY(655);
        wingTipL.setStartX(329);
        wingTipL.setStartY(643);
        wingTipL.setStroke(Color.GRAY);
        
        for(int i = 0; i < torpedoes.length; i++){
            PhotonTorpedo torp = new PhotonTorpedo();
            torp.setVisible(false);
            torpedoes[i] = torp;
            cosmos.getChildren().add(torp);
        }
        
        this.cosmos.getChildren().add(wingTipL);
        this.cosmos.getChildren().add(wingTipR);
        this.cosmos.getChildren().add(wingR);
        this.cosmos.getChildren().add(wingL);
        this.cosmos.getChildren().add(tail);
        this.cosmos.getChildren().add(body);
        
    }
    
    public void firePhotonTorpedo(){
        
            for(int i = 0; i < getTorpedoes().length; i++){
                
                if (getTorpedoes()[i].isVisible() == true && getTorpedoes()[i].getCenterY() < -2){
                    
                    getTorpedoes()[i].setVisible(false);
                }
                
                if (getTorpedoes()[i].isVisible() == false){
                    
                    getTorpedoes()[i].setCenterX(body.getCenterX());
                    getTorpedoes()[i].setCenterY(body.getCenterY() - 20);
                    getTorpedoes()[i].setVisible(true);
                    break;
                }
            }
    }
    
    //Key listener method
    public void moveLeft(){
        
        if (body.getCenterX() > 0){
            
            body.setCenterX(body.getCenterX() - speed);
            tail.setLayoutX(tail.getLayoutX() - speed);
            wingR.setLayoutX(wingR.getLayoutX() - speed);
            wingL.setLayoutX(wingL.getLayoutX() - speed);
            wingTipR.setEndX(wingTipR.getEndX() - speed);
            wingTipL.setEndX(wingTipL.getEndX() - speed);
            wingTipR.setStartX(wingTipR.getStartX() - speed);
            wingTipL.setStartX(wingTipL.getStartX() - speed);
        }
    }
    
    //Key listener method
    public void moveRight(){
        
        if (body.getCenterX() < 700){
            
            body.setCenterX(body.getCenterX() + speed);
            tail.setLayoutX(tail.getLayoutX() + speed);
            wingR.setLayoutX(wingR.getLayoutX() + speed);
            wingL.setLayoutX(wingL.getLayoutX() + speed);
            wingTipR.setEndX(wingTipR.getEndX() + speed);
            wingTipL.setEndX(wingTipL.getEndX() + speed);
            wingTipR.setStartX(wingTipR.getStartX() + speed);
            wingTipL.setStartX(wingTipL.getStartX() + speed);
        }
    }
    
    //starts move method for each torpedo
    public void moveTorpedoes() {
        for (int i = 0; i < getTorpedoes().length; i++){
           if (getTorpedoes()[i].isVisible() == true){
               
                getTorpedoes()[i].move();
           }
        }
    }

    /**
     * @return the torpedoes
     */
    public PhotonTorpedo[] getTorpedoes() {
        return torpedoes;
    }

    void setVisibility(boolean b) {
         body.setVisible(b);
         tail.setVisible(b);
         wingL.setVisible(b);
         wingR.setVisible(b);
         wingTipL.setVisible(b);
         wingTipR.setVisible(b);
    }

   
           
    }


