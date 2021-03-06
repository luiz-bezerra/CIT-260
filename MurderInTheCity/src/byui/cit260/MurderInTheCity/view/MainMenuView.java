/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameControl;
import byui.cit260.MurderInTheCity.control.SceneControl;
import murderinthecity.MurderInTheCity;
/**
 *
 * @author Daniel and Luiz
 */
public class MainMenuView extends View {

    
    public MainMenuView() {
        super("\n" +
            "\n----------------------------------------------" +
            "\n| Main Menu                                  |" +
            "\n----------------------------------------------" +
            "\n 1 - New Game                                 " +
            "\n 2 - Get Help                                 " +
            "\n 3 - Resume Game                              " +
            "\n E - Exit Game                                " +
            "\n----------------------------------------------");
    }
    
    private void startNewGame() {
        GameControl.createNewGame(MurderInTheCity.getPlayer());
        
        /*GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();*/
        SceneControl.startNextScene();
    }
    
    private void startExistingGame() {
        this.console.println("\nEnter the file path to load:");     
        String filePath = this.getInput(false);
        
        try {
            GameControl.getSavedGame(filePath);
        }
        catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        /*GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();*/
        SceneControl.startNextScene();
    }
    
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    /*private void saveGame() {
        this.console.println("\nEnter the file path to save to:");
        String filePath = this.getInput(false);
        
        try {
            GameControl.saveGame(MurderInTheCity.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }*/

    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "1":
                this.startNewGame();
                break;
            case "3":
                this.startExistingGame();
                break;
            case "2":
                this.displayHelpMenu();
                break;
            /*case "S":
                this.saveGame();
                break;*/
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
}