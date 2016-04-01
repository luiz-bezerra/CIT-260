/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import byui.cit260.MurderInTheCity.model.Map;
import byui.cit260.MurderInTheCity.model.Scene;

/**
 *
 * @author Daniel
 */
public class MapControl {
    
    /**
    public void moveToLocation(location) {
        
    }
    */
    
    public static Map createMap() {
        
        Map map = new Map(2, 7);
        
        Scene[] scenes = GameControl.createScenes();
        
        return map;
    }
}
