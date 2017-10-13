/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author owner
 */
public class GalaxyFighterRun extends Application{

    @Override
    public void start(Stage primaryStage){
      
        
        //GameConsole is borderpane with all other panes inside of it
        GameConsole gmCon = new GameConsole();
        Scene scene = new Scene(gmCon, 700, 800);
        
        //Key listner for onscreen action
        scene.setOnKeyPressed(keyEvent -> {
            
            switch(keyEvent.getCode()){
                case LEFT:
                gmCon.getBattlePane().getFighterCraft().moveLeft();
                break;
                case RIGHT:
                gmCon.getBattlePane().getFighterCraft().moveRight();
                break;
                case UP:
                gmCon.getBattlePane().getFighterCraft().firePhotonTorpedo();
                break;
                default: 
            }
            
        });
        
        //locked hieght and width
        primaryStage.setMaxWidth(700);
        primaryStage.setMaxHeight(800);
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(800);
        primaryStage.setTitle("Galaxy Fighter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
