/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;

/**
 *
 * @author Luiz
 */
public class Evidence implements Serializable {
    
    // Class instance variables
    private String name;
    private String description;
    private String locationCollected;

    @Override
    public String toString() {
        return "Evidence{" + "description=" + description + ", locationCollected=" + locationCollected + '}';
    }
    
    public Evidence() {
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setLocationCollected(String locationCollected) {
        this.locationCollected = locationCollected;
    }

    public String getLocationCollected() {
        return locationCollected;
    }

}
