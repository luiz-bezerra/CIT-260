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
public class DefenseAttorneyOffice implements Serializable {
    
    // Class instance variables
    private Boolean solve;
    private String evidence;
    private String suspect;

    @Override
    public String toString() {
        return "DefenseAttorneyOffice{" + "solve=" + solve + ", evidence=" + evidence + ", suspect=" + suspect + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.solve);
        hash = 13 * hash + Objects.hashCode(this.evidence);
        hash = 13 * hash + Objects.hashCode(this.suspect);
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
        final DefenseAttorneyOffice other = (DefenseAttorneyOffice) obj;
        if (!Objects.equals(this.evidence, other.evidence)) {
            return false;
        }
        if (!Objects.equals(this.suspect, other.suspect)) {
            return false;
        }
        if (!Objects.equals(this.solve, other.solve)) {
            return false;
        }
        return true;
    }

    public DefenseAttorneyOffice() {
    }

    public Boolean getSolve() {
        return solve;
    }

    public void setSolve(Boolean solve) {
        this.solve = solve;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }
}
