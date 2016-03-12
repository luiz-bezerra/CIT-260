/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Luiz
 */
public class Map implements Serializable {
    
    // Class instance variables
    private int noOfRows;
    private int noOfColumns;
    private Location[][] locations;

    @Override
    public String toString() {
        return "Map{" + "noOfRows=" + noOfRows + "noOfColumns=" + noOfColumns +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.noOfRows;
        hash = 71 * hash + this.noOfColumns;
        hash = 71 * hash + Arrays.deepHashCode(this.locations);
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
        final Map other = (Map) obj;
        if (!Objects.equals(this.noOfRows, other.noOfRows)) {
            return false;
        }
        return true;
    }

    public Map() {
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    
}
