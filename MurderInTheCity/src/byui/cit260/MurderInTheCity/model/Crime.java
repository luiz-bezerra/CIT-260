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
public class Crime implements Serializable {
 
    // Class instance variables
    private String crimeType;
    private String crimePlace;
    private String crimeVictim;
    private String crimeOffender;
    private Boolean solved;

    @Override
    public String toString() {
        return "Crime{" + "crimeType=" + crimeType + ", crimePlace=" + crimePlace + ", crimeVictim=" + crimeVictim + ", crimeOffender=" + crimeOffender + ", solved=" + solved + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.crimeType);
        hash = 59 * hash + Objects.hashCode(this.crimePlace);
        hash = 59 * hash + Objects.hashCode(this.crimeVictim);
        hash = 59 * hash + Objects.hashCode(this.crimeOffender);
        hash = 59 * hash + Objects.hashCode(this.solved);
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
        final Crime other = (Crime) obj;
        if (!Objects.equals(this.crimeType, other.crimeType)) {
            return false;
        }
        if (!Objects.equals(this.crimePlace, other.crimePlace)) {
            return false;
        }
        if (!Objects.equals(this.crimeVictim, other.crimeVictim)) {
            return false;
        }
        if (!Objects.equals(this.crimeOffender, other.crimeOffender)) {
            return false;
        }
        if (!Objects.equals(this.solved, other.solved)) {
            return false;
        }
        return true;
    }

    public Crime() {
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getCrimePlace() {
        return crimePlace;
    }

    public void setCrimePlace(String crimePlace) {
        this.crimePlace = crimePlace;
    }

    public String getCrimeVictim() {
        return crimeVictim;
    }

    public void setCrimeVictim(String crimeVictim) {
        this.crimeVictim = crimeVictim;
    }

    public String getCrimeOffender() {
        return crimeOffender;
    }

    public void setCrimeOffender(String crimeOffender) {
        this.crimeOffender = crimeOffender;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }
}
