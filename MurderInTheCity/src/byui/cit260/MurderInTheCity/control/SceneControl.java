/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import byui.cit260.MurderInTheCity.model.Scene;
import byui.cit260.MurderInTheCity.model.SceneType;
import byui.cit260.MurderInTheCity.view.SceneView;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author luiz
 */
public class SceneControl {
    
    public static void startNextScene() {
        Scene[] scene = MurderInTheCity.getCurrentGame().getScene();
        SceneView sceneView = null;
        
        /*for (Scene scenes : scene) {
            System.out.println(scenes.getDescription());
        }*/
        
        if (!scene[SceneType.Intro.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.Intro, false);
        }
        else if (!scene[SceneType.EvidenceTutorial.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.EvidenceTutorial, true);
        }
        else if (!scene[SceneType.AlibiTutorial.ordinal()].getCompleted()) {
            sceneView = new SceneView(SceneType.AlibiTutorial, true);
        }
        
        sceneView.display();
    }
    
    public static void talk() {
        System.out.println("talk function called");
    }
    
    public static void exploreLocation() {
        System.out.println("exploreLocation function called");
    }
    
    public static void moveToNewLocation() {
        System.out.println("moveToNewLocation function called");
    }
}
