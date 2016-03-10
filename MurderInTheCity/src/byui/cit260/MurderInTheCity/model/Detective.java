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
public enum Detective implements Serializable {
    
    probationalPoliceDetective(),
    policeDetective(),
    headDetective(),
    chiefOfPolice();
    
    Detective(){
    }

    @Override
    public String toString() {
        return "Detective{" + "typeOfDetective=" +/**typeOfDetective **/+ '}';
    }
    
}
