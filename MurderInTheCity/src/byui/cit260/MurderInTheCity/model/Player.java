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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.rankAchieved);
        hash = 23 * hash + Objects.hashCode(this.crimesSolved);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.timeAsDetective) ^ (Double.doubleToLongBits(this.timeAsDetective) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", rankAchieved=" + rankAchieved + ", crimesSolved=" + crimesSolved + ", timeAsDetective=" + timeAsDetective + '}';
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.timeAsDetective) != Double.doubleToLongBits(other.timeAsDetective)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.rankAchieved, other.rankAchieved)) {
            return false;
        }
        if (!Objects.equals(this.crimesSolved, other.crimesSolved)) {
            return false;
        }
        return true;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRankAchieved() {
        return rankAchieved;
    }

    public void setRankAchieved(String rankAchieved) {
        this.rankAchieved = rankAchieved;
    }

    public Integer getCrimesSolved() {
        return crimesSolved;
    }

    public void setCrimesSolved(Integer crimesSolved) {
        this.crimesSolved = crimesSolved;
    }

    public double getTimeAsDetective() {
        return timeAsDetective;
    }

    public void setTimeAsDetective(double timeAsDetective) {
        this.timeAsDetective = timeAsDetective;
    }
    
    
}
