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
public class CrimeScene implements Serializable {
    
    // Class instance variables
    private Integer witnesses;
    private double temperature;

    @Override
    public String toString() {
        return "CrimeScene{" + "witnesses=" + witnesses + ", temperature=" + temperature + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.witnesses);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.temperature) ^ (Double.doubleToLongBits(this.temperature) >>> 32));
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
        final CrimeScene other = (CrimeScene) obj;
        if (Double.doubleToLongBits(this.temperature) != Double.doubleToLongBits(other.temperature)) {
            return false;
        }
        if (!Objects.equals(this.witnesses, other.witnesses)) {
            return false;
        }
        return true;
    }

    public CrimeScene() {
    }

    public Integer getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(Integer witnesses) {
        this.witnesses = witnesses;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
