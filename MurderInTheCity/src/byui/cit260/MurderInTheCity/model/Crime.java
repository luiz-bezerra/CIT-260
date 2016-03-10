/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Luiz
 */
public enum Crime implements Serializable {
 
    murder(""),
    theft(""),
    serialMurder(""),
    assault("");
    
    // Class instance variables
    private final String crimePlace;
    private final String crimeVictim;
    private final String crimeOffender;
    private final Boolean solved;

    @Override
    public String toString() {
        return "Crime{crimePlace=" + crimePlace + ", crimeVictim=" + crimeVictim + ", crimeType=" + /**crimeType +**/ ", crimeOffender=" + crimeOffender + ", solved=" + solved + '}';
    }

    Crime(String crimeVictim) {
        this.crimePlace = "Cafe";
        this.crimeVictim = crimeVictim;
        this.crimeOffender = "Stephen";
        this.solved = true;
    }

    public String getCrimePlace() {
        return crimePlace;
    }

    public String getCrimeVictim() {
        return crimeVictim;
    }

    public String getCrimeOffender() {
        return crimeOffender;
    }

    public Boolean getSolved() {
        return solved;
    }

}
