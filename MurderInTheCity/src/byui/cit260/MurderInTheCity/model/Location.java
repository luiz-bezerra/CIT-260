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
public class Location implements Serializable {
    
    // Class instance variables
    private Boolean visited;
    private String name;
    private String description;
    private double distanceFromCrime;
    private String parentLocation;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.visited);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.distanceFromCrime) ^ (Double.doubleToLongBits(this.distanceFromCrime) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.parentLocation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(this.distanceFromCrime) != Double.doubleToLongBits(other.distanceFromCrime)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.parentLocation, other.parentLocation)) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        return true;
    }

    public Location() {
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDistanceFromCrime() {
        return distanceFromCrime;
    }

    public void setDistanceFromCrime(double distanceFromCrime) {
        this.distanceFromCrime = distanceFromCrime;
    }

    public String getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(String parentLocation) {
        this.parentLocation = parentLocation;
    }

    @Override
    public String toString() {
        return "Location{" + "visited=" + visited + ", name=" + name + ", description=" + description + ", distanceFromCrime=" + distanceFromCrime + ", parentLocation=" + parentLocation + '}';
    }
}
