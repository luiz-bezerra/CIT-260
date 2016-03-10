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
public enum Actor implements Serializable{
    
    AlbertHancock(""),
    HarrisSheldon(""),
    TonyMilner(""),
    AuraMcKee(""),
    JoanDelger(""),
    DanSumner(""),
    HudsonConnors("");
    //class instance variables
    private final String description;
    private final Point location;
    private final String typeOfActor;

    Actor(String description) {
        this.description = description;
        location = new Point(1,1);
        this.typeOfActor = "Detective";
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getTypeOfActor() {
        return typeOfActor;
    }

    @Override
    public String toString() {
        return "Actor{description=" + description + ", location=" + location + ", typeOfActor=" + typeOfActor + '}';
    }
        
}
