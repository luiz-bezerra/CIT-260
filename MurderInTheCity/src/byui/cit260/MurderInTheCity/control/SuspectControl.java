/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import byui.cit260.MurderInTheCity.exceptions.SuspectControlExceptions;
import byui.cit260.MurderInTheCity.model.Suspect;

/**
 *
 * @author Daniel and Luiz
 */
public class SuspectControl {
    
    
    
    public String showSuspects() {
        return "\nshowSuspects function called";
    }
    
    public boolean removeSuspect(int suspectNumber) throws SuspectControlExceptions {
        System.out.println("\nremoveSuspect function called");
        // Just for a matter of test
        if (suspectNumber < 1 || suspectNumber > Suspect.values().length) {
            throw new SuspectControlExceptions("Input a valid number.");
        }
        return true;
    }
}
