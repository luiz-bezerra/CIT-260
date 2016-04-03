/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

/**
 *
 * @author luiz
 */
public class MoveToLocationView extends View{
    
    public MoveToLocationView() {
        super(
            "\n----------------------------------------------" +
            "\n| Choose the location you want to go         |" +
            "\n----------------------------------------------" +
            "\n 1 - Park (Crime Scene)                       " +
            "\n 2 - Convenience Store                        " +
            "\n 3 - Police Station                           " +
            "\n 4 - Sheldon Family House                     " +
            "\n 5 - Mark Jones' House                        " +
            "\n 6 - Joan Delger's House                      " +
            "\n 7 - Deffense Attorney Office                 " +
            "\n 8 - Sumner Brothers' House                   " +
            "\n E - Don't go anywhere yet                    " +
            "\n----------------------------------------------");
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "1":
                moveToLocation();
                break;
            case "2":
                moveToLocation();
                break;
            case "3":
                moveToLocation();
                break;
            case "4":
                moveToLocation();
                break;
            case "5":
                moveToLocation();
                break;
            case "6":
                moveToLocation();
                break;
            case "7":
                moveToLocation();
                break;
            case "8":
                moveToLocation();
                break;
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        return finish;
    }
    
    private void moveToLocation() {
        this.console.println("moveToLocation functino called");
    }
}
