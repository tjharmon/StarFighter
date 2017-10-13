/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import GalaxyFighter.BattlePane.GameTimer;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author owner
 */
class StarField implements Movable{
    private Circle[] stars;
    private Pane cosmos;
    private Color[] starColors;
    private int numStars;
    private int speed = 15000;
    private double starPath;
    
    public StarField(){}
    
    public StarField(int numStr, Pane cos, Color[] colors){
        
        this.cosmos = cos;
        this.stars = new Circle[numStr];
        starColors = colors;
        setNumStars(numStr);
    }
    
    
    //adds stars with randomized sizes, locations, and color to cosmos, calls move method
    public void createStars(){
        
        Random rand = new Random();
        int low = 1;
        int high = 3;
        int xMax = 700;
        int yMax = 800;
        int yMin = 4;
        int cMax = starColors.length;
        
        for(int j = 0; j < stars.length; j++){
            Circle star = new Circle();
            star.setFill(starColors[rand.nextInt(cMax)]);
            star.setRadius(rand.nextInt(high - low) + low);
            star.setCenterX(rand.nextInt(xMax));
            starPath = star.getCenterX();
            star.setCenterY(rand.nextInt(yMax - yMin) + yMin);
            stars[j] = star;
            
            getCosmos().getChildren().add(stars[j]);
        }
        move();
        
        
    }
    
    //moves stars at random speeds using path transition animation
    @Override
    public void move(){
        
        Random rando = new Random();
        int min = 25;
        int max = 100;
        
        for(int i = 0; i < stars.length; i++){
        
            Line line = new Line(stars[i].getCenterX(), 0, stars[i].getCenterX(), 800);
            PathTransition path = new PathTransition();
            path.setNode(stars[i]);
            path.setPath(line);
            path.setDuration(Duration.millis(120000));
            path.setCycleCount(Timeline.INDEFINITE);
            path.setRate(rando.nextInt(max - min) + min);
            path.play();
       
        }
        
    }

    /**
     * @return the numStars
     */
    public int getNumStars() {
        return numStars;
    }

    /**
     * @param numStars the numStars to set
     */
    public void setNumStars(int numStars) {
        this.numStars = numStars;
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
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the cosmos
     */
    public Pane getCosmos() {
        return cosmos;
    }

    /**
     * @param cosmos the cosmos to set
     */
    public void setCosmos(Pane cosmos) {
        this.cosmos = cosmos;
    }
}
