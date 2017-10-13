/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GalaxyFighter;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author owner
 */
public class GameConsole extends BorderPane {
    private StatusPane statusPane;
    private ControlPane controlPane;
    private BattlePane battlePane;
    
    //Create panes and add them to game console
    public GameConsole(){
        battlePane = new BattlePane();
        statusPane = new StatusPane();
        controlPane = new ControlPane(battlePane);
        
        setCenter(getBattlePane());
        setTop(getStatusPane());
        setBottom(getControlPane());
        
    }

    /**
     * @return the statusPane
     */
    public StatusPane getStatusPane() {
        
        return statusPane;
    }

    /**
     * @param statusPane the statusPane to set
     */
    public void setStatusPane(StatusPane statusPane) {
        this.statusPane = statusPane;
    }

    /**
     * @return the controlPane
     */
    public ControlPane getControlPane() {
        return controlPane;
    }

    /**
     * @param controlPane the controlPane to set
     */
    public void setControlPane(ControlPane controlPane) {
        this.controlPane = controlPane;
    }

    /**
     * @return the battlePane
     */
    public BattlePane getBattlePane() {
        return battlePane;
    }

    /**
     * @param battlePane the battlePane to set
     */
    public void setBattlePane(BattlePane battlePane) {
        this.battlePane = battlePane;
    }
    
}
