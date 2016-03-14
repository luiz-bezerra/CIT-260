/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Luiz
 */
public enum Evidence implements Serializable {
    
    AutopsyResults("Autopsy results: death by head trauma due to two blows received on the head"),
    BloodyHammer("Bloody hammer: confirmed to have been the murder weapon"),
    HarrisFingerprints("Fingerprints of Harris Sheldon found on the murder weapon"),
    TonyFingerprints("Fingerprints of Tony Sumner found on the murder weapon"),
    DanFingerprints("Fingerprints of Dan Sumner found on the murder weapon"),
    AuraTestimony("Aura Sheldon's testimony: Harris Sheldon was watching TV with her around 10 PM"),
    MarkTestimony("Mark Jones' testimony: Tony Sumner was running shirtless around 10 PM"),
    JoanTestimony("Joan Delger's testimony: Dan Sumner was at the movies with her at 10 PM"),
    StoreOwnerTestimony("Convenience store owner's testimony: no vehicles passed by that place since 9 PM"),
    BloodyShirt("Blood stained T-shirt: found in the Sumner brothers' house and confirmed to be stained with the blood of the victim"),
    JoanDanSelfie("Joan and Dan's selfie: selfie taken in the night of the murder, proving Dan Sumner was wearing a gray T-shirt");
    
    // Class instance variables
    private final String description;
    private final String locationCollected;

    @Override
    public String toString() {
        return "Evidence{" + "description=" + description + ", locationCollected=" + locationCollected + '}';
    }
    
    Evidence(String description) {
        this.description = description;
        this.locationCollected = "Pub";
    }

    public String getDescription() {
        return description;
    }

    public String getLocationCollected() {
        return locationCollected;
    }

}
