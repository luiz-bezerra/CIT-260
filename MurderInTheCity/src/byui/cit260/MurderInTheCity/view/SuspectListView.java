/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.SuspectControl;
import byui.cit260.MurderInTheCity.exceptions.SuspectControlExceptions;
import java.util.Scanner;

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
            System.out.println(menu);
            
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
    
    /**
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
    */
    
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
                    suspects.removeSuspect(Integer.parseInt(input));
                    System.out.println("\nSuspect " + input + " removed from list.");
                    this.updateSuspectList();
                    /**
                    if (suspects.removeSuspect(Integer.parseInt(input))){
                        System.out.println("\nSuspect " + input + " removed from list.");
                        this.updateSuspectList();
                    }
                    else{
                        System.out.println("\nInvalid suspect number. Try again.");
                        valid = false;
                    }**/
                }
                catch (SuspectControlExceptions sce) {
                    System.out.println("\nInvalid input. Try again.");
                }
                catch (NumberFormatException ex) {
                    System.out.println("\nInvalid input. Try again.");
                }
                catch (Exception ex) {
                    System.out.println("\nInvalid Selection. Try again.");
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
                this.removeSuspect();
                break;
            case "E":
                finish = true;
            default:
                System.out.println("\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
    
    @Override
    public String getInput() {
        this.updateSuspectList();
        return super.getInput();
    }
}
