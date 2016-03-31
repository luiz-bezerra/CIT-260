/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;

/**
 *
 * @author Luiz
 */
public class PiecesOfEvidenceView extends View {
    
    @Override
    public void display() {
        GameMenuControl gameControl = new GameMenuControl();                
        this.console.println(gameControl.showEvidence());
    }
    
    @Override
    public boolean doAction(String value) {
        //This function shouldn't be used
        return true;
    }
}
