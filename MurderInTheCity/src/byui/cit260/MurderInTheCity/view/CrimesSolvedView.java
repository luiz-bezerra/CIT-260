/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

/**
 *
 * @author Daniel
 */
public class CrimesSolvedView extends View{

    public CrimesSolvedView() {
        super("\n" +
            "\n----------------------------------------------" +
            "\n| Crimes Solved                              |" +
            "\n----------------------------------------------" +
            "\n [ ] - The Murder of Hudson Conners           " +
            "\n                                              " +
            "\n E - Exit Menu                                " +
            "\n----------------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        
        switch (value) {
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        
        return finish;
    
    }
    
}
