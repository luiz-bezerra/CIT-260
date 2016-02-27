/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import byui.cit260.MurderInTheCity.model.Player;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author Daniel and Luiz
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
   long MILISSECONDS_IN_HOUR = 3600 * 1000;
   
   public String calcTimeOfDeath(double bodyTemp, double roomTemp, Date timeFound) {
       
       // This validation is already done in the CalcTimeOfDeathView class
       // It is still kept here for testing purposes, though.
       if (bodyTemp > 42) {
           return "Body temperature too high";
       }
       else if (bodyTemp < roomTemp) {
           return "Body temperature too low";
       }
       
       /*DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       Date timeFound;
       
       try
       {
           timeFound = dateFormat.parse(timeFoundStr);
       }
       catch(Exception ex)
       {
           return "Invalid time found";
       }*/
       
       DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       double STANDARD_TEMP = 36.5;
       double TEMP_LOST_PER_HOUR = 1.5;
       
       long hoursAgo = (long)((STANDARD_TEMP - bodyTemp)/ TEMP_LOST_PER_HOUR);
       Date timeOfDeath = new Date(timeFound.getTime() - hoursAgo * MILISSECONDS_IN_HOUR);
       
       return "The time of death is " + dateFormat.format(timeOfDeath);
   }
   
   public double calcSearchRadius(double speedOfTravel, double timeSinceDeath) {
       
       if (speedOfTravel <= 0 || speedOfTravel > 130) {
           return -1;
       }
       
       if (timeSinceDeath < 0 || timeSinceDeath > 24) {
           return -1;
       }
       
       double searchRadius = speedOfTravel * timeSinceDeath;
       
       return searchRadius;
   }
   
   public double calcSearchRadius_Luiz(double speedOfTravel, String currentTimeStr, String timeOfDeathStr){
       
       if (speedOfTravel > 200 || speedOfTravel <= 0)
           return -1;
       
       DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       Date currentTime, timeOfDeath;
       
       try
       {
           currentTime = dateFormat.parse(currentTimeStr);
           timeOfDeath = dateFormat.parse(timeOfDeathStr);
       }
       catch(Exception ex)
       {
           return -1;
       }
       
       return (currentTime.getTime() - timeOfDeath.getTime()) / MILISSECONDS_IN_HOUR * speedOfTravel;
   }           
   
   public boolean validateAlibi(double place, double time, double timeOfDeath, double searchRadius) {
       
       return (place <= searchRadius && time == timeOfDeath);
   }
   
   public static Player createPlayer(String playerName) {
       
       if (playerName == null) {
           return null;
       }
       
       Player player = new Player();
       player.setName(playerName);
       
       MurderInTheCity.setPlayer(player);
       
       return player;
   }
   
   public static void createNewGame(Player player) {
       System.out.println("\ncreateNewGame function called.");
   }
   /**
   public void solveCrime() {
       
   }
   
   public void moveToLocation() {
       
   }
   */
   
   
   public void exploreCity() {
       
   }
   
   /**
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
