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
public enum Evidence implements Serializable {
    
    knife(""),
    gun(""),
    bullet(""),
    bulletCasing(""),
    brokenGlass(""),
    leadPipe(""),
    bloodyHammer("");
    
    // Class instance variables
    private final String description;
    private final String locationCollected;

    @Override
    public String toString() {
        return "Evidence{" + "description=" + description + ", locationCollected=" + locationCollected + '}';
    }
    
    Evidence(String description) {
        this.description = description;
        this.locationCollected = "Pub";
    }

    public String getDescription() {
        return description;
    }

    public String getLocationCollected() {
        return locationCollected;
    }

}
