/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import byui.cit260.MurderInTheCity.exceptions.SuspectControlExceptions;
import byui.cit260.MurderInTheCity.model.Alibi;
import byui.cit260.MurderInTheCity.model.Crime;
import byui.cit260.MurderInTheCity.model.Suspect;
import byui.cit260.MurderInTheCity.model.SuspectName;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author Daniel and Luiz
 */
public class SuspectControl {
    
    Crime[] crime = MurderInTheCity.getCurrentGame().getCrime();
    Suspect[] suspect;
    
    public SuspectControl() {
        suspect = crime[0].getSuspect();
    }
    
    public String showSuspects() {
        String suspectList = "";
        Alibi alibi;
        
        for (int i = 0; i < suspect.length; i++) {
            suspectList +=
                "\n " + (i + 1) + " - Name: " + suspect[i].getName();
            alibi = suspect[i].getAlibi();
            
            if(!alibi.getTime().equals("")) {
                suspectList +=
                    "\n   - Alibi: " + alibi.getDescription() +
                    "\n   - Corroborator: " + alibi.getCorroborator();
            }
        }
        
        return suspectList;
    }
    
    public boolean removeSuspect(int suspectNumber) throws SuspectControlExceptions {
        System.out.println("\nremoveSuspect function called");
        // Just for a matter of test
        if (suspectNumber < 1 || suspectNumber > SuspectName.values().length) {
            throw new SuspectControlExceptions("Input a valid number.");
        }
        return true;
    }
}
