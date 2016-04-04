/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;
import byui.cit260.MurderInTheCity.exceptions.GameMenuControlException;
import byui.cit260.MurderInTheCity.model.Alibi;
import byui.cit260.MurderInTheCity.model.Evidence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import byui.cit260.MurderInTheCity.model.Player;
import byui.cit260.MurderInTheCity.model.Scene;
import byui.cit260.MurderInTheCity.model.SceneType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void printEvidenceReport(ArrayList<Evidence> evidenceList, String output) {
        try (PrintWriter out = new PrintWriter(output)) {
            out.println("\n\nEvidence Report");
            out.printf("%n%-40s%-100s", "Name", "Description");
            out.printf("%n%-40s%100s", "----------------------------------------", "----------------------------------------------------------------------------------------------------");
             
            for (Evidence evidence : evidenceList) {
                out.printf("%n%-40s%-100s", evidence.getName(), evidence.getDescription());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameMenuControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printAlibiReport(Alibi[] alibiList, String output) {
        try (PrintWriter out = new PrintWriter(output)) {
            out.printf("%-46s%-58s", "", "ALIBI REPORT");
            out.printf("%n%-9s%-15s%-80s", "---------", "---------------", "--------------------------------------------------------------------------------");
            out.printf("%n%-9s%-15s%-80s", "Time", "Corroborator", "Description");
            out.printf("%n%-9s%-15s%-80s", "---------", "---------------", "--------------------------------------------------------------------------------");
             
            for (Alibi alibi : alibiList) {
                out.printf("%n%-9s%-15s%-80s", alibi.getTime(), alibi.getCorroborator(), alibi.getDescription());
            }
        }        
        catch (IOException ioEx) {
            System.out.println("IO Error printing report:\n" + ioEx.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error printing report:\n" + ex.getMessage());
        }
    }
    
    public String showEvidence() {
        ArrayList<Evidence> evidences = MurderInTheCity.getCurrentGame().getEvidence();
        String evidenceList =
                    "\n----------------------------------------------" +
                    "\n  Evidence List                               " +
                    "\n----------------------------------------------";
        
        for (Evidence evidence : evidences) {
            if (!evidence.getLocationCollected().equals(""))
                evidenceList += "\n" + evidence.getName() + ":"
                              + "\n- " + evidence.getDescription() + "\n";
        }
        
        //Seeing evidences triggers continuing the first scene
        Scene[] scene = MurderInTheCity.getCurrentGame().getScene();
        
        if (!scene[SceneType.EvidenceTutorial.ordinal()].getCompleted())
            MurderInTheCity.setSkipScene(true);
        
        return evidenceList;
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
   
   /*public static void createNewGame(Player player) {
       Game game = new Game();
       MurderInTheCity.setCurrentGame(game);
       
       game.setPlayer(player);
       
       Map map = MapControl.createMap();
       game.setMap(map);
       
       Crime[] crime = GameControl.createCrime();
       game.setCrime(crime);
       
       Scene[] scene = GameControl.createScenes();
       game.setScene(scene);
   }*/
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