/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.GameControl;
import byui.cit260.MurderInTheCity.control.GameMenuControl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel and Luiz
 */
public class HelpMenuView extends View {

    public HelpMenuView() {
        super("\n" +
            "\n----------------------------------------------" +
            "\n| Help Menu                                  |" +
            "\n----------------------------------------------" +
            "\n P - Purpose of the game                      " +
            "\n M - Moving in the game                       " +
            "\n T - Calculate time of death                  " +
            "\n D - Calculate search radius                  " +
            "\n V - Validate suspect's alibi                 " +
            "\n E - Exit Menu                                " +
         /* "\n R - ~~ PRINT EVIDENCE REPORT ~~              " +
            "\n A - ~~ PRINT ALIBI REPORT ~~                 " + */
            "\n----------------------------------------------");
    }
    
    private void showPurpose() {
        this.console.println(
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
        this.console.println(
            "\n*******************************************" +
            "\n* After pressing M, a list of possible    *" +
            "\n* locations will be shown. Each location  *" +
            "\n* will have a different number. Just      *" +
            "\n* press the number of the location you    *" +
            "\n* want to go, and press enter.            *" +
            "\n*******************************************");
            
    }
    /*
    private void printReport() {
        this.console.println("\nPlease enter the filepath for the report to be printed to:");
        try {
            String filePath = this.keyboard.readLine();
            filePath.trim();
             
            GameMenuControl printReport = new GameMenuControl();
            printReport.printEvidenceReport(GameControl.createEvidenceList(), filePath);

            this.console.println("\nSuccess! Report printed to " + filePath);
        } catch (IOException ex) {
            Logger.getLogger(HelpMenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            ErrorView.display("printReport()", e.getMessage());
        }
    }
    
    private void printAlibiReport() {
        this.console.println("\nPlease enter the filepath for the report to be printed to:");
        try {
            String filePath = this.keyboard.readLine();
            filePath.trim();
             
            GameMenuControl printReport = new GameMenuControl();
            printReport.printAlibiReport(GameControl.createAlibiList(), filePath);

            this.console.println("\nAlibi report printed to " + filePath);
        }
        catch (IOException ioEx) {
            ErrorView.display(this.getClass().getName(), "IO Error printing report:\n" + ioEx.getMessage());
        }
        catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "Error printing report:\n" + ex.getMessage());
        }
    }
    */
    private void showTimeOfDeath() {
        this.console.println(
            "\n*******************************************" +
            "\n* After pressing T, you will be prompted  *" +
            "\n* to input the time the body was found,   *" +
            "\n* the body temperature, and the room      *" +
            "\n* temperature. Then the computer computes *" +
            "\n* the time of death and shows you.        *" +
            "\n*******************************************");
    }
    
    private void showSearchRadius() {
        this.console.println(
            "\n*******************************************" +
            "\n* After pressing D, you will be prompted  *" +
            "\n* to input the speed of travel and the    *" +
            "\n* time since death. Then the computer     *" +
            "\n* computes the search radius and shows    *" +
            "\n* you.                                    *" +
            "\n*******************************************");
    }
    
    private void showValidateAlibi() {
        this.console.println(
            "\n*******************************************" +
            "\n* After pressing V, you will be prompted  *" +
            "\n* to input the time of death and the      *" +
            "\n* search radius. Then the computer        *" +
            "\n* computes whether or not the alibi is    *" +
            "\n* valid, and shows you.                   *" +
            "\n*******************************************");
    }

    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
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
          /*case "R":
                this.printReport();
                break;*/
            case "E":
                finish = true;
                break;
          /*case "A":
                this.printAlibiReport();
                break;*/
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        
        return finish;
    }

}
