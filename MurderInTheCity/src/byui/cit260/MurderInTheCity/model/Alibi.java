/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;
/**
 *
 * @author Daniel
 */
public class Alibi implements Serializable {
    
    /*Harris("Harris Sheldon was watching TV home with his wife"),
    Tony("Tony Sumner was running close to his house, practicing for a marathon"),
    Dan("Dan Sumner was at the movies with his girlfriend");*/
    
    //class instance variables
    private String time;
    private String corroborator;
    private String description;
    private boolean validated;
    
    public Alibi() {
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
    
    public void setCorroborator(String corroborator) {
        this.corroborator = corroborator;
    }
    
    public String getCorroborator() {
        return corroborator;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
    
    public boolean getValidated() {
        return validated;
    }

    @Override
    public String toString() {
        return "Alibi{time=" + time + ", corroborator=" + corroborator + ", description=" + description + ", validated=" + validated + '}';
    }
    
}
