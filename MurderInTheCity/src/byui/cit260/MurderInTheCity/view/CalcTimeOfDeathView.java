/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameMenuControl;
import byui.cit260.MurderInTheCity.exceptions.GameMenuControlException;
import java.io.IOException;
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
    
    @Override
    public void display () {
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
                    ErrorView.display(this.getClass().getName(), "Temperature should be a number. Try again.");
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
                        valid = false;
                    }
                    else if (bodyTemperature < roomTemperature) {
                        ErrorView.display(this.getClass().getName(), "Body temperature too low.");
                        valid = false;
                    }
                    else {
                        valid = true;
                    }
                }
                catch (NumberFormatException nfe) {
                    ErrorView.display(this.getClass().getName(), "Temperature should be a number. Try again.");
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
                    ErrorView.display(this.getClass().getName(), "Invalid time format. Input it like '10:00 AM'");
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
            ErrorView.display(this.getClass().getName(), gmce.getMessage());
        }
    }
    
    @Override
    public boolean doAction(String value) {
        //This function shouldn't be used
        return true;
    }
}