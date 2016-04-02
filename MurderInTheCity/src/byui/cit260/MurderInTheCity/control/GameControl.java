/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import byui.cit260.MurderInTheCity.exceptions.GameControlExceptions;
import byui.cit260.MurderInTheCity.model.Crime;
import byui.cit260.MurderInTheCity.model.Evidence;
import byui.cit260.MurderInTheCity.model.Alibi;
import byui.cit260.MurderInTheCity.model.Game;
import byui.cit260.MurderInTheCity.model.Location;
import byui.cit260.MurderInTheCity.model.Map;
import byui.cit260.MurderInTheCity.model.PiecesOfEvidence;
import byui.cit260.MurderInTheCity.model.Player;
import byui.cit260.MurderInTheCity.model.Scene;
import byui.cit260.MurderInTheCity.model.SceneType;
import byui.cit260.MurderInTheCity.model.Suspect;
import byui.cit260.MurderInTheCity.model.SuspectName;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author Daniel
 */
public class GameControl {
    
    public static void createNewGame(Player player) {
       Game game = new Game();
       //MurderInTheCity.setCurrentGame(game);
       
       game.setPlayer(player);
       
       Map map = MapControl.createMap();
       game.setMap(map);
       
       Evidence[] evidence = GameControl.createEvidenceList();
       game.setEvidence(evidence);
       
       Alibi[] alibi = GameControl.createAlibiList();
       game.setAlibi(alibi);
       
       Scene[] scene = GameControl.createScenes();
       game.setScene(scene);
       
       Location[][] locations = GameControl.createLocations();
       Crime[] crime = GameControl.createCrime(alibi);
       game.setCrime(crime);
       
//>>>>>>> origin/master
       
       MurderInTheCity.setCurrentGame(game);
    }
    
    public static Crime[] createCrime(Alibi[] alibi) {
        Crime[] crime = new Crime[1];
        
        Crime firstCrime = new Crime();
        firstCrime.setCrimeOffender("Tony Sumner");
        firstCrime.setCrimePlace("Park");
        firstCrime.setSolved(false);
        firstCrime.setSuspect(GameControl.createSuspectList(alibi));
        crime[0] = firstCrime;
        
        return crime;
    }
    
    public static Suspect[] createSuspectList(Alibi[] alibi) {
        Suspect[] suspect = new Suspect[3];
        
        Suspect harrisSheldon = new Suspect();
        harrisSheldon.setName("Harris Sheldon");
        harrisSheldon.setAlibi(alibi[SuspectName.HarrisSheldon.ordinal()]);
        harrisSheldon.setTimeAtLocation(0);
        suspect[SuspectName.HarrisSheldon.ordinal()] = harrisSheldon;
        
        Suspect tonySumner = new Suspect();
        tonySumner.setName("Tony Sumner");
        tonySumner.setAlibi(alibi[SuspectName.TonySumner.ordinal()]);
        tonySumner.setTimeAtLocation(0);
        suspect[SuspectName.TonySumner.ordinal()] = tonySumner;
        
        Suspect danSumner = new Suspect();
        danSumner.setName("Dan Sumner");
        danSumner.setAlibi(alibi[SuspectName.DanSumner.ordinal()]);
        danSumner.setTimeAtLocation(0);
        suspect[SuspectName.DanSumner.ordinal()] = danSumner;
        
        return suspect;
    }
    
