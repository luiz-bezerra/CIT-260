/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.SceneControl;
import byui.cit260.MurderInTheCity.model.Scene;
import byui.cit260.MurderInTheCity.model.SceneType;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author luiz
 */
public class SceneView extends View {
    
    Scene[] scene = MurderInTheCity.getCurrentGame().getScene();
    SceneType sceneType;
    boolean showDisplay;
    
    public SceneView(SceneType sceneType, boolean showDisplay) { 
        this.sceneType = sceneType;
        this.showDisplay = showDisplay;
    }
    
    @Override
    public void display() {
        boolean done = false;
        do {
            String value = this.getInput(showDisplay);
            if (value.toUpperCase().equals("E"))
                return;
            
            done = this.doAction(value);
        } while (!done);
    }
    
    @Override
    public String getInput(boolean showDisplay) {
        this.displayMessage = scene[sceneType.ordinal()].getDescription();
        
        if (showDisplay)
            this.displayMessage +=
                "\n----------------------------------------------" +
                "\n| Main Menu                                  |" +
                "\n----------------------------------------------" +
                "\n T - Talk                                     " +
                "\n X - Explore the Location                     " +
                "\n M - Move to a New Location                   " +
                "\n G - Game Menu                                " +
                "\n----------------------------------------------";
        else
            this.displayMessage +=
                "\n\nPress any key to continue";
        
        this.console.println("\n" + this.displayMessage);
        return super.getInput(false);
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        if (!showDisplay) {
            finish = true;
            return finish;
        }        
        
        switch (value) {
            case "T":
                this.talk();
                break;
            case "X":
                this.exploreLocation();
                break;
            case "M":
                this.moveToNewLocation();
                break;
            case "G":
                this.showGameMenu();
                break;
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        return finish;
    }

    private void talk() {
        SceneControl.talk();
    }

    private void exploreLocation() {
        SceneControl.exploreLocation();
    }

    private void moveToNewLocation() {
        SceneControl.moveToNewLocation();
    }

    private void showGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
