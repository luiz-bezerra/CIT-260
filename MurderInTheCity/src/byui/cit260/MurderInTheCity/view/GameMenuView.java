/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import java.util.Scanner;
/**
 *
 * @author Daniel
 */
public class GameMenuView {

    private final String MENU = "\n" +
            "\n----------------------------------------------" +
            "\n| Game Menu                                  |" +
            "\n----------------------------------------------" +
            "\n C - View City Locations                      " +
            "\n I - Evidence List                            " +
            "\n L - Suspect List                             " +
            "\n D - Calculate Time of Death                  " +
            "\n R - Calculate Search Radius                  " +
            "\n V - Validate a Suspect's Alibi               " +
            "\n O - Solve the Crime                          " +
            "\n M - Move to a new Location                   " +
            "\n X - Explore the City                         " +
            "\n P - Professional Progression                 " +
            "\n S - Crimes Solved                            " +
            "\n H - Get Help                                 " +
            "\n U - Resume Game                              " +
            "\n T - Restart Game                             " +
            "\n G - Save Game                                " +
            "\n E - Exit Game                                " +
            "\n----------------------------------------------";
    
    public void displayGameMenuView() {
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
            case "C":
                this.showCity();
                break;
            case "I":
                this.showEvidenceList();
                break;
            case "L":
                this.showSuspectList();
                break;
            case "D":
                this.calcTimeOfDeath();
                break;
            case "R":
                this.calcSearchRadius();
                break;
            case "V":
                this.validateAlibi();
                break;
            case "O":
                this.solveCrime();
                break;
            case "M":
                this.moveToLocation();
                break;
            case "X":
                this.exploreCity();
                break;
            case "P":
                this.showProgress();
                break;
            case "S":
                this.showCrimesSolved();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "U":
                this.resumeGame();
                break;
            case "T":
                this.restartGame();
                break;
            case "G":
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
    
    private void showCity() {
        System.out.println("showCity function called");
    }
    
    private void showEvidenceList() {
        System.out.println("saveEvidenceList function called");
    }
    
    private void showSuspectList() {
        System.out.println("showSuspectList function called");
    }
    
    private void calcTimeOfDeath() {
        /*
        GameMenuControl.calcTimeOfDeath( bodyTemp, roomTemp, timeFound);
        
        CalcTimeOfDeathView calcTimeOfDeath = new CalcTimeOfDeathView();
        calcTimeOfDeath.calcTimeOfDeath();
        */
        
        System.out.println("calcTimeOfDeath function called");
    }
    
    private void calcSearchRadius() {
        /*
        GameMenuControl.calcSearchRadius(speedOfTravel, timeSinceDeath);
        
        CalcSearchRadiusView calcSearchRadius = new CalcSearchRadiusView();
        calcSearchRadius.calcSearchRadius();
        */
        
        System.out.println("calcSearchRadius function called");
    }
    
    private void validateAlibi() {
        /*
        GameMenuControl.validateAlibi(place, time, timeOfDeath, searchRadius);
        
        ValidateAlibiView validateAlibi = new ValidateAlibiView();
        validateAlibi.validateAlibi();
        */
        
        System.out.println("validateAlibi function called");
    }
    
    private void solveCrime() {
        System.out.println("solveCrime function called");
    }
    
    private void moveToLocation() {
        System.out.println("moveToLocation function called");
    }
    
    private void exploreCity() {
        System.out.println("exploreCity function called");
    }
    
    private void showProgress() {
        System.out.println("showProgress function called");
    }
    
    private void showCrimesSolved() {
        System.out.println("showCrimesSolved function called");
    }
    
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }
    
    private void resumeGame() {
        System.out.println("resumeGame function called");
    }
    
    private void restartGame() {
        System.out.println("restartGame function called");
    }
    
    private void saveGame() {
        System.out.println("saveGame function called");
    }
}
