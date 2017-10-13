/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author owner
 */
public class AlienNation {
    private AlienFighter[][] alienFighters;
    private Pane cosmos;
    private boolean movingRight;
    
    public AlienNation(Pane cos){
        cosmos = cos;
        alienFighters = new AlienFighter[3][10];
        movingRight = true;
        createAlienNation();
        
    }
    
    //Alien creation in formation
    public void createAlienNation(){
        
        double yPos = 0;
        for(int i = 0; i < 3; i ++){
            yPos += 35;
            double xPos = 25;
            for(int j = 0; j < 10; j++){
               
               AlienFighter alien = new AlienFighter(cosmos, xPos, yPos, this);
               alienFighters[i][j] = alien;
               xPos += 70;
            }
        }
    }
    
    public Pane getCosmos(){
        return cosmos;
    }
    
    public AlienFighter[][] getAlienFighters(){
        return alienFighters;
    }
            
    //Start move method for each alien
    void moveNation() {
        boolean movingRtTemp = movingRight; 
        for (int i = 0; i < alienFighters.length; i++){
            for (int j = 0; j < alienFighters[i].length; j++){
                alienFighters[i][j].setMovingRight(movingRtTemp);
                alienFighters[i][j].move();
            }
        }
    }

    /**
     * @return the movingRight
     */
    public boolean isMovingRight() {
        return movingRight;
    }

    /**
     * @param movingRight the movingRight to set
     */
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    //used for start/pause methods
    void setVisible(boolean b) {
        for (int i = 0; i < alienFighters.length; i++){
            for (int j = 0; j < alienFighters[i].length; j++){
                alienFighters[i][j].setVisible(b);
            }
        }
    }
    
    
    
}
