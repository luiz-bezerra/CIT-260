/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Luiz
 */
public class Game implements Serializable {
    
    // Class instance variable
    private Integer savedGame;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.savedGame);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.savedGame, other.savedGame)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "savedGame=" + savedGame + '}';
    }

    public Game() {
    }

    public Integer getSavedGame() {
        return savedGame;
    }

    public void setSavedGame(Integer savedGame) {
        this.savedGame = savedGame;
    }
}
