package iron.controller;

import iron.model.Racer;
import iron.model.DataManager;

public class NotificationService {
    private DataManager dataManager;
    
    public NotificationService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public void sendNotification(Racer racer, String message) {
        // TODO: Implement logic to generate a Notification object and assign it to the Racer
    }
    
    public void generateSystemMessage(String eventDetails) {
        // TODO: Implement logic to trigger automated event notifications (e.g., race canceled, registration open)
    }
}