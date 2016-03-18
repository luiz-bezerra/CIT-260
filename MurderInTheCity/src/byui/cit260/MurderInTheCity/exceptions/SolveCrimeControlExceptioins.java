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
public class SolveCrimeControlExceptioins extends Exception{

    public SolveCrimeControlExceptioins() {
    }

    public SolveCrimeControlExceptioins(String message) {
        super(message);
    }

    public SolveCrimeControlExceptioins(String message, Throwable cause) {
        super(message, cause);
    }

    public SolveCrimeControlExceptioins(Throwable cause) {
        super(cause);
    }

    public SolveCrimeControlExceptioins(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
