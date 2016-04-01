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
    
    public SceneView(SceneType sceneType) { 
        this.sceneType = sceneType;
    }
    
    @Override
    public String getInput(boolean showDisplay) {
        //showDisplay = true;
        this.displayMessage = scene[sceneType.ordinal()].getDescription() +
                "\n----------------------------------------------" +
                "\n| Main Menu                                  |" +
                "\n----------------------------------------------" +
                "\n T - Talk                                     " +
                "\n X - Explore the Location                     " +
                "\n M - Move to a New Location                   " +
                "\n G - Game Menu                                " +
                "\n----------------------------------------------";
        return super.getInput(showDisplay);
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
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
