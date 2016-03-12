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
public class Player implements Serializable {
    
    //class instance variables
    private String name;
    private String rankAchieved;
    private Integer crimesSolved;
    private double timeAsDetective;

    public Player() {
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