    public static Evidence[] createEvidenceList() {
        Evidence[] evidence = new Evidence[11];
        
        Evidence autopsyResults = new Evidence();
        autopsyResults.setName("Autopsy results");
        autopsyResults.setDescription("death by head trauma due to two blows received on the head");
        autopsyResults.setLocationCollected("???");
        evidence[PiecesOfEvidence.AutopsyResults.ordinal()] = autopsyResults;
        
        Evidence bloodyHammer = new Evidence();
        bloodyHammer.setName("Bloody hammer");
        bloodyHammer.setDescription("confirmed to have been the murder weapon");
        bloodyHammer.setLocationCollected("Park");
        evidence[PiecesOfEvidence.BloodyHammer.ordinal()] = bloodyHammer;
        
        Evidence harrisFingerprints = new Evidence();
        harrisFingerprints.setName("Harris Sheldon's fingerprints");
        harrisFingerprints.setDescription("Fingerprints of Harris Sheldon found on the murder weapon");
        harrisFingerprints.setLocationCollected("Park");
        evidence[PiecesOfEvidence.HarrisFingerprints.ordinal()] = harrisFingerprints;
        
        Evidence tonyFingerprints = new Evidence();
        tonyFingerprints.setName("Tony Sumner's fingerprints");
        tonyFingerprints.setDescription("Fingerprints of Tony Sumner found on the murder weapon");
        tonyFingerprints.setLocationCollected("Park");
        evidence[PiecesOfEvidence.TonyFingerprints.ordinal()] = tonyFingerprints;
        
        Evidence danFingerprints = new Evidence();
        danFingerprints.setName("Dan Sumner's fingerprints");
        danFingerprints.setDescription("Fingerprints of Dan Sumner found on the murder weapon");
        danFingerprints.setLocationCollected("Park");
        evidence[PiecesOfEvidence.DanFingerprints.ordinal()] = danFingerprints;
        
        Evidence auraTestimony = new Evidence();
        auraTestimony.setName("Aura Sheldon's testimony");
        auraTestimony.setDescription("Harris Sheldon was watching TV with her around 10 PM");
        auraTestimony.setLocationCollected("");
        evidence[PiecesOfEvidence.AuraTestimony.ordinal()] = auraTestimony;
        
        Evidence markTestimony = new Evidence();
        markTestimony.setName("Mark Jones' testimony");
        markTestimony.setDescription("Tony Sumner was running shirtless around 10 PM");
        markTestimony.setLocationCollected("");
        evidence[PiecesOfEvidence.MarkTestimony.ordinal()] = markTestimony;
        
        Evidence joanTestimony = new Evidence();
        joanTestimony.setName("Joan Delger's testimony");
        joanTestimony.setDescription("Dan Sumner was at the movies with her at 10 PM");
        joanTestimony.setLocationCollected("");
        evidence[PiecesOfEvidence.JoanTestimony.ordinal()] = joanTestimony;
        
        Evidence storeOwnerTestimony = new Evidence();
        storeOwnerTestimony.setName("Convenience store owner's testimony");
        storeOwnerTestimony.setDescription("no vehicles passed by that place since 9 PM");
        storeOwnerTestimony.setLocationCollected("");
        evidence[PiecesOfEvidence.StoreOwnerTestimony.ordinal()] = storeOwnerTestimony;
        
        Evidence bloodyShirt = new Evidence();
        bloodyShirt.setName("Blood stained T-shirt");
        bloodyShirt.setDescription("found in the Sumner brothers' house and confirmed to be stained with the blood of the victim");
        bloodyShirt.setLocationCollected("");
        evidence[PiecesOfEvidence.BloodyShirt.ordinal()] = bloodyShirt;
        
        Evidence joanDanSelfie = new Evidence();
        joanDanSelfie.setName("Joan and Dan's selfie");
        joanDanSelfie.setDescription("selfie taken in the night of the murder, proving Dan Sumner was wearing a gray T-shirt");
        joanDanSelfie.setLocationCollected("");
        evidence[PiecesOfEvidence.JoanDanSelfie.ordinal()] = joanDanSelfie;
        
        return evidence;
    }
    
