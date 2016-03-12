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
                System.out.println("\nInvalid Selection. Try again.");
        }
        return finish;
    }

    private void goToCafe() {
        System.out.println("goToCafe funtion called!");
    }

    private void goToPub() {
        System.out.println("goToPub funtion called!");
    }

    private void goToStore() {
        System.out.println("goToStore funtion called!");
    }

    private void goToOffice() {
        System.out.println("goToOffice funtion called!");
    }

    private void goToPrison() {
        System.out.println("goToPrison funtion called!");
    }
    
}
