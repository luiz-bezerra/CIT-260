/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murderinthecity;

import byui.cit260.MurderInTheCity.model.Player;
import byui.cit260.MurderInTheCity.model.Actor;
import byui.cit260.MurderInTheCity.model.Suspect;
import byui.cit260.MurderInTheCity.model.Alibi;
import byui.cit260.MurderInTheCity.model.Victim;
import byui.cit260.MurderInTheCity.model.Detective;
import byui.cit260.MurderInTheCity.model.Game;
import byui.cit260.MurderInTheCity.model.Map;
import byui.cit260.MurderInTheCity.model.Location;
import byui.cit260.MurderInTheCity.model.DefenseAttorneyOffice;
import byui.cit260.MurderInTheCity.model.Crime;
import byui.cit260.MurderInTheCity.model.CrimeScene;
import byui.cit260.MurderInTheCity.model.Evidence;
import byui.cit260.MurderInTheCity.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel and Luiz
 */
public class MurderInTheCity {

    /**
     * @param args the command line arguments
     */
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    private static boolean skipScene = false;
    
    public static boolean getSkipScene() {
        return skipScene;
    }
    
    public static void setSkipScene(boolean skipScene) {
        MurderInTheCity.skipScene = skipScene;
    }
    
    public static Game getCurrentGame() {
        return currentGame;
    }
    
    public static void setCurrentGame(Game currentGame) {
        MurderInTheCity.currentGame = currentGame;
    }
    
    public static Player getPlayer() {
        return player;
    }
    
    public static void setPlayer(Player player) {
        MurderInTheCity.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        MurderInTheCity.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        MurderInTheCity.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        MurderInTheCity.logFile = logFile;
    }
    
    public static void main(String[] args) {

        
        try {
                       
            MurderInTheCity.inFile = new BufferedReader(new InputStreamReader(System.in));
            
            MurderInTheCity.outFile = new PrintWriter(System.out, true);
            
            String filePath = "log.txt";
            MurderInTheCity.logFile = new PrintWriter(filePath);
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();           
            
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        } finally {
            try {
                if (MurderInTheCity.inFile != null)
                    MurderInTheCity.inFile.close();
                if (MurderInTheCity.outFile != null)
                    MurderInTheCity.outFile.close();
                if (MurderInTheCity.logFile != null)
                    MurderInTheCity.logFile.close();
            } catch (IOException ex) {
                Logger.getLogger(MurderInTheCity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
