/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import java.util.Scanner;
/**
 *
 * @author Daniel and Luiz
 */
public class HelpMenuView {

    private final String MENU = "\n" +
            "\n----------------------------------------------" +
            "\n| Help Menu                                  |" +
            "\n----------------------------------------------" +
            "\n P - Purpose of the game                      " +
            "\n M - Moving in the game                       " +
            "\n T - Calculate time of death                  " +
            "\n D - Calculate search radius                  " +
            "\n V - Validate suspect's alibi                 " +
            "\n E - Exit Menu                                " +
            "\n----------------------------------------------";
    
    public void displayHelpMenuView() {
        String input;
        do {
            System.out.println(MENU);
            
            input = this.getInput();   
            
        } while (!input.equals("E"));
    }
    
        
    private String getInput() {
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        
        boolean valid = true;
        String input;
        
        do { input = keyboard.nextLine();
        input = input.toUpperCase();
        switch (input) {
            case "P":
                this.showPurpose();
                break;
            case "M":
                this.showMoving();
                break;
            case "T":
                this.showTimeOfDeath();
                break;
            case "D":
                this.showSearchRadius();
                break;
            case "V":
                this.showValidateAlibi();
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
    
    private void showPurpose() {
        System.out.println(
            "\n*******************************************" +
            "\n* In this game you will take the role of  *" +
            "\n* police officer Albert Hancock in his    *" +
            "\n* quest to move up in the ranks, to Chief *" +
            "\n* of Police, while solving crimes that    *" +
            "\n* will shock the nation.                  *" +
            "\n*                                         *" +
            "\n* Travel throughout the city, determine   *" +
            "\n* the difference between murder-suicides  *" +
            "\n* protect you family from danger, and     *" +
            "\n* work with other agencies to solve       *" +
            "\n* crimes and bring justice to criminals!  *" +
            "\n*******************************************");
    }
    
    private void showMoving() {
        System.out.println(
            "\n*******************************************" +
            "\n* After pressing M, a list of possible    *" +
            "\n* locations will be shown. Each location  *" +
            "\n* will have a different number. Just      *" +
            "\n* press the number of the location you    *" +
            "\n* want to go, and press enter.            *" +
            "\n*******************************************");
            
    }
    
    private void showTimeOfDeath() {
        System.out.println(
            "\n*******************************************" +
            "\n* After pressing T, you will be prompted  *" +
            "\n* to input the time the body was found,   *" +
            "\n* the body temperature, and the room      *" +
            "\n* temperature. Then the computer computes *" +
            "\n* the time of death and shows you.        *" +
            "\n*******************************************");
    }
    
    private void showSearchRadius() {
        System.out.println(
            "\n*******************************************" +
            "\n* After pressing D, you will be prompted  *" +
            "\n* to input the speed of travel and the    *" +
            "\n* time since death. Then the computer     *" +
            "\n* computes the search radius and shows    *" +
            "\n* you.                                    *" +
            "\n*******************************************");
    }
    
    private void showValidateAlibi() {
        System.out.println(
            "\n*******************************************" +
            "\n* After pressing V, you will be prompted  *" +
            "\n* to input the time of death and the      *" +
            "\n* search radius. Then the computer        *" +
            "\n* computes whether or not the alibi is    *" +
            "\n* valid, and shows you.                   *" +
            "\n*******************************************");
    }
}
