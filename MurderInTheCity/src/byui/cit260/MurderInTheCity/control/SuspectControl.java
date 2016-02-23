/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

/**
 *
 * @author Daniel and Luiz
 */
public class SuspectControl {
    
    public String showSuspects() {
        return "\nshowSuspects function called";
    }
    
    public boolean removeSuspect(int suspectNumber) {
        System.out.println("\nremoveSuspect function called");
        // Just for a matter of test
        if (suspectNumber < 1)
            return false;
        return true;
    }
}
