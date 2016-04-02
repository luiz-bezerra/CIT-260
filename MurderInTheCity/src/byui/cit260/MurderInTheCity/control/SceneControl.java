/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;


/**
 *
 * @author luiz
 */

import byui.cit260.MurderInTheCity.model.Scene;
import byui.cit260.MurderInTheCity.model.SceneType;
import byui.cit260.MurderInTheCity.view.MoveToLocationView;
import byui.cit260.MurderInTheCity.view.SceneView;
import byui.cit260.MurderInTheCity.view.TalkView;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author luiz
 */
public class SceneControl {
    
    public static void startNextScene() {
        Scene[] scene = MurderInTheCity.getCurrentGame().getScene();
        SceneView sceneView = null;
        
        if (!scene[SceneType.Intro.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.Intro, true);
        }
        else if (!scene[SceneType.EvidenceTutorial.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.EvidenceTutorial, false);
        }
        else if (!scene[SceneType.AlibiTutorial.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.AlibiTutorial, false);
        }
        else if (!scene[SceneType.MoveToLocationTutorial.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.MoveToLocationTutorial, false);
        }
        
        sceneView.display();
    }
    
    public static void talk(Scene[] scene, SceneType sceneType) {
        TalkView talkView = null;
        
        if (sceneType.equals(SceneType.EvidenceTutorial)) {
            talkView = new TalkView(SceneType.EvidenceTutorialTalk, false);
        }
        else if (sceneType.equals(SceneType.AlibiTutorial)) {
            talkView = new TalkView(SceneType.AlibiTutorialTalk, true);
        }
        else if (sceneType.equals(SceneType.MoveToLocationTutorial)) {
            talkView = new TalkView(SceneType.MoveToLocationTutorialTalk, false);
        }
        
        talkView.display();
    }
    
    public static void exploreLocation() {
        System.out.println("exploreLocation function called");
    }
    
    public static void moveToNewLocation() {
        MoveToLocationView moveToLocation = new MoveToLocationView();
        moveToLocation.display();
    }
}
