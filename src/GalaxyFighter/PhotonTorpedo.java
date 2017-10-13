/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author owner
 */
class PhotonTorpedo extends Circle implements Movable{
    private int direction;
    private int height;
    private int speed = 1200;
    private long startTime = 0;
    private Color torpColor = Color.ORANGE;
    
    
    public PhotonTorpedo(){
        setRadius(4);
        setFill(torpColor);
        
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int spd) {
        this.speed = spd;
    }
    
    

    @Override
    public void move() {
           
            this.setCenterY(this.getCenterY() - 5);
    }

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    
    
}
