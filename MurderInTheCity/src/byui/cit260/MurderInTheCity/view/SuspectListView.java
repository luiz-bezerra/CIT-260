/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.SuspectControl;
import java.util.Scanner;

/**
 *
 * @author Luiz
 */
public class SuspectListView {
    
    String menu;
    SuspectControl suspects = new SuspectControl();
    
    public void displaySuspectListView() {
        
        String input;
        this.updateSuspectList();
        
        do {
            System.out.println(menu);
            
            input = this.getInput();
            
        } while (!input.equals("E"));
    }
    
    private void updateSuspectList() {
        menu = "\n" +
            "\n----------------------------------------------" +
            "\n| Suspect List                               |" +
            "\n----------------------------------------------" +
            suspects.showSuspects() +
            "\n----------------------------------------------" +
            "\n R - Remove a suspect from list               " +
            "\n E - Exit suspect list                        " +
            "\n----------------------------------------------";
    }
    
    private String getInput() {
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        
        boolean valid = true;
        String input;
        
        do { 
            input = keyboard.nextLine();
            input = input.toUpperCase();
            switch (input) {
                case "R":
                    this.removeSuspect();
                    break;
                case "E":
                    return input;
                default:
                    System.out.println("\nInvalid Selection. Try again.");
                    valid = false;
                    break;
            }
        } while (!valid);
        
        return input;
    }
    
    private void removeSuspect() {
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        boolean valid;
        String input;
        String menu = "\n" +
                "\nEnter the number of the suspect to be removed" +
                "\nor press E to go back to the previous menu.";
                
        do { 
            System.out.println(menu);
            valid = true;
            input = keyboard.nextLine();
            input = input.toUpperCase();
            if (!input.equals("E")) {
                try {
                    if (suspects.removeSuspect(Integer.parseInt(input))){
                        System.out.println("\nSuspect " + input + " removed from list.");
                        this.updateSuspectList();
                    }
                    else{
                        System.out.println("\nInvalid suspect number. Try again.");
                        valid = false;
                    }
                }
                catch (Exception ex) {
                    System.out.println("\nInvalid Selection. Try again.");
                        valid = false;
                }
            }
        } while (!valid);
    }
}
