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
public enum Location implements Serializable {
    
    cafe(""),
    pub(""),
    store(""),
    office(""),
    park(""),
    prison("");
    
    // Class instance variables
    private final Boolean visited;
    private final String description;
    private final double distanceFromCrime;
    private final String parentLocation;

    Location(String description) {
        this.visited = true;
        this.description = description;
        this.distanceFromCrime = 10;
        this.parentLocation = "34th Street.";
    }

    public Boolean getVisited() {
        return visited;
    }

    public String getDescription() {
        return description;
    }

    public double getDistanceFromCrime() {
        return distanceFromCrime;
    }

    public String getParentLocation() {
        return parentLocation;
    }

    @Override
    public String toString() {
        return "Location{" + "visited=" + visited + ", name=" /**+ name **/+ ", description=" + description + ", distanceFromCrime=" + distanceFromCrime + ", parentLocation=" + parentLocation + '}';
    }
}
