/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author owner
 */
public class StatusPane extends HBox{
    private int score;
    private Label lblScore;
    private int level;
    private Label lblLevel;
    private int lives;
    private Label lblLives;
    
    //adds labels to pane
    public StatusPane() {
        score = 0;
        level = 0;
        lives = 0;
        setPadding(new Insets(15,75,15,220));
        lblLevel = new Label();
        lblScore = new Label();
        lblLives = new Label();
        setSpacing(50);
        setStyle("-fx-background-color: blue");
        getChildren().add(getLblLevel());
        getChildren().add(getLblScore());
        getChildren().add(getLblLives());
        
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the lblScore
     */
    public Label getLblScore() {
        lblScore.setTextFill(Color.ORANGE);
        lblScore.setStyle("-fx-background-color: black; -fx-border-color: orange;");
        lblScore.setText("Score: " + getScore());
        return lblScore;
    }

    /**
     * @param lblScore the lblScore to set
     */
    public void setLblScore(Label lblScore) {
        this.lblScore = lblScore;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the lblLevel
     */
    public Label getLblLevel() {
        lblLevel.setTextFill(Color.ORANGE);
        lblLevel.setStyle("-fx-background-color: black; -fx-border-color: orange;");
        lblLevel.setText("Level: " + getLevel());
        return lblLevel;
    }

    /**
     * @param lblLevel the lblLevel to set
     */
    public void setLblLevel(Label lblLevel) {
        
        this.lblLevel = lblLevel;
    }

    /**
     * @return the lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * @return the lblLives
     */
    public Label getLblLives() {
        lblLives.setTextFill(Color.ORANGE);
        lblLives.setStyle("-fx-background-color: black; -fx-border-color: orange;");
        lblLives.setText("Lives: " + getLives());
        return lblLives;
    }

    /**
     * @param lblLives the lblLives to set
     */
    public void setLblLives(Label lblLives) {
        
        this.lblLives = lblLives;
    }
    
}
