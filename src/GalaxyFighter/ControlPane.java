/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;



/**
 *
 * @author owner
 */
public class ControlPane extends HBox {
    
    private Button btnStart;
    private Button btnPause;
    private Button btnExit;
    private BattlePane timer;
    
    public ControlPane(BattlePane btPane){
        MyHandler listen = new MyHandler();
        setPadding(new Insets(15,75,15,222));
        setSpacing(50);
        timer = btPane;
        btnStart = new Button();
        btnPause = new Button();
        btnExit = new Button();
        btnExit.setText("Exit");
        btnPause.setText("Pause");
        btnStart.setText("Start");
        btnExit.setOnAction(listen);
        btnPause.setOnAction(listen);
        btnStart.setOnAction(listen);
        btnExit.setStyle("-fx-background-color: black; -fx-border-color: orange;");
        btnPause.setStyle("-fx-background-color: black; -fx-border-color: orange;");
        btnStart.setStyle("-fx-background-color: black; -fx-border-color: orange;");
        btnExit.setTextFill(Color.ORANGE);
        btnPause.setTextFill(Color.ORANGE);
        btnStart.setTextFill(Color.ORANGE);
  
        getChildren().add(btnStart);
        getChildren().add(btnPause);
        getChildren().add(btnExit);
        setStyle("-fx-background-color: blue");
        
    }
    public class MyHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle( ActionEvent e)
        {
            Button b = (Button) e.getSource();
            if (b.getText().equals("Exit"))
            {
               System.exit(-1);
            }
                
            if(b.getText().equals("Start"))
            {
               timer.startTimer();
               //cannot click start more than once without pausing
               btnStart.setDisable(true);
               
            }
            
            if(b.getText().equals("Pause"))
            {
                timer.stopTimer();
                //enables start button again
                btnStart.setDisable(false);
            }
            
            
        }
    }
}
