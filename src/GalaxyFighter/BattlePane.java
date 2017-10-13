/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author owner
 */
public class BattlePane extends Pane{
    private GameTimer timer;
    private FighterCraft fighterCraft;
    private StarField starField;
    private Color[] starColors = {Color.WHITE, Color.WHITE, Color.WHITE, 
                            Color.WHITE, Color.WHITE, Color.WHITE, Color.RED};
    private AlienNation alienNation;
    
    public BattlePane(){
        //Create objects and pass variables to each constructor
        timer = new GameTimer();
        starField = new StarField(100, this, starColors);
        fighterCraft = new FighterCraft(this);
        fighterCraft.setVisibility(false);
        alienNation = new AlienNation(this);
        alienNation.setVisible(false);
        
        starField.createStars();
        setStyle("-fx-background-color: black"); 
    }
    
    //Starts game
    public void startTimer(){
        
        timer.start(); 
        fighterCraft.setVisibility(true);
        alienNation.setVisible(true);
    }
    
    //pauses game
    public void stopTimer(){
        timer.stop();
    }
    
    public FighterCraft getFighterCraft(){
        return this.fighterCraft;
    }
    
    //moves torpedoes and aliens, checks for torpedo hits
    public class GameTimer extends AnimationTimer{
         
        long previous = 0;
        long previous2 = 0;
        @Override
        public void handle(long nano) {
            if (nano - previous > 1000000){
                fighterCraft.moveTorpedoes();
                previous = nano;
                checkCollision();
            }
            if (nano - previous2 > 100000000){
                alienNation.moveNation();
                previous = nano; 
            }
        }
        
        public void checkCollision(){
            AlienFighter[][] nation = alienNation.getAlienFighters();
            PhotonTorpedo[] torps = fighterCraft.getTorpedoes();
            
            for(int i = 0; i < nation.length; i++){
                for(int j = 0;  j < nation[i].length; j++){
                    for (int k = 0; k < torps.length; k++){
                        if (torps[k].isVisible() && nation[i][j].getIsAlive()
                            &&Math.abs(torps[k].getCenterX() - nation[i][j].getCenterBodyX()) < 20 
                            && Math.abs(torps[k].getCenterY() - nation[i][j].getCenterBodyY()) < 30){
                            torps[k].setVisible(false);
                            nation[i][j].setIsAlive(false);
                        }
                    }
                }
            }
        }
        
    }
    
    
}
