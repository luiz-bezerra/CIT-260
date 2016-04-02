/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.model.Alibi;
import byui.cit260.MurderInTheCity.model.Game;
import byui.cit260.MurderInTheCity.model.Scene;
import byui.cit260.MurderInTheCity.model.SceneType;
import byui.cit260.MurderInTheCity.model.SuspectName;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author luiz
 */
public class TalkView extends View {
    
    SceneType sceneType;
    Game game = MurderInTheCity.getCurrentGame();
    Scene[] scene = game.getScene();
    Alibi[] alibi = game.getAlibi();
    boolean multipleTalks;
    
    public TalkView(SceneType sceneType, boolean multipleTalks) {
        super(
            "\n----------------------------------------------" +
            "\n| Choose who you want to talk to             |" +
            "\n----------------------------------------------" +
            "\n 1 - Harris Sheldon                           " +
            "\n 2 - Tony Sumner                              " +
            "\n 3 - Dan Sumner                               " +
            "\n 4 - Jessica Waters                           " +
            "\n E - Don't talk to anyone                     " +
            "\n----------------------------------------------");
        this.sceneType = sceneType;
        this.multipleTalks = multipleTalks;
    }
    
    @Override
    public void display() {
        boolean done = false;
        if (multipleTalks) {
            do {
                String value = this.getInput(true);
                if (value.toUpperCase().equals("E"))
                    return;
            
                done = this.doAction(value);
            } while (!done);
        
            //SceneControl.startNextScene();
        }
        else {
            showTalk(scene[sceneType.ordinal()]);
        }
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "1":
                showTalk(scene[SceneType.HarrisSheldonAlibi.ordinal()]);
                addNewAlibi(SuspectName.HarrisSheldon, "10:00 PM");
                break;
            case "2":
                showTalk(scene[SceneType.TonySumnerAlibi.ordinal()]);
                addNewAlibi(SuspectName.TonySumner, "10:00 PM");
                break;
            case "3":
                showTalk(scene[SceneType.DanSumnerAlibi.ordinal()]);
                addNewAlibi(SuspectName.DanSumner, "10:00 PM");
                break;
            case "4":
                showTalk(scene[SceneType.AlibiTutorialTalk.ordinal()]);
                break;
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        return finish;
    }
    
    private void showTalk(Scene scene) {
        this.console.println(scene.getDescription());
        scene.setCompleted(true);
        
        if (sceneType.equals(SceneType.AlibiTutorialTalk)) {
            if (this.scene[SceneType.HarrisSheldonAlibi.ordinal()].getCompleted() &&
                this.scene[SceneType.TonySumnerAlibi.ordinal()].getCompleted() &&
                this.scene[SceneType.DanSumnerAlibi.ordinal()].getCompleted()){
                MurderInTheCity.setSkipScene(true);
            }
        }
    }
    
    private void addNewAlibi(SuspectName suspectName, String time) {
        alibi[suspectName.ordinal()].setTime(time);
    }
    
    private void addNewEvidence() {
        this.console.println("\naddNewEvidence Function called");
    }
}