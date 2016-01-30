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
public class Alibi implements Serializable {
    
    //class instance variables
    private String place;
    private double time;
    private String corroborator;
    private String description;
    private boolean validated;
    
    public Alibi() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getCorroborator() {
        return corroborator;
    }

    public void setCorroborator(String corroborator) {
        this.corroborator = corroborator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.place);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.time) ^ (Double.doubleToLongBits(this.time) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.corroborator);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (this.validated ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Alibi{" + "place=" + place + ", time=" + time + ", corroborator=" + corroborator + ", description=" + description + ", validated=" + validated + '}';
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
        final Alibi other = (Alibi) obj;
        if (Double.doubleToLongBits(this.time) != Double.doubleToLongBits(other.time)) {
            return false;
        }
        if (this.validated != other.validated) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        if (!Objects.equals(this.corroborator, other.corroborator)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
