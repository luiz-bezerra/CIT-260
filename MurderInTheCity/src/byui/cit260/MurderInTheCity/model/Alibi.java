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
 * @author Daniel
 */
public enum Alibi implements Serializable {
    
    Harris("Harris Sheldon was watching TV home with his wife"),
    Tony("Tony Sumner was running close to his house, practicing for a marathon"),
    Dan("Dan Sumner was at the movies with his girlfriend");
    
    //class instance variables
    private final double time;
    private final String corroborator;
    private final String description;
    private final boolean validated;
    
    Alibi(String description) {
        this.description = description;
        this.time = 15;
        this.corroborator = "Aura";
        this.validated = true;
    }

    public double getTime() {
        return time;
    }

    public String getCorroborator() {
        return corroborator;
    }

    public String getDescription() {
        return description;
    }

    public boolean isValidated() {
        return validated;
    }

    @Override
    public String toString() {
        return "Alibi{time=" + time + ", corroborator=" + corroborator + ", description=" + description + ", validated=" + validated + '}';
    }
    
}
