/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameControl;
import murderinthecity.MurderInTheCity;
/**
 *
 * @author Daniel and Luiz
 */
public class GameMenuView extends View {

    /*public GameMenuView() {
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
<<<<<<< HEAD
=======
    }*/
    
    public GameMenuView() {
            super("\n" +
                "\n----------------------------------------------" +
                "\n| Game Menu                                  |" +
                "\n----------------------------------------------" +
                "\n 1 - Resume Game                              " +
                "\n 2 - Get Help                                 " +
                "\n 3 - Professional Progression                 " +
             /* "\n S - Crimes Solved                            " + */
                "\n 4 - Restart Game                             " +
                "\n 5 - Save Game                                " +
                "\n E - Exit Game                                " +
                "\n----------------------------------------------");
    }
    
    private void showCity() {
        MapView map = new MapView();
        map.display();
    }
    
    /*private void showEvidenceList() {
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
        
        //GameMenuControl.validateAlibi(place, time, timeOfDeath, searchRadius);
        
        //ValidateAlibiView validateAlibi = new ValidateAlibiView();
        //validateAlibi.validateAlibi();
        
        this.console.println("validateAlibi function called");
    }
    
    private void solveCrime() {
        this.console.println("solveCrime function called");
    }
    
    private void moveToLocation() {
        this.console.println("moveToLocation function called");
    }
    
    private void exploreCity() {
        this.console.println("exploreCity function called");
    }*/
    
    private void showProgress() {
        ProfessionalProgressionView professionalProgressionView = new ProfessionalProgressionView();
        professionalProgressionView.display();
    }
    
  /*private void showCrimesSolved() {
        this.console.println("showCrimesSolved function called");
    }*/
    
    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
 /* private void resumeGame() {
        this.console.println("resumeGame function called");
    } */
    
    private void restartGame() {
        StartProgramView restart = new StartProgramView();
        restart.display();
    }
    
    private void saveGame() {
        this.console.println("\nEnter the file path to save to:");
        String filePath = this.getInput(false);
        
        try {

            GameControl.saveGame(MurderInTheCity.getCurrentGame(), filePath);
            this.console.println("\nGame saved!");
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    @Override
    public void display() {
        boolean done = false;
        do {
            String value = this.getInput(true);
            /*if (value.toUpperCase().equals("E"))
                return;*/
            
            done = this.doAction(value);
        } while (!done);
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            /*case "C":
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
                break;*/
            case "1":
                finish = true;
                break;
            /*case "V":
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
                break;*/
            case "3":
                this.showProgress();
                break;
          /*case "S":
                this.showCrimesSolved();
                break;*/
            case "2":
                this.displayHelpMenu();
                break;
          /*case "U":
                this.resumeGame();
                break; */
            case "4":
                this.restartGame();
                break;
            case "5":
                this.saveGame();
                break;
            case "E":
                finish = true;
                MurderInTheCity.setExitGame(true);
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
}
