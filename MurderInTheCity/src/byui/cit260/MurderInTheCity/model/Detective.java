/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;
import java.util.Arrays;
/**
 *
 * @author Daniel
 */
public class Detective implements Serializable {

    private String[] typeOfDetective = {"Probational Detective", "Detective", "Lieutenant", "Captian", "Chief of Police"};
    private int crimesSolved;
    
    public Detective(){
    }

    public String[] getTypeOfDetective() {
        return typeOfDetective;
    }

    public void setTypeOfDetective(String[] typeOfDetective) {
        this.typeOfDetective = typeOfDetective;
    }

    public int getCrimesSolved() {
        return crimesSolved;
    }

    public void setCrimesSolved(int crimesSolved) {
        this.crimesSolved = crimesSolved;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.deepHashCode(this.typeOfDetective);
        hash = 53 * hash + this.crimesSolved;
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
        final Detective other = (Detective) obj;
        if (this.crimesSolved != other.crimesSolved) {
            return false;
        }
        if (!Arrays.deepEquals(this.typeOfDetective, other.typeOfDetective)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detective{" + "typeOfDetective=" +/**typeOfDetective **/+ '}';
    }
    
}
