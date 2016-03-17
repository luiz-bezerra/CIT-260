/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.model.Detective;

/**
 *
 * @author Daniel and Luiz
 */
public class GameMenuView extends View {

    public GameMenuView() {
            super("\n" +
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
                "\n----------------------------------------------");
    }
    
    /**
    public void displayGameMenuView() {
        String input;
        do {
            System.out.println(MENU);
            
            input = this.getInput();   
            
        } while (!input.equals("E"));
    }
    
    
    public String getInput() {
        
            value = value.toUpperCase();
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
    **/
    
    private void showCity() {
        MapView map = new MapView();
        map.display();
    }
    
    private void showEvidenceList() {
        PiecesOfEvidenceView evidence = new PiecesOfEvidenceView();
        evidence.display();
    }
    
    private void showSuspectList() {
        SuspectListView suspectList = new SuspectListView();
        suspectList.display();
    }
    
    private void calcTimeOfDeath() {
        CalcTimeOfDeathView calcTimeOfDeath = new CalcTimeOfDeathView();
        calcTimeOfDeath.display();
    }
    
    private void calcSearchRadius() {
        CalcSearchRadiusView calcSearchRadius = new CalcSearchRadiusView();
        calcSearchRadius.display();
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
        ProfessionalProgressionView professionalProgressionView = new ProfessionalProgressionView();
        professionalProgressionView.display();
    }
    
    private void showCrimesSolved() {
        System.out.println("showCrimesSolved function called");
    }
    
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
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

    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
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
                finish = true;
                break;
            default:
                System.out.println("\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
}