    public static Alibi[] createAlibiList() {
        Alibi[] alibi = new Alibi[3];
        
        Alibi harrisAlibi = new Alibi();
        harrisAlibi.setTime("");
        harrisAlibi.setDescription(
                        "Harris Sheldon was watching TV \n     " +
                        "home with his wife");
        harrisAlibi.setCorroborator("Aura Sheldon");
        alibi[SuspectName.HarrisSheldon.ordinal()] = harrisAlibi;
        
        Alibi tonyAlibi = new Alibi();
        tonyAlibi.setTime("");
        tonyAlibi.setDescription(
                        "Tony Sumner was running close to \n     " +
                        "his house, practicing for a marathon");
        tonyAlibi.setCorroborator("Mark Jones");
        alibi[SuspectName.TonySumner.ordinal()] = tonyAlibi;
        
        Alibi danAlibi = new Alibi();
        danAlibi.setTime("");
        danAlibi.setDescription(
                        "Dan Sumner was at the movies with \n     " +
                        "his girlfriend");
        danAlibi.setCorroborator("Joan Delger");
        alibi[SuspectName.DanSumner.ordinal()] = danAlibi;
        
        return alibi;
    }

//<<<<<<< HEAD
    
//=======
    public static void saveGame(Game currentGame, String filePath) throws GameControlExceptions {
//>>>>>>> origin/master
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(currentGame);
        }
        catch(Exception ex) {
            throw new GameControlExceptions(ex.getMessage());
        }
    }

    public static void getSavedGame(String filePath) throws GameControlExceptions {
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        }
        catch(Exception ex) {
            throw new GameControlExceptions(ex.getMessage());
        }
        MurderInTheCity.setCurrentGame(game);
    }
    
    public static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene intro = new Scene();
        intro.setDescription(
                "\n------------------------------------------------------------"
              + "\n|                  CASE #1: FALL AND RISE                  |"
              + "\n------------------------------------------------------------"
              + "\n"
              + "\nIn a friday night, police officer Albert Hancock found the "
              + "\ndead body of his friend, Hudson Connors, who was a fellow "
              + "\npolice officer, in a park. His head had received 2 severe "
              + "\nblows: one on the right temple and one on the back."
              + "\n"
              + "\nAfter reinforcements arrived, Albert felt he should take a "
              + "\nlook at the convenience store across the street. After "
              + "\npatrolling the small parking lot, he went inside and asked "
              + "\nthe owner if he had seen or heard anything unusual, and he "
              + "\ndenied. Albert bought a donut, since he is used to eat "
              + "\nsweets to relieve stress."
              + "\n"
              + "\nOn his way back to the park, he went to throw the donut "
              + "\nwrapper away in a trash can, but something unusual picked "
              + "\nhis attention: there was a hammer handle inside. He picked "
              + "\nit and found that the head of the hammer was stained with "
              + "\nblood. He presented it for analysis."
              + "\n"
              + "\nAfter sending the hammer for analysis, it was discovered "
              + "\nthat the DNA of the blood found on it matched the victim's, "
              + "\nso it was confirmed to be the murder weapon."
              + "\n"
              + "\nThe hammer had 3 different sets of fingerprints, belonging "
              + "\nto 47 years old Harris Sheldon, to 20 years old Tony Sumner "
              + "\nand his 23 years old brother, Dan Sumner. Thus, they were "
              + "\nruled as initial suspects and detained."
              + "\n"
              + "\nAlbert's superiors were impressed that he found so many "
              + "\nclues just by intuition, and thus decided to give him the "
              + "\nchance of further investigating that crime, since he always "
              + "\nwanted to work as a detective and the victim was his friend."
              + "\nThey assigned a partner to work with him, Jessica Waters."
              + "\n");
        //scenes.setLocation(Park);
        intro.setCompleted(false);
        scenes[SceneType.Intro.ordinal()] = intro;
        
        Scene evidenceTutorial = new Scene();
        evidenceTutorial.setDescription(
                "\n------------------------------------------------------------"
              + "\n| Current Location: Police Station                         |"
              + "\n------------------------------------------------------------"
              + "\n"
              + "\nJessica: Hello, Albert! Excited for your first day as a"
              + "\ndetective?"
              + "\n"
              + "\nAlbert: It's odd... I always wanted to be a detective,"
              + "\nbut..."
              + "\n"
              + "\nJessica: ..."
              + "\n"
              + "\nJessica: Don't worry, I understand. The victim was your"
              + "\nfriend after all... But you can be sure: we will catch the"
              + "\none who did it and will see him beyond bars soon."
              + "\n"
              + "\nAlbert: That's right! That's why we're here!"
              + "\n"
              + "\nJessica: So, why don't we start by looking at the pieces of"
              + "\nevidence we've gathered so far? You can see them in your"
              + "\ntablet. Just press 'O' to turn it on and then press 'L'"
              + "\nto check the evidences."
              + "\n");
        //scenes.setLocation(PoliceStation);
        evidenceTutorial.setCompleted(false);
        scenes[SceneType.EvidenceTutorial.ordinal()] = evidenceTutorial;
        
        Scene evidenceTutorialTalk = new Scene();
        evidenceTutorialTalk.setDescription(
                "\nJessica: Please, take a look at the evidence list before we"
              + "\nmove on."
              + "\n");
        //scenes.setLocation(PoliceStation);
        evidenceTutorialTalk.setCompleted(false);
        scenes[SceneType.EvidenceTutorialTalk.ordinal()] = evidenceTutorialTalk;
        
        Scene alibiTutorial = new Scene();
        alibiTutorial.setDescription(
                "\nJessica: As you can see, we have three men detained here as"
              + "\nsuspects of the crime. Let's talk to 'em and hear what they"
              + "\nhave to say."
              + "\n"
              + "\nAlbert and Jessica go to a small room inside that police"
              + "\nstation."
              + "\n"
              + "\nJessica: Are you ready for the interviews? Just press 'T' to"
              + "\nstart talking."
              + "\n");
        //scenes.setLocation(PoliceStation);
        alibiTutorial.setCompleted(false);
        scenes[SceneType.AlibiTutorial.ordinal()] = alibiTutorial;
        
        Scene alibiTutorialTalk = new Scene();
        alibiTutorialTalk.setDescription(
                "\nJessica: Which suspect would you like to talk to first? Just"
              + "\npress the number of the person."
              + "\n");
        //scenes.setLocation(PoliceStation);
        alibiTutorialTalk.setCompleted(false);
        scenes[SceneType.AlibiTutorialTalk.ordinal()] = alibiTutorialTalk;
        
        Scene harrisSheldonAlibi = new Scene();
        harrisSheldonAlibi.setDescription(
                "\nJessica: Ok, I'll bring Mr. Sheldon, then."
              + "\n"
              + "\nAfter a short time, a middle-aged man comes and sits on the"
              + "\nchair in front of Albert. Albert questioned him about the"
              + "\nnight of the crime."
              + "\n"
              + "\nMr. Sheldon: It wasn't me! I was home all that night,"
              + "\nwatching a movie with my wife!"
              + "\n"
              + "\nAlbert: So, how do you explain your fingerprints on the"
              + "\nmurder weapon?"
              + "\n"
              + "\nMr. Sheldon: They told me it was a hammer, right? Well, I"
              + "\nhad lent my hammer to Dan Sumner that same day, so, of"
              + "\ncourse my fingerprints were on it!"
              + "\n"
              + "\nAlbert: Hum... ok, then. Thank you for your cooperation."
              + "\n"
              + "Mr. Sheldon is escorted back to his cell."
              + "\n"
              + "\nJessica: Mr. Sheldon's alibi was added to your list. You can"
              + "\nsee it anytime, by turning on your tablet and pressing 'S'"
              + "\n"
              + "\nAlbert: Ok, thanks!"
              + "\n"
              + "\nJessica: Who would you like to interview now?"
              + "\n");
        //scenes.setLocation(PoliceStation);
        harrisSheldonAlibi.setCompleted(false);
        scenes[SceneType.HarrisSheldonAlibi.ordinal()] = harrisSheldonAlibi;
        
        Scene tonySumnerAlibi = new Scene();
        tonySumnerAlibi.setDescription(
                "\nJessica: Ok, I'll bring Tony Sumner, then."
              + "\n"
              + "\nAfter a short time, a young and athletic-looking man comes"
              + "\nand sits on the chair in front of Albert. Albert questioned"
              + "\nhim about the night of the crime."
              + "\n"
              + "\nTony: Well, I was running on my street that night. I'm"
              + "\npreparing for a marathon, you know, and since it's pretty"
              + "\nhot lately, I decided to run after the sunset. If you don't"
              + "\nbelieve me, you can ask my neighbor, he saw me running!"
              + "\n"
              + "\nAlbert: If that's true, why did we find your fingerprints on"
              + "\nthe murder weapon?"
              + "\n"
              + "\nTony: I used a hammer I found home to nail a picture in the"
              + "\nwall earlier that day, but didn't use it for anything later."
              + "\n"
              + "\nAlbert: Ok, then. Thank you for your cooperation."
              + "\n"
              + "Tony is escorted back to his cell."
              + "\n"
              + "\nJessica: Tony Sumner's alibi was added to your list. You can"
              + "\nsee it anytime, by turning on your tablet and pressing 'S'"
              + "\n"
              + "\nAlbert: Ok, thanks!"
              + "\n"
              + "\nJessica: Who would you like to interview now?"
              + "\n");
        //scenes.setLocation(PoliceStation);
        tonySumnerAlibi.setCompleted(false);
        scenes[SceneType.TonySumnerAlibi.ordinal()] = tonySumnerAlibi;
        
        Scene danSumnerAlibi = new Scene();
        danSumnerAlibi.setDescription(
                "\nJessica: Ok, I'll bring Dan Sumner, then."
              + "\n"
              + "\nAfter a short time, a young and strong-looking man comes and"
              + "\nsits on the chair in front of Albert. Albert questioned him"
              + "\nabout the night of the crime."
              + "\n"
              + "\nDan: I left home that night to go to the movies with my"
              + "\ngirlfriend. The movie started at 9:30 PM and ended around"
              + "\n11:30 PM, so, it can't have been me!"
              + "\n"
              + "\nAlbert: If that's true, why did we find your fingerprints on"
              + "\nthe murder weapon?"
              + "\n"
              + "\nDan: Well, I work as a woodworker, and I asked my boss if I"
              + "\ncould borrow his hammer, because I needed to fix a wooden"
              + "\nchair back home."
              + "\n"
              + "\nAlbert: Alright. Thank you for your cooperation."
              + "\n"
              + "Dan is escorted back to his cell."
              + "\n"
              + "\nJessica: Dan Sumner's alibi was added to your list. You can"
              + "\nsee it anytime, by turning on your tablet and pressing 'S'"
              + "\n"
              + "\nAlbert: Ok, thanks!"
              + "\n"
              + "\nJessica: Who would you like to interview now?"
              + "\n");
        //scenes.setLocation(PoliceStation);
        danSumnerAlibi.setCompleted(false);
        scenes[SceneType.DanSumnerAlibi.ordinal()] = danSumnerAlibi;
        
        Scene moveToLocationTutorial = new Scene();
        moveToLocationTutorial.setDescription(
                "\nJessica: All our suspects had an alibi and they say they"
              + "\neven have witnesses to corroborate with their alibis..."
              + "\n"
              + "\nAlbert: Well, let's talk to those witnesses, then. See if"
              + "\ntheir accounts match. I also want to talk to the owner of"
              + "\nthat convenience store close to the crime scene once more..."
              + "\nI feel like I can get some more information from him."
              + "\n"
              + "\nJessica: Agreed. So, we are going to talk to Mrs. Sheldon,"
              + "\nto the Sumner Brothers' neighbor - a man called Mark Jones -"
              + "\nto Dan Sumner's girlfriend, whose name is Joan Delger, and"
              + "\nto the convenience store owner."
              + "\n"
              + "\nAlbert: That's right."
              + "\n"
              + "\nJessica: So, just press 'M' and choose where you want to go"
              + "\nfirst."
              + "\n");
        //scenes.setLocation(Po0liceStation);
        moveToLocationTutorial.setCompleted(false);
        scenes[SceneType.MoveToLocationTutorial.ordinal()] = moveToLocationTutorial;
        
        Scene moveToLocationTutorialTalk = new Scene();
        moveToLocationTutorialTalk.setDescription(
                "\nJessica: Let's talk to the alibi corroborators!"
              + "\n");
        //scenes.setLocation(PoliceStation);
        moveToLocationTutorialTalk.setCompleted(false);
        scenes[SceneType.MoveToLocationTutorialTalk.ordinal()] = moveToLocationTutorialTalk;
        
        return scenes;
    }
    
    public static Location[][] createLocations() {
        Location[][] locations = new Location[2][6];
        
        Location policeStation = new Location();
        policeStation.setRow(0);
        policeStation.setColumn(0);
        policeStation.setDescription("Police Station");
        policeStation.setVisited(false);
      /*policeStation.setDistanceFromCrime(0);
        policeStation.setParentLocation(parentLocation);
        policeStation.setScene(scene);*/
        locations[0][0] = policeStation;
        
        
        Location daOffice = new Location();
        daOffice.setRow(0);
        daOffice.setColumn(1);
        daOffice.setDescription("Defense Attourney's Office");
        daOffice.setVisited(false);
      /*daOffice.setDistanceFromCrime(0);
        daOffice.setParentLocation(parentLocation);
        daOffice.setScene(scene);*/
        locations[0][1] = daOffice;
        
        Location park = new Location();
        park.setRow(1);
        park.setColumn(0);
        park.setDescription("Addison Park");
        park.setVisited(false);
      /*park.setDistanceFromCrime(0);
        park.setParentLocation(parentLocation);
        park.setScene(scene);*/
        locations[1][0] = park;
        
        Location store = new Location();
        store.setRow(1);
        store.setColumn(1);
        store.setDescription("Convenience Store");
        store.setVisited(false);
      /*store.setDistanceFromCrime(0);
        store.setParentLocation(parentLocation);
        store.setScene(scene);*/
        locations[1][1] = store;
        
        Location sheldonHouse = new Location();
        sheldonHouse.setRow(1);
        sheldonHouse.setColumn(2);
        sheldonHouse.setDescription("Sheldon Family House");
        sheldonHouse.setVisited(false);
      /*sheldonHouse.setDistanceFromCrime(0);
        sheldonHouse.setParentLocation(parentLocation);
        sheldonHouse.setScene(scene);*/
        locations[1][2] = sheldonHouse;
        
        Location jonesHouse = new Location();
        jonesHouse.setRow(1);
        jonesHouse.setColumn(3);
        jonesHouse.setDescription("Mark Jones' House");
        jonesHouse.setVisited(false);
      /*jonesHouse.setDistanceFromCrime(0);
        jonesHouse.setParentLocation(parentLocation);
        jonesHouse.setScene(scene);*/
        locations[1][3] = jonesHouse;
        
        Location delgerHouse = new Location();
        delgerHouse.setRow(1);
        delgerHouse.setColumn(4);
        delgerHouse.setDescription("Joan Delger's House");
        delgerHouse.setVisited(false);
      /*delgerHouse.setDistanceFromCrime(0);
        delgerHouse.setParentLocation(parentLocation);
        delgerHouse.setScene(scene);*/
        locations[1][4] = delgerHouse;
        
        Location sumnerHouse = new Location();
        sumnerHouse.setRow(1);
        sumnerHouse.setColumn(5);
        sumnerHouse.setDescription("Sumner Brothers' House");
        sumnerHouse.setVisited(false);
      /*sumnerHouse.setDistanceFromCrime(0);
        sumnerHouse.setParentLocation(parentLocation);
        sumnerHouse.setScene(scene);*/
        locations[1][5] = sumnerHouse;
        
        return locations;
    } 

}
