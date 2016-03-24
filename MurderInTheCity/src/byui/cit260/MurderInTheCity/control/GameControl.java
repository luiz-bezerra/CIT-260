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
import byui.cit260.MurderInTheCity.model.Map;
import byui.cit260.MurderInTheCity.model.PiecesOfEvidence;
import byui.cit260.MurderInTheCity.model.Player;
import byui.cit260.MurderInTheCity.model.Suspect;
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
       MurderInTheCity.setCurrentGame(game);
       
       game.setPlayer(player);
       
       Map map = MapControl.createMap();
       game.setMap(map);
       
       Crime[] crime = GameControl.createCrime();
       game.setCrime(crime);
       
       Evidence[] evidence = GameControl.createEvidenceList();
       game.setEvidence(evidence);
       
       Alibi[] alibi = GameControl.createAlibiList();
       game.setAlibi(alibi);
    }
    
    public static Crime[] createCrime() {
        System.out.println("createCrime function called.");
        return null;
    }
    
    public static Evidence[] createEvidenceList() {
        Evidence[] evidence = new Evidence[11];
        
        Evidence autopsyResults = new Evidence();
        autopsyResults.setName("Autopsy results");
        autopsyResults.setDescription("death by head trauma due to two blows received on the head");
        autopsyResults.setLocationCollected("");
        evidence[PiecesOfEvidence.AutopsyResults.ordinal()] = autopsyResults;
        
        Evidence bloodyHammer = new Evidence();
        bloodyHammer.setName("Bloody hammer");
        bloodyHammer.setDescription("confirmed to have been the murder weapon");
        bloodyHammer.setLocationCollected("Park");
        evidence[PiecesOfEvidence.BloodyHammer.ordinal()] = bloodyHammer;
        
        Evidence harrisFingerprints = new Evidence();
        harrisFingerprints.setName("Harris Sheldon's fingerprints");
        harrisFingerprints.setDescription("Fingerprints of Harris Sheldon found on the murder weapon");
        harrisFingerprints.setLocationCollected("");
        evidence[PiecesOfEvidence.HarrisFingerprints.ordinal()] = harrisFingerprints;
        
        Evidence tonyFingerprints = new Evidence();
        tonyFingerprints.setName("Tony Sumner's fingerprints");
        tonyFingerprints.setDescription("Fingerprints of Tony Sumner found on the murder weapon");
        tonyFingerprints.setLocationCollected("");
        evidence[PiecesOfEvidence.TonyFingerprints.ordinal()] = tonyFingerprints;
        
        Evidence danFingerprints = new Evidence();
        danFingerprints.setName("Dan Sumner's fingerprints");
        danFingerprints.setDescription("Fingerprints of Dan Sumner found on the murder weapon");
        danFingerprints.setLocationCollected("");
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
        harrisAlibi.setTime("10:00 PM");
        harrisAlibi.setDescription("Harris Sheldon was watching TV home with his wife");
        harrisAlibi.setCorroborator("Aura Sheldon");
        alibi[Suspect.HarrisSheldon.ordinal()] = harrisAlibi;
        
        Alibi tonyAlibi = new Alibi();
        tonyAlibi.setTime("10:00 PM");
        tonyAlibi.setDescription("Tony Sumner was running close to his house, practicing for a marathon");
        tonyAlibi.setCorroborator("Mark Jones");
        alibi[Suspect.TonySumner.ordinal()] = tonyAlibi;
        
        Alibi danAlibi = new Alibi();
        danAlibi.setTime("10:00 PM");
        danAlibi.setDescription("Dan Sumner was at the movies with his girlfriend");
        danAlibi.setCorroborator("Joan Delger");
        alibi[Suspect.DanSumner.ordinal()] = danAlibi;
        
        return alibi;
    }

    public static void SaveGame(Game currentGame, String filePath) throws GameControlExceptions {
        try ( FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(currentGame);
        } catch(Exception ex) {
            throw new GameControlExceptions(ex.getMessage());
        }
    }

    public static void getSavedGame(String filePath) throws GameControlExceptions {
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        } catch(Exception ex) {
            throw new GameControlExceptions(ex.getMessage());
        }
    }
}
