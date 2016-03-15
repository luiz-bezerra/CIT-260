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
public enum Actor implements Serializable{
    
    Albert("Albert Hancock, a police officer who recently started working as a detective", "Detective"),
    Jessica("Jessica Waters, Albert's partner", "Partner"),
    Nick("Nick Wright, deffense attorney", "Deffense Attorney"),
    Hudson("Hudson Connors, the first victim, a police officer who was a personal friend of Albert Hancock", "Victim"),
    Harris("Harris Sheldon, 47 years old man, suspect of killing Hudson Connors", "Suspect"),
    Tony("Tony Sumner, 20 years old man, brother of Dan Sumner, suspect of killing Hudson Connors", "Suspect"),
    Dan("Dan Sumner, 23 years old man, brother of Tony Sumner, suspect of killing Hudson Connors", "Suspect"),
    Aura("Aura Sheldon, Harris Sheldon's wife", "Witness"),
    Mark("Mark Jones, Sumner brothers' neighbor", "Witness"),
    Joan("Joan Delger, Dan Sumner's girlfriend", "Witness"),
    StoreOwner("Owner of the convenience store close to the first crime scene", "Witness");
    
    //class instance variables
    private final String description;
    private final String location;
    private final String typeOfActor;

    Actor(String description, String typeOfActor) {
        this.description = description;
        this.location = "";
        this.typeOfActor = typeOfActor;
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
