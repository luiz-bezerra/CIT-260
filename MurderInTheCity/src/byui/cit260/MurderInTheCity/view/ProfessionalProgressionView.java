/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

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
            "\n C - Crimes Solved                            " +
            "\n T - Time Spent as a Detective                " +
            "\n R - Current Professional Rank                " +
            "\n E - Exit Menu                                " +
            "\n----------------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "C":
                this.showCrimesSolved();
                break;
            case "T":
                this.showTimeSpent();
                break;
            case "R":
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
        this.console.println("showTimeSpent function called.");
    }
    
    private void showCurrentRank() {
        this.console.println("showCurrentRank function called.");
    }
}