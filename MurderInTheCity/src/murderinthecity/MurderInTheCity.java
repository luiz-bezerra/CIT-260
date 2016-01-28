/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murderinthecity;

import byui.cit260.MurderInTheCity.model.Player;

/**
 *
 * @author Daniel
 */
public class MurderInTheCity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player();
        
        player.setName("Daniel Eckton");
        player.setRankAchieved("Lieutenant");
        player.setCrimesSolved(5);
        player.setTimeAsDetective(3);
        
        String playerInfo = player.toString();
        System.out.println(playerInfo);
    }
    
}
