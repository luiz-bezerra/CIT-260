/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.SuspectControl;
import byui.cit260.MurderInTheCity.exceptions.SuspectControlExceptions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz
 */
public class SuspectListView extends View {
    
    SuspectControl suspects = new SuspectControl();
    
    /*public SuspectListView() {
        super("");
    }*/
    
    /*public void displaySuspectListView() {
        
        String input;
        this.updateSuspectList();
        
        do {
            this.console.println(menu);
            
            input = this.getInput();
            
        } while (!input.equals("E"));
    }*/
    
    private void updateSuspectList() {
        this.displayMessage = "\n" +
            "\n----------------------------------------------" +
            "\n| Suspect List                               |" +
            "\n----------------------------------------------" +
            suspects.showSuspects() +
            "\n----------------------------------------------" +
            "\n R - Remove a suspect from list               " +
            "\n E - Exit suspect list                        " +
            "\n----------------------------------------------";
    }
    
    private void removeSuspect() throws IOException {
        boolean valid;
        String input;
        String menu = "\n" +
                "\nEnter the number of the suspect to be removed" +
                "\nor press E to go back to the previous menu.";
                
        do { 
            this.console.println(menu);
            valid = true;
            input = this.keyboard.readLine();
            input = input.toUpperCase();
            if (!input.equals("E")) {
                try {
                    suspects.removeSuspect(Integer.parseInt(input));
                    this.console.println("\nSuspect " + input + " removed from list.");
                    this.updateSuspectList();
                    /**
                    if (suspects.removeSuspect(Integer.parseInt(input))){
                        this.console.println("\nSuspect " + input + " removed from list.");
                        this.updateSuspectList();
                    }
                    else{
                        this.console.println("\nInvalid suspect number. Try again.");
                        valid = false;
                    }**/
                }
                catch (SuspectControlExceptions sce) {
                    this.console.println("\nInvalid input. Try again.");
                }
                catch (NumberFormatException ex) {
                    this.console.println("\nInvalid input. Try again.");
                }
                catch (Exception ex) {
                    this.console.println("\nInvalid Selection. Try again.");
                        valid = false;
                }
            }
        } while (!valid);
    }

    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "R":
        {
            try {
                this.removeSuspect();
            } catch (IOException ex) {
                Logger.getLogger(SuspectListView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "E":
                finish = true;
            default:
                this.console.println("\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
    
    @Override
    public String getInput(boolean showDisplay) {
        showDisplay = true;
        this.updateSuspectList();
        return super.getInput(showDisplay);
    }
}