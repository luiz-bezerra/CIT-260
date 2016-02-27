/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;

/**
 *
 * @author Daniel & Luiz
 */
public class Suspect implements Serializable {
    
    //class instance variables
    private double timeAtLocation;
    
    public Suspect() {
    }

    public double getTimeAtLocation() {
        return timeAtLocation;
    }

    public void setTimeAtLocation(double timeAtLocation) {
        this.timeAtLocation = timeAtLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.timeAtLocation) ^ (Double.doubleToLongBits(this.timeAtLocation) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Suspect{" + "timeAtLocation=" + timeAtLocation + '}';
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
        final Suspect other = (Suspect) obj;
        if (Double.doubleToLongBits(this.timeAtLocation) != Double.doubleToLongBits(other.timeAtLocation)) {
            return false;
        }
        return true;
    }
    
    
}
