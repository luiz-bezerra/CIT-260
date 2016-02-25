/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

/**
 *
 * @author Daniel
 */
public class ExploreCityControl {
    
    public String information() {
        String description, searchForEvidence, listOfPeople, info;
        description = "\n(FILLER TEXT)";
        searchForEvidence = "\n(FILLER TEXT)";
        listOfPeople = "\n(FILLER TEXT)";
        
        info = description + searchForEvidence + listOfPeople;
        return info;
    }
    
    public void markAsVisited() {
        
        boolean visited = false; // Variable that determines whether or not a location has already been visited.
        
        if (visited == false) {
            System.out.println("markAsVisited function called.");
            visited = true;
        }
        else {
            System.out.println("You have already visited this location.");
        }
    }
}
