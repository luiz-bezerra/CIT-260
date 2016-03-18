/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import byui.cit260.MurderInTheCity.exceptions.GameMenuControlException;
import java.util.Scanner;

/**
 *
 * @author Luiz
 */
public class CalcSearchRadiusView extends View {
    
    @Override
    public void display() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String timeFound, timeOfDeath;
        double speedOfTravel, searchRadius = 0;
        GameMenuControl gameControl = new GameMenuControl();
        
        do {
            try {
                System.out.println("\nPlease, enter the speed of travel.");
                speedOfTravel = Double.parseDouble(keyboard.nextLine());
                System.out.println("\nPlease, enter the time the body was found.");
                timeFound = keyboard.nextLine();
                System.out.println("\nPlease, enter the time of death.");
                timeOfDeath = keyboard.nextLine();
                searchRadius = gameControl.calcSearchRadius(speedOfTravel, timeFound, timeOfDeath);
                valid = true;
            }
            catch (GameMenuControlException gmce) {
                System.out.println(gmce.getMessage());
            }
            catch (NumberFormatException nf) {
                System.out.println("Please input a number between 0 and 200.");
            }
            catch (Exception ex) {
                System.out.println("Unexpected Error");
            }
        } while (!valid);
        
        System.out.println("\nThe search radius is " + searchRadius);
    }
    
    @Override
    public boolean doAction(String value) {
        //This function shouldn't be used
        return true;
    }
}
