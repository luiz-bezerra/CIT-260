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
    private int row;
    private int column;
    private Boolean visited;
    private String description;
    private double distanceFromCrime;
    private String parentLocation;

    public Location() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.row;
        hash = 23 * hash + this.column;
        hash = 23 * hash + Objects.hashCode(this.visited);
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.distanceFromCrime) ^ (Double.doubleToLongBits(this.distanceFromCrime) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.parentLocation);
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
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (Double.doubleToLongBits(this.distanceFromCrime) != Double.doubleToLongBits(other.distanceFromCrime)) {
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

    @Override
    public String toString() {
        return "Location{" + "visited=" + visited + ", name=" /**+ name **/+ ", description=" + description + ", distanceFromCrime=" + distanceFromCrime + ", parentLocation=" + parentLocation + '}';
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
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

    
}
