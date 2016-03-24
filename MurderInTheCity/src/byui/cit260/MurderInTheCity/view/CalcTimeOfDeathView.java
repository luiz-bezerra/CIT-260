/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import byui.cit260.MurderInTheCity.exceptions.GameMenuControlException;
import java.io.IOException;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luiz
 */
public class CalcTimeOfDeathView extends View {
    
    /**
    public void displayCalcTimeOfDeathView(){
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        String input, output;
        double bodyTemperature = 0, roomTemperature = 0;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        Date timeFound = new Date();
        boolean valid;
        
        do {            
            this.console.println("\nPlease, enter the current temperature of the room.");
            input = keyboard.nextLine();
            try {
                roomTemperature = Double.parseDouble(input);
                valid = true;
            }
            catch (Exception ex) {
                this.console.println("\nInvalid input. Try again.");
                valid = false;
            }
        } while (!valid);
        
        do {            
            this.console.println("\nPlease, enter the current temperature of the victim's body.");
            input = keyboard.nextLine();
            try {
                bodyTemperature = Double.parseDouble(input);
                
                if (bodyTemperature > 42) {
                    this.console.println("\nBody temperature too high");
                    valid = false;
                }
                else if (bodyTemperature < roomTemperature) {
                    this.console.println("\nBody temperature too low");
                    valid = false;
                }
                else {
                    valid = true;
                }
            }
            catch (Exception ex) {
                this.console.println("\nInvalid input. Try again.");
                valid = false;
            }
        } while (!valid);
        
        do {            
            this.console.println("\nPlease, enter the time the victim's body was found.");
            input = keyboard.nextLine();
            try {
                timeFound = dateFormat.parse(input);
                valid = true;
            }
            catch (Exception ex) {
                this.console.println("\nInvalid time found. Try again.");
                valid = false;
            }
        } while (!valid);
        
        GameMenuControl gameControl = new GameMenuControl();
        output = gameControl.calcTimeOfDeath(bodyTemperature, roomTemperature, timeFound);
        this.console.println(output);
    }
    **/
    
    @Override
    public void display () {
        Scanner keyboard;
        String input, output;
        double bodyTemperature = 0, roomTemperature = 0;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        Date timeFound = new Date();
        boolean valid = false;
        
        do {            
            try {            
                this.console.println("\nPlease, enter the current temperature of the room.");
                input = this.keyboard.readLine();
                try {
                    roomTemperature = Double.parseDouble(input);
                    valid = true;
                }
                catch (NumberFormatException nfe) {
                    this.console.println("\nTemperature should be a number. Try again.");
                    valid = false;
                }
            }
            catch (IOException ex) {
                Logger.getLogger(CalcTimeOfDeathView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (!valid);
        
        do {            
            try {            
                this.console.println("\nPlease, enter the current temperature of the victim's body.");
                input = this.keyboard.readLine();
                try {
                    bodyTemperature = Double.parseDouble(input);
                    
                    if (bodyTemperature > 42) {
                        ErrorView.display(this.getClass().getName(), "Body temperature too high.");
                        //this.console.println("\nBody temperature too high");
                        valid = false;
                    }
                    else if (bodyTemperature < roomTemperature) {
                        ErrorView.display(this.getClass().getName(), "Body temperature too low.");
                        //this.console.println("\nBody temperature too low");
                        valid = false;
                    }
                    else {
                        valid = true;
                    }
                }
                catch (NumberFormatException nfe) {
                    ErrorView.display(this.getClass().getName(), "Error reading input: " + nfe.getMessage());
                    valid = false;
                }
            }
            catch (IOException ex) {
                Logger.getLogger(CalcTimeOfDeathView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (!valid);
        
        do {            
            try {            
                this.console.println("\nPlease, enter the time the victim's body was found.");
                input = this.keyboard.readLine();
                try {
                    timeFound = dateFormat.parse(input);
                    valid = true;
                }
                catch (Exception ex) {
                    ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());
                    valid = false;
                }
            }
            catch (IOException ex) {
                Logger.getLogger(CalcTimeOfDeathView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (!valid);
        
        GameMenuControl gameControl = new GameMenuControl();
        try {
            output = gameControl.calcTimeOfDeath(bodyTemperature, roomTemperature, timeFound);
            this.console.println(output);
        }
        catch (GameMenuControlException gmce) {
            gmce.getMessage();
        }
        //return true;
    }
    
    @Override
    public boolean doAction(String value) {
        //This function shouldn't be used
        return true;
    }
}
