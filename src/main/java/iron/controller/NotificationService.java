package iron.controller;

import iron.model.DataManager;
import iron.model.Racer;

public class NotificationService {
    
    public DataManager dataManager;
    
    public void sendNotification(Racer racer, String message) {
        // TODO: Implement logic to generate a Notification object and assign it to the Racer
    }
    
    public void generateSystemMessage(String eventDetails) {
        // TODO: Implement logic to trigger automated event notifications (e.g., race canceled, registration open)
    }
}