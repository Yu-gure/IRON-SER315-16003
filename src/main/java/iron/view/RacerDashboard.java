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

    public void displayNotifications() {
        if (racer.getNotifications() == null || racer.getNotifications().isEmpty()) {
            System.out.println("No notifications.");
            return;
        }
        for (Notification n : racer.getNotifications()) {
            System.out.println("[NOTIF - " + racer.getName() + "] " + n.getMessage());
        }
    }

    public void displayRacerMenu() {
        // TODO: Implement UI logic
    }
}