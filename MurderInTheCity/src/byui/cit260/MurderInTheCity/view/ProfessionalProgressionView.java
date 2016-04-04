/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import murderinthecity.MurderInTheCity;

/**
 *
 * @author Daniel
 */
public class ProfessionalProgressionView extends View {

    public ProfessionalProgressionView() {
        super("\n" +
            "\n----------------------------------------------" +
            "\n| Professional Progression                   |" +
            "\n----------------------------------------------" +
            "\n 1 - Crimes Solved                            " +
            "\n 2 - Time Spent as a Detective                " +
            "\n 3 - Current Professional Rank                " +
            "\n E - Exit Menu                                " +
            "\n----------------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "1":
                this.showCrimesSolved();
                break;
            case "2":
                this.showTimeSpent();
                break;
            case "3":
                this.showCurrentRank();
                break;
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
    
    private void showCrimesSolved() {
        CrimesSolvedView crimesSolved = new CrimesSolvedView();
        crimesSolved.display();
    }
    
    private void showTimeSpent() {
        long timeAsDetective = 0;
        String sfx = "";
        long timeAsDetectiveMS = System.currentTimeMillis() - MurderInTheCity.begin;
        
        if (timeAsDetectiveMS < 60000 && timeAsDetectiveMS > 1000) {
            timeAsDetective = timeAsDetectiveMS/1000;
            sfx = " Seconds";
        } else if (timeAsDetectiveMS < 3600000 && timeAsDetectiveMS > 60000) {
            timeAsDetective = timeAsDetectiveMS/60000;
            sfx = " Minutes";
        }
        this.console.println("Current time spent as a detective: " + timeAsDetective + sfx);
    }
    
    private void showCurrentRank() {
        DetectiveView rank = new DetectiveView();
        rank.display();
    }
}