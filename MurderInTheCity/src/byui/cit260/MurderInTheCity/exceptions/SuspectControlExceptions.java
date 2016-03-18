/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.exceptions;

/**
 *
 * @author Daniel
 */
public class SuspectControlExceptions extends Exception {

    public SuspectControlExceptions() {
    }

    public SuspectControlExceptions(String message) {
        super(message);
    }

    public SuspectControlExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public SuspectControlExceptions(Throwable cause) {
        super(cause);
    }

    public SuspectControlExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
