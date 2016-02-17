/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import java.util.Locale;
import java.util.Scanner;
import murderinthecity.MurderInTheCity;
/**
 *
 * @author Daniel
 */
public class MainMenuView {

    private final String MENU = "\n" +
            "\n----------------------------------------------" +
            "\n| Main Menu                                  |" +
            "\n----------------------------------------------" +
            "\n N - New Game                                 " +
            "\n H - Get Help                                 " +
            "\n S - Save Game                                " +
            "\n R - Resume Game                              " +
            "\n E - Exit Game                                " +
            "\n----------------------------------------------";
    
    public void displayMainMenuView() {
        String input;
        do {
            System.out.println(MENU);
            
            input = this.getInput();   
            
        } while (!input.equals("E"));
    }
    
        
    private String getInput() {
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        
        boolean valid = true;
        String input;
        
        do { input = keyboard.nextLine();
        input = input.toUpperCase();
        switch (input) {
            case "N":
                this.startNewGame();
                break;
            case "R":
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
            case "E":
                return input;
            default:
                System.out.println("\nInvalid Selection. Try again.");
                valid = false;
                break;
        }
        } while (!valid);
        
        return input;
    }
    
    private void startNewGame() {
        GameMenuControl.createNewGame(MurderInTheCity.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }
    
    private void startExistingGame() {
        
    }
    
    private void displayHelpMenu() {
        System.out.println("displayHelpMenu function called!");
    }
    
    private void saveGame() {
        System.out.println("saveGame function called!");
    }
}
