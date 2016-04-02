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
public class DetectiveView extends View {
    
    public DetectiveView() {
        super(
            "\n----------------------------------------------" +
            "\n| Current Professional Rank                  |" +
            "\n----------------------------------------------" +
            "\n [\u2713] - Probational Detective                  " +
            "\n [ ] - Detective                              " +
            "\n [ ] - Lieutenant                             " +
            "\n [ ] - Captain                                " +
            "\n [ ] - Chief of Police                        " +
            "\n                                              " +
            "\n E - Continue                                 " +
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
