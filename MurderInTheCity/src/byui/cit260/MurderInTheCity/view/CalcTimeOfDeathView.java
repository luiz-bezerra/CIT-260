/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Luiz
 */
public class CalcTimeOfDeathView {
    public void displayCalcTimeOfDeathView(){
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        String input, output;
        double bodyTemperature = 0, roomTemperature = 0;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        Date timeFound = new Date();
        boolean valid;
        
        do {            
            System.out.println("\nPlease, enter the current temperature of the room.");
            input = keyboard.nextLine();
            try {
                roomTemperature = Double.parseDouble(input);
                valid = true;
            }
            catch (Exception ex) {
                System.out.println("\nInvalid input. Try again.");
                valid = false;
            }
        } while (!valid);
        
        do {            
            System.out.println("\nPlease, enter the current temperature of the victim's body.");
            input = keyboard.nextLine();
            try {
                bodyTemperature = Double.parseDouble(input);
                
                if (bodyTemperature > 42) {
                    System.out.println("\nBody temperature too high");
                    valid = false;
                }
                else if (bodyTemperature < roomTemperature) {
                    System.out.println("\nBody temperature too low");
                    valid = false;
                }
                else {
                    valid = true;
                }
            }
            catch (Exception ex) {
                System.out.println("\nInvalid input. Try again.");
                valid = false;
            }
        } while (!valid);
        
        do {            
            System.out.println("\nPlease, enter the time the victim's body was found.");
            input = keyboard.nextLine();
            try {
                timeFound = dateFormat.parse(input);
                valid = true;
            }
            catch (Exception ex) {
                System.out.println("\nInvalid time found. Try again.");
                valid = false;
            }
        } while (!valid);
        
        GameMenuControl gameControl = new GameMenuControl();
        output = gameControl.calcTimeOfDeath(bodyTemperature, roomTemperature, timeFound);
        System.out.println(output);
    }
}
