/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.exceptions;

/**
 *
 * @author Luiz
 */
public class GameMenuControlException extends Exception {

    public GameMenuControlException() {
    }

    public GameMenuControlException(String message) {
        super(message);
    }

    public GameMenuControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameMenuControlException(Throwable cause) {
        super(cause);
    }

    public GameMenuControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
