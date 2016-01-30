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

/**
 *
 * @author Daniel
 */
public class MurderInTheCity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Player test
        Player player = new Player();
        
        player.setName("Daniel Eckton");
        player.setRankAchieved("Lieutenant");
        player.setCrimesSolved(5);
        player.setTimeAsDetective(3);
        
        String playerInfo = player.toString();
        System.out.println(playerInfo);
        
        //Actor test
        Actor actor = new Actor();
        
        actor.setName("Leeroy Jenkins");
        actor.setDescription("A young detective, itching for the next big case.");
        actor.setLocation("Convenience Store");
        actor.setTypeOfActor("Detective");
        
        String actorInfo = actor.toString();
        System.out.println(actorInfo);
        
        //Suspect test
        Suspect suspect = new Suspect();
        
        suspect.setTimeAtLocation(730);
        
        String suspectInfo = suspect.toString();
        System.out.println(suspectInfo);
        
        //Alibi test
        Alibi alibi = new Alibi();
        
        alibi.setPlace("Home");
        alibi.setTime(2245);
        alibi.setCorroborator("Wife");
        alibi.setDescription("I was at my house, watching T.V. at 10:45 last night. My wife can prove it.");
        alibi.setValidated(true);
        
        String alibiInfo = alibi.toString();
        System.out.println(alibiInfo);
        
        //Victim test
        Victim victim = new Victim();
        
        victim.setTimeOfDeath(245);
        victim.setBodyTemp(91);
        victim.setTimeFound(1000);
        
        String victimInfo = victim.toString();
        System.out.println(victimInfo);
        
        //Detective test
        Detective detective = new Detective();
        
        detective.setTypeOfDetective("Partner");
        
        String detectiveInfo = detective.toString();
        System.out.println(detectiveInfo);
    }
    
}
