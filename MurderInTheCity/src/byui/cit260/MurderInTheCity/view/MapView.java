/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.view;

import byui.cit260.MurderInTheCity.control.LocationControl;

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
        "\n P - Police Station                           " +
        "\n D - Defense Attorney's Office                " +
        "\n A - Addison Park                             " +
        "\n C - Convenience Store                        " +
        "\n S - Sheldon Family House                     " +
        "\n M - Mark Jones' House                        " +
        "\n J - Joan Delger's House                      " +
        "\n B - Sumner Brothers' House                   " +
        "\n E - Exit                                     " +
        "\n----------------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean finish = false;
        
        switch (value) {
            case "P":
                this.goToPoliceStation();
                break;
            case "D":
                this.goToDAOffice();
                break;
            case "A":
                this.goToPark();
                break;
            case "C":
                this.goToStore();
                break;
            case "S":
                this.goToSheldonHouse();
                break;
            case "M":
                this.goToJonesHouse();
                break;
            case "J":
                this.goToDelgerHouse();
                break;
            case "B":
                this.goToSumnerHouse();
                break;
            case "E":
                finish = true;
                break;
            default:
                this.console.println("\nInvalid Selection. Try again.");
        }
        return finish;
    }

    private void goToPoliceStation() {
        LocationControl.goToPoliceStation();
    }

    private void goToDAOffice() {
        LocationControl.goToDAOffice();
    }

    private void goToPark() {
        LocationControl.goToPark();
    }

    private void goToStore() {
        LocationControl.goToStore();
    }

    private void goToSheldonHouse() {
        LocationControl.goToSheldonHome();
    }

    private void goToJonesHouse() {
        LocationControl.goToJonesHome();
    }

    private void goToDelgerHouse() {
        LocationControl.goToDelgerHome();
    }

    private void goToSumnerHouse() {
        LocationControl.goToSumnerHome();
    }

}
