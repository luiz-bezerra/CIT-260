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
    boolean isCutscene, alreadyDisplayed;
    String sceneMenu = 
            "\n----------------------------------------------" +
            "\n| Scene Menu                                 |" +
            "\n----------------------------------------------" +
            "\n 1 - Talk                                     " +
            "\n 2 - Explore the Location                     " +
            "\n 3 - Move to a New Location                   " +
            "\n 4 - Turn On Tablet                           " +
            "\n 5 - Game Menu                                " +
            "\n----------------------------------------------";
    
    public SceneView(SceneType sceneType, boolean isCutscene) { 
        this.sceneType = sceneType;
        this.isCutscene = isCutscene;
    }
    
    @Override
    public void display() {
        boolean done = false;
        do {
            if (MurderInTheCity.getSkipScene()){
                MurderInTheCity.setSkipScene(false);
                scene[sceneType.ordinal()].setCompleted(true);
                break;
            }
            
            String value = this.getInput(!isCutscene);
            /*if (value.toUpperCase().equals("E"))
                return;*/
            
            done = this.doAction(value);
        } while (!done);
        
        if (MurderInTheCity.getExitGame())
            MurderInTheCity.setExitGame(false);
        else
            SceneControl.startNextScene();
    }
    
    @Override
    public String getInput(boolean showDisplay) {
        this.displayMessage = scene[sceneType.ordinal()].getDescription();
        
        if (alreadyDisplayed) {
            this.console.println("\n" + sceneMenu);
        }
        else {
            if (showDisplay)
                this.displayMessage += sceneMenu;
            else
                this.displayMessage +=
                    "\n\nPress Enter to continue";
            
            this.console.println("\n" + this.displayMessage);
            alreadyDisplayed = true;
        }
        
        if (showDisplay)
            return super.getInput(false);
        
        this.console.println("\n" + this.displayMessage);
        
        try {
            return this.keyboard.readLine();
        }
        catch (Exception ex) {
            return "";
        }
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        if (isCutscene) {
            scene[sceneType.ordinal()].setCompleted(true);
            return true;
        }        
        
        switch (value) {
            case "1":
                this.talk();
                break;
            case "2":
                this.exploreLocation();
                break;
            case "3":
                this.moveToNewLocation();
                scene[sceneType.ordinal()].setCompleted(true);
                break;
            case "4":
                this.showTabletMenu();
                break;
            case "5":
                this.showGameMenu();
                if (MurderInTheCity.getExitGame()) {
                    finish = true;
                }
                break;
            /*case "E":
                scene[sceneType.ordinal()].setCompleted(true);
                finish = true;
                break;*/
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        return finish;
    }

    private void talk() {
        SceneControl.talk(scene, sceneType);
    }

    private void exploreLocation() {
        SceneControl.exploreLocation();
    }

    private void moveToNewLocation() {
        SceneControl.moveToNewLocation();
    }
    
    private void showTabletMenu() {
        TabletMenuView tabletMenu = new TabletMenuView();
        tabletMenu.display();
    }

    private void showGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}