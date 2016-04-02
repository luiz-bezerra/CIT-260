/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import murderinthecity.MurderInTheCity;

/**
 *
 * @author Daniel
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    protected final BufferedReader keyboard = MurderInTheCity.getInFile();
    protected final PrintWriter console = MurderInTheCity.getOutFile();
    
    public View() {
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false;
        do {
            String value = this.getInput(true);
            if (value.toUpperCase().equals("E"))
                return;
            
            done = this.doAction(value);
        } while (!done);
    }
    
    @Override
    public String getInput(boolean showDisplay) {
        
        boolean valid = false;
        String value = "";
        
        while (!valid) {
            
            try {

                if (showDisplay)
                    this.console.println("\n" + this.displayMessage);
//>>>>>>> origin/master
                
                value = this.keyboard.readLine();
                value = value.trim();
                
                if (value.length() < 1) {
                    ErrorView.display(this.getClass().getName(), "*** Enter a value ***");
                    continue;
                }
                
                break;
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return value;
    }
}
