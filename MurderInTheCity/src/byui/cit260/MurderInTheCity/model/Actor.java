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
    
    Albert("Albert Hancock, a police officer who recently started working as a detective"),
    Jessica("Jessica Waters, Albert's partner"),
    Nick("Nick Wright, deffense attorney"),
    Hudson("Hudson Connors, the first victim, a police officer who was a personal friend of Albert Hancock"),
    Harris("Harris Sheldon, 47 years old man, suspect of killing Hudson Connors"),
    Tony("Tony Sumner, 20 years old man, brother of Dan Sumner, suspect of killing Hudson Connors"),
    Dan("Dan Sumner, 23 years old man, brother of Tony Sumner, suspect of killing Hudson Connors"),
    Aura("Aura Sheldon, Harris Sheldon's wife"),
    Mark("Mark Jones, Sumner brothers' neighbor"),
    Joan("Joan Delger, Dan Sumner's girlfriend"),
    StoreOwner("Owner of the convenience store close to the first crime scene");
    
    //class instance variables
    private final String description;
    private final String location;
    private final String typeOfActor;

    Actor(String description) {
        this.description = description;
        location = "Office";
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
