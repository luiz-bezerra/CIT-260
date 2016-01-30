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

/**
 *
 * @author Daniel and Luiz
 */
public class MurderInTheCity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        // Test string for classes
        String classInfo;

        // Testing the Player class
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
        
        classInfo = player.toString();
        System.out.println(classInfo);
        
        // Testing the Game class
        Game game = new Game();
        
        game.setSavedGame(2);
        
        classInfo = game.toString();
        System.out.println(classInfo);
        
        // Testing the Map class
        Map map = new Map();
        
        map.setLocationCount(7);
        
        classInfo = map.toString();
        System.out.println(classInfo);
        
        // Testing the Location class
        Location location = new Location();
        
        location.setVisited(true);
        location.setName("Zoo Manager Office");
        location.setDescription("The victim boss' office.");
        location.setDistanceFromCrime(2.9);
        location.setParentLocation("City Zoo");
        
        classInfo = location.toString();
        System.out.println(classInfo);
        
        // Testing the DefenseAttorneyOffice class
        DefenseAttorneyOffice office = new DefenseAttorneyOffice();
        
        office.setSolve(false);
        office.setEvidence("Fingerprints");
        office.setSuspect("Sterling Meyers");
        
        classInfo = office.toString();
        System.out.println(classInfo);
        
        // Testing the Crime class
        Crime crime = new Crime();
        
        crime.setCrimeType("Murder");
        crime.setCrimePlace("Pet Shop");
        crime.setCrimeVictim("Luiz Bezerra");
        crime.setCrimeOffender("Unknown");
        crime.setSolved(false);
        
        classInfo = crime.toString();
        System.out.println(classInfo);
        
        // Testing the CrimeScene class
        CrimeScene crimeScene = new CrimeScene();
        
        crimeScene.setWitnesses(2);
        crimeScene.setTemperature(76.9);
        
        classInfo = crimeScene.toString();
        System.out.println(classInfo);
        
        // Testing the Evidence class
        Evidence evidence = new Evidence();
        
        evidence.setDescription("Fingerprints found on the murder weapon");
        evidence.setLocationCollected("Dumpster near the crime scene");
        
        classInfo = evidence.toString();
        System.out.println(classInfo);
//>>>>>>> origin/master
    }
    
}
