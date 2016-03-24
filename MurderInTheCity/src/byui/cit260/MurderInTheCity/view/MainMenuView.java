/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameControl;
import byui.cit260.MurderInTheCity.control.GameMenuControl;
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
            "\n N - New Game                                 " +
            "\n H - Get Help                                 " +
            "\n S - Save Game                                " +
            "\n R - Resume Game                              " +
            "\n E - Exit Game                                " +
            "\n----------------------------------------------");
    }
    
    /**
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
            this.console.println(MENU);
            
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
                    this.console.println("\nInvalid Selection. Try again.");
                    valid = false;
                    break;
            }
        } while (!valid);
        
        return input;
    }
    **/
    
    private void startNewGame() {
        GameMenuControl.createNewGame(MurderInTheCity.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
    
    private void startExistingGame() {
        this.console.println("\nEnter the file path to load:");     
        String filePath = this.getInput();
        
        try {
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
    
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    private void saveGame() {
        this.console.println("\nEnter the file path to save to:");
        String filePath = this.getInput();
        
        try {
            GameControl.SaveGame(MurderInTheCity.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
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
                finish = true;
                break;
            default:
                this.console.println("\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
}
