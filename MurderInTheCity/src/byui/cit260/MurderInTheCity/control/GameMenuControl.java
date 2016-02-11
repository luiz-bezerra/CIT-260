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
public class GameMenuControl {
  
    /**
   public String showCityLocations() {
       return ;
   }
   
   public String showEvidence() {
       return ;
   }
   
   public String ShowSuspectList() {
       return ;
   }
   */
    
   public double calcTimeOfDeath(double bodyTemp, double roomTemp, double timeFound) {
       
       if (bodyTemp > 42 || bodyTemp < roomTemp) {
           return -1;
       }
       if (timeFound < 0) {
           return -1;
       }
       
       double STANDARD_TEMP = 36.5;
       double TEMP_LOST_PER_HOUR = 1.5;
       
       double timeOfDeath = timeFound - ((STANDARD_TEMP - bodyTemp)/ TEMP_LOST_PER_HOUR);
       
       return timeOfDeath;
   }
   
   public double calcSearchRadius(double speedOfTravel,double timeSinceDeath) {
       
       if (speedOfTravel < 1 || speedOfTravel > 130) {
           return -1;
       }
       
       if (timeSinceDeath < 0 || timeSinceDeath > 24) {
           return -1;
       }
       
       double searchRadius = speedOfTravel * timeSinceDeath;
       
       return searchRadius;
   }
   
   
   public boolean validateAlibi(double place,double time,double timeOfDeath,double searchRadius) {
       
       return (place <= searchRadius && time == timeOfDeath);
   }
   
   /**
   public void solveCrime() {
       
   }
   
   public void moveToLocation() {
       
   }
   
   public void exploreCity() {
       
   }
   
   public String showProfessioinalProgress() {
       return ;
   }
   
   public int showCrimesSolved() {
       return ;
   }
   
   public void showMap() {
       
   }
   
   public void showCrime() {
       
   }
   */
}
