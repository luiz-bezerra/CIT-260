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
public class TabletMenuView extends View {
    
    public TabletMenuView() {
            super("\n" +
                "\n----------------------------------------------" +
                "\n| Tablet                                     |" +
                "\n----------------------------------------------" +
                "\n L - Evidence List                            " +
                "\n S - Suspect List                             " +
                "\n D - Calculate Time of Death                  " +
                "\n R - Calculate Search Radius                  " +
                "\n E - Turn Off Tablet                          " +
                "\n----------------------------------------------");
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        switch (value) {
            case "L":
                this.showEvidenceList();
                break;
            case "S":
                this.showSuspectList();
                break;
            case "D":
                this.calcTimeOfDeath();
                break;
            case "R":
                this.calcSearchRadius();
                break;
            case "E":
                finish = true;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInvalid Selection. Try again.");
        }
        
        return finish;
    }
    
    private void showEvidenceList() {
        PiecesOfEvidenceView evidence = new PiecesOfEvidenceView();
        evidence.display();
    }
    
    private void showSuspectList() {
        SuspectListView suspectList = new SuspectListView();
        suspectList.display();
    }
    
    private void calcTimeOfDeath() {
        CalcTimeOfDeathView calcTimeOfDeath = new CalcTimeOfDeathView();
        calcTimeOfDeath.display();
    }
    
    private void calcSearchRadius() {
        CalcSearchRadiusView calcSearchRadius = new CalcSearchRadiusView();
        calcSearchRadius.display();
    }
}
