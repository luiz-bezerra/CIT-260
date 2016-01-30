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
 * @author Daniel
 */
public class Detective implements Serializable {
    
    //class instance variables
    private String typeOfDetective;
    
    public Detective(){
    }

    public String getTypeOfDetective() {
        return typeOfDetective;
    }

    public void setTypeOfDetective(String typeOfDetective) {
        this.typeOfDetective = typeOfDetective;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.typeOfDetective);
        return hash;
    }

    @Override
    public String toString() {
        return "Detective{" + "typeOfDetective=" + typeOfDetective + '}';
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
        if (!Objects.equals(this.typeOfDetective, other.typeOfDetective)) {
            return false;
        }
        return true;
    }
    
}
