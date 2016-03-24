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
public class MapView extends View{

    public MapView() {
        super("\n" + 
        "\n----------------------------------------------" +
        "\n| Map                                        |" +
        "\n----------------------------------------------" +
        "\n C - Cafe                                     " +
        "\n P - Pub                                      " +
        "\n S - Store                                    " +
        "\n O - Office                                   " +
        "\n R - Prison                                   " +
        "\n E - Exit Map                                 " +
        "\n----------------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean finish = false;
        
        switch (value) {
            case "C":
                this.goToCafe();
                break;
            case "P":
                this.goToPub();
                break;
            case "S":
                this.goToStore();
                break;
            case "O":
                this.goToOffice();
                break;
            case "R":
                this.goToPrison();
                break;
            case "E":
                finish = true;
                break;
            default:
                this.console.println("\nInvalid Selection. Try again.");
        }
        return finish;
    }

    private void goToCafe() {
        this.console.println("goToCafe funtion called!");
    }

    private void goToPub() {
        this.console.println("goToPub funtion called!");
    }

    private void goToStore() {
        this.console.println("goToStore funtion called!");
    }

    private void goToOffice() {
        this.console.println("goToOffice funtion called!");
    }

    private void goToPrison() {
        this.console.println("goToPrison funtion called!");
    }
    
}
