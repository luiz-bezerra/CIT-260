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
                "\n 1 - Evidence List                            " +
                "\n 2 - Suspect List                             " +
                "\n 3 - Calculate Time of Death                  " +
                "\n 4 - Calculate Search Radius                  " +
                "\n E - Turn Off Tablet                          " +
                "\n----------------------------------------------");
    }
    
    @Override
    public boolean doAction(String value) {
        boolean finish = false;
        value = value.toUpperCase();
        switch (value) {
            case "1":
                this.showEvidenceList();
                break;
            case "2":
                this.showSuspectList();
                break;
            case "3":
                this.calcTimeOfDeath();
                break;
            case "4":
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
