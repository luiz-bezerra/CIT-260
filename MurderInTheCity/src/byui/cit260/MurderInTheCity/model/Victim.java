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
public class Victim implements Serializable {
    
    //class instance variables
    private double timeOfDeath;
    private double bodyTemp;
    private double timeFound;
    
    public Victim() {
    }

    public double getTimeOfDeath() {
        return timeOfDeath;
    }

    public void setTimeOfDeath(double timeOfDeath) {
        this.timeOfDeath = timeOfDeath;
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public double getTimeFound() {
        return timeFound;
    }

    public void setTimeFound(double timeFound) {
        this.timeFound = timeFound;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.timeOfDeath) ^ (Double.doubleToLongBits(this.timeOfDeath) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.bodyTemp) ^ (Double.doubleToLongBits(this.bodyTemp) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.timeFound) ^ (Double.doubleToLongBits(this.timeFound) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Victim{" + "timeOfDeath=" + timeOfDeath + ", bodyTemp=" + bodyTemp + ", timeFound=" + timeFound + '}';
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
        final Victim other = (Victim) obj;
        if (Double.doubleToLongBits(this.timeOfDeath) != Double.doubleToLongBits(other.timeOfDeath)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bodyTemp) != Double.doubleToLongBits(other.bodyTemp)) {
            return false;
        }
        if (Double.doubleToLongBits(this.timeFound) != Double.doubleToLongBits(other.timeFound)) {
            return false;
        }
        return true;
    }
    
    
}
