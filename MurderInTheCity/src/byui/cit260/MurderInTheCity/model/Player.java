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
public enum Player implements Serializable {
    
    probationalPoliceDetective(0),
    policeDetective(4),
    headDetective(6),
    chiefOfPolice(12);
    
    //class instance variables
    private String name;
    private Integer crimesSolved;
    private double timeAsDetective;

    Player(Integer crimesSolved) {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCrimesSolved() {
        return crimesSolved;
    }

    public double getTimeAsDetective() {
        return timeAsDetective;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", rankAchieved=" /**+ rankAchieved**/ + ", crimesSolved=" + crimesSolved + ", timeAsDetective=" + timeAsDetective + '}';
    }
    
}
