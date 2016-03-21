/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;
import byui.cit260.MurderInTheCity.exceptions.GameMenuControlException;
import byui.cit260.MurderInTheCity.model.Crime;
import byui.cit260.MurderInTheCity.model.Evidence;
import byui.cit260.MurderInTheCity.model.Game;
import byui.cit260.MurderInTheCity.model.Map;
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
   }*/
   
   public void showEvidence() {
       // I know the following piece of code is a little redundant, since the evidence list
       // was supposed to have been created already by the createNewGame function...
       // But I'll change it later.
       // TODO: Change this later, duh.
       Evidence[] evidenceSortedList = this.sortEvidences(GameControl.createEvidenceList());
       for (Evidence evidence : evidenceSortedList) {
           System.out.println("\n" + evidence.getName() + ":");
           System.out.println("- " + evidence.getDescription());
       }
   }
   
   public Evidence[] sortEvidences(Evidence evidenceList[]) {
       
       int smallestIndex;
       String evidences[] = new String[evidenceList.length];
       String smallestEvidenceStr;
       Evidence smallestEvidence;
       
       for (int i = 0; i < evidenceList.length; i++) {
           evidences[i] = evidenceList[i].getName();
       }   
       
       for (int i = 0; i < evidenceList.length; i++) {
           smallestIndex = i;
           
           for (int j = i + 1; j < evidenceList.length; j++){
               if (evidences[j].compareToIgnoreCase(evidences[smallestIndex]) < 0)
                   smallestIndex = j;
           }
           
           smallestEvidenceStr = evidences[smallestIndex];
           smallestEvidence = evidenceList[smallestIndex];
           evidences[smallestIndex] = evidences[i];
           evidenceList[smallestIndex] = evidenceList[i];
           evidences[i] = smallestEvidenceStr;
           evidenceList[i] = smallestEvidence;
       }
       
       return evidenceList;
   }
   
   /*public String ShowSuspectList() {
       return ;
   }
   */
   long MILISSECONDS_IN_HOUR = 3600 * 1000;
   
   public String calcTimeOfDeath(double bodyTemp, double roomTemp, Date timeFound)
                    throws GameMenuControlException {
       
       // This validation is already done in the CalcTimeOfDeathView class.
       // It is still kept here for testing purposes, though.
       // I preferred to validate this data in the view class because it'll
       // be validated the moment the user enters it. It's less frustrating to
       // the player to be told to re-input the body temperature the moment
       // he/she inputs it than having him/her to input the room temperature
       // and the time the body was found and, just then, tell him/her he/she
       // did it wrong. I'll do the same in the CalcSearchRadius function later.
       if (bodyTemp > 42) {
           throw new GameMenuControlException("Body temperature too high");
       }
       else if (bodyTemp < roomTemp) {
           throw new GameMenuControlException("Body temperature too low");
       }
       
       DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       double STANDARD_TEMP = 36.5;
       double TEMP_LOST_PER_HOUR = 1.5;
       
       long hoursAgo = (long)((STANDARD_TEMP - bodyTemp)/ TEMP_LOST_PER_HOUR);
       Date timeOfDeath = new Date(timeFound.getTime() - hoursAgo * MILISSECONDS_IN_HOUR);
       
       return "The time of death is " + dateFormat.format(timeOfDeath);
   }
   
   /*public double calcSearchRadius(double speedOfTravel, double timeSinceDeath) {
       
       if (speedOfTravel <= 0 || speedOfTravel > 130) {
           return -1;
       }
       
       if (timeSinceDeath < 0 || timeSinceDeath > 24) {
           return -1;
       }
       
       double searchRadius = speedOfTravel * timeSinceDeath;
       
       return searchRadius;
   }*/
   
   public double calcSearchRadius(double speedOfTravel, String currentTimeStr, String timeOfDeathStr)
                    throws GameMenuControlException {
       
       if (speedOfTravel > 200 || speedOfTravel <= 0)
           throw new GameMenuControlException("Speed of travel should be between 0 and 200");
       
       DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
       Date currentTime, timeOfDeath;
       
       try
       {
           currentTime = dateFormat.parse(currentTimeStr);
           timeOfDeath = dateFormat.parse(timeOfDeathStr);
       }
       catch(Exception ex)
       {
           throw new GameMenuControlException("Invalid time input");
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
       Game game = new Game();
       MurderInTheCity.setCurrentGame(game);
       
       game.setPlayer(player);
       
       Map map = MapControl.createMap();
       game.setMap(map);
       
       Crime[] crime = GameControl.createCrime();
       game.setCrime(crime);
       
       
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
