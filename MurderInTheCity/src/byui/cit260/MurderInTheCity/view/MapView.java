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
        "\n 1 - Police Station                           " +
        "\n 2 - Defense Attorney's Office                " +
        "\n 3 - Addison Park                             " +
        "\n 4 - Convenience Store                        " +
        "\n 5 - Sheldon Family House                     " +
        "\n 6 - Mark Jones' House                        " +
        "\n 7 - Joan Delger's House                      " +
        "\n 8 - Sumner Brothers' House                   " +
        "\n E - Exit                                     " +
        "\n----------------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean finish = false;
        
        switch (value) {
            case "1":
                this.goToPoliceStation();
                break;
            case "2":
                this.goToDAOffice();
                break;
            case "3":
                this.goToPark();
                break;
            case "4":
                this.goToStore();
                break;
            case "5":
                this.goToSheldonHouse();
                break;
            case "6":
                this.goToJonesHouse();
                break;
            case "7":
                this.goToDelgerHouse();
                break;
            case "8":
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
