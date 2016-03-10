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
public enum DefenseAttorneyOffice implements Serializable {
    
    knife(""),
    gun(""),
    bullet(""),
    bulletCasing(""),
    brokenGlass(""),
    leadPipe("");
    
    // Class instance variables
    private final Boolean solve;
    private final String suspect;

    @Override
    public String toString() {
        return "DefenseAttorneyOffice{evidence= " +/** evidence +**/ "solve= " + solve + "suspect= "+ suspect +'}';
    }

    DefenseAttorneyOffice(String suspect) {
        this.suspect = suspect;
        this.solve = true;
    }

    public Boolean getSolve() {
        return solve;
    }
   
    public String getSuspect() {
        return suspect;
    }

}
