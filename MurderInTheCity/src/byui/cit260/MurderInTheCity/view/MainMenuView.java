/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import byui.cit260.MurderInTheCity.model.Suspect;
import java.util.Scanner;
import murderinthecity.MurderInTheCity;
/**
 *
 * @author Daniel and Luiz
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
        
        do { 
            input = keyboard.nextLine();
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
        gameMenu.displayGameMenuView();
    }
    
    private void startExistingGame() {
        // Pass variable by value:
        Suspect suspect = new Suspect();
        suspect.setTimeAtLocation(10);
        double timeAtLocation = suspect.getTimeAtLocation();
        System.out.println(timeAtLocation);
        this.passByValue(timeAtLocation);
        System.out.println(timeAtLocation);
        
        // Pass variable by reference:
        this.passByReference(suspect);
        System.out.println(suspect.getTimeAtLocation());
    }
    
    private void passByReference(Suspect suspectedPerson) {
        System.out.println(suspectedPerson.getTimeAtLocation());
        suspectedPerson.setTimeAtLocation(12);
    }
    
    private void passByValue(double time) {
        time = 4;
        System.out.println(time);
    }
    
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }
    
    private void saveGame() {
        System.out.println("saveGame function called!");
    }
}
