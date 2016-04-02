/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import byui.cit260.MurderInTheCity.exceptions.GameMenuControlException;

/**
 *
 * @author Luiz
 */
public class CalcSearchRadiusView extends View {
    
    @Override
    public void display() {
        boolean valid = false;
        String timeFound, timeOfDeath;
        double speedOfTravel, searchRadius = 0;
        GameMenuControl gameControl = new GameMenuControl();
        
        do {
            try {
                this.console.println("\nPlease, enter the speed of travel.");
                speedOfTravel = Double.parseDouble(this.keyboard.readLine());
                this.console.println("\nPlease, enter the time the body was found.");
                timeFound = this.keyboard.readLine();
                this.console.println("\nPlease, enter the time of death.");
                timeOfDeath = this.keyboard.readLine();
                searchRadius = gameControl.calcSearchRadius(speedOfTravel, timeFound, timeOfDeath);
                valid = true;
            }
            catch (GameMenuControlException gmce) {
                ErrorView.display(this.getClass().getName(), gmce.getMessage());
            }
            catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "Please input a number between 0 and 200.");
            }
            catch (Exception ex) {
                ErrorView.display(this.getClass().getName(), "Unexpected Error");
            }
        } while (!valid);
        
        this.console.println("\nThe search radius is " + searchRadius);
    }
    
    @Override
    public boolean doAction(String value) {
        //This function shouldn't be used
        return true;
    }

    @Override
    public String getInput(boolean showDisplay) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}