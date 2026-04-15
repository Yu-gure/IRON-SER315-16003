package iron.view;

import iron.model.Racer;

public class RacerDashboard {
    private Racer racer;
    
    public RacerDashboard(Racer racer) {
        this.racer = racer;
    }

    public Racer getRacer() { return racer; }
    public void setRacer(Racer racer) { this.racer = racer; }
    
    public void displayRacerMenu() {
        // TODO: Implement UI logic
    }
}