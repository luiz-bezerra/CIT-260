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
    
    /**
    private void showBanner() {
        this.console.println(
            "\n*******************************************" +
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
            "\n*******************************************"
        );
    }
    
    private Player getName() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        
        boolean valid = false;
        while(!valid) {
            this.console.println("Please enter your Name:");
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 2) {
                this.console.println("Invalid input.");
                continue;
            }
            valid = true;
        }
        Player player = GameMenuControl.createPlayer(value);
        return player;
    }
    
    
    private void showWelcomeMessage(Player player) {
        this.console.println("Welcome to Murder in the City, " + player.getName());
    }
    
    private void showMainMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
    }
    **/

    @Override
    public boolean doAction(String value) {
        boolean valid = true;
        this.console.println("Welcome to Murder in the City, " + value + ".");
                
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
        
        return valid;
    }
            
}
