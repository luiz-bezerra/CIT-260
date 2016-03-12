/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import byui.cit260.MurderInTheCity.model.Crime;
import byui.cit260.MurderInTheCity.model.Evidence;
import byui.cit260.MurderInTheCity.model.Game;
import byui.cit260.MurderInTheCity.model.Map;
import byui.cit260.MurderInTheCity.model.Player;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author Daniel
 */
public class GameControl {
    
    public static void createNewGame(Player player) {
        Game game = new Game();
       MurderInTheCity.setCurrentGame(game);
       
       game.setPlayer(player);
       
       Map map = MapControl.createMap();
       game.setMap(map);
       
       Crime[] crime = GameControl.createCrime();
       game.setCrime(crime);
       
       Evidence[] evidence = GameControl.createEvidenceList();
       game.setEvidence(evidence);
    }
    
    public static Crime[] createCrime() {
        System.out.println("createCrime function called.");
        return null;
    }
    
    public static Evidence[] createEvidenceList() {
        Evidence[] evidence = new Evidence[7];
        
        Evidence knife = evidence[0];
        evidence[knife.ordinal()] = knife;
        evidence[0] = knife;
        
        Evidence gun = evidence[1];
        evidence[gun.ordinal()] = gun;
        evidence[1] = gun;
        
        Evidence bullet = evidence[2];
        evidence[bullet.ordinal()] = bullet;
        evidence[2] = bullet;
        
        Evidence bulletCasing = evidence[3];
        evidence[bulletCasing.ordinal()] = bulletCasing;
        evidence[3] = bulletCasing;
        
        Evidence brokenGlass = evidence[4];
        evidence[brokenGlass.ordinal()] = brokenGlass;
        evidence[4] = brokenGlass;
        
        Evidence leadPipe = evidence[5];
        evidence[leadPipe.ordinal()] = leadPipe;
        evidence[5] = leadPipe;
        
        Evidence bloodyHammer = evidence[6];
        evidence[bloodyHammer.ordinal()] = bloodyHammer;
        evidence[6] = bloodyHammer;
        
        return evidence;
    }
    
}
