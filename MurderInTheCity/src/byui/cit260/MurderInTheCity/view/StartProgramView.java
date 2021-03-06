/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;
/**
 *
 * @author Daniel and Luiz
 */
public class StartProgramView extends View {
    
    public StartProgramView() {
        super("\n*******************************************" +
            "\n*                                         *" +
            "\n*            Murder in the City           *" +
            "\n*                                         *" +
            "\n*******************************************" +
            "\n*                                         *" +
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
            "\n*                                         *" +
            "\n*******************************************" +
            "\n" +
            "\nWhat is your name?");
        
    }

    @Override
    public boolean doAction(String value) {
        boolean valid = true;
        this.console.println("Welcome to Murder in the City, " + value + ".");
                
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
        
        return valid;
    }
            
}