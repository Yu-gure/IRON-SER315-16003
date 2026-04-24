package iron.view;

import iron.model.Racer;
import iron.model.Notification;

public class RacerDashboard implements RacerObserver {
    private Racer racer;

    
    public RacerDashboard(Racer racer) {
        this.racer = racer;
    }

    public Racer getRacer() { return racer; }
    public void setRacer(Racer racer) { this.racer = racer; }


    @Override
    public void receiveNotification(Notification notification) {
        System.out.println("Notification for " + racer.getName() + ": " + notification.getMessage());
    }


    public void displayRacerMenu() {
        // TODO: Implement UI logic
    }
}