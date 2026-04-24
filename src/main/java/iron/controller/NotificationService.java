package iron.controller;

import iron.model.Notification;
import iron.model.Racer;
import iron.model.DataManager;

import java.util.ArrayList;

public class NotificationService {
    private DataManager dataManager;
    public NotificationService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    /**
     * Sends a notification to a specific racer.
     * Each notificationId is a unique code that organizers can use
     * to quickly identify and track messages or errors.
     * The notification is sent to a specific racer by matching their user ID.
     *
     * @param racer the racer to receive the notification
     * @param message the message content to send to the racer
     */
    public void sendNotification(Racer racer, String message) {
        if(racer == null || message == null){return;}

        String notificationId = "NotificationId-" + (int)(Math.random() * 10000);
        Notification notification = new Notification(notificationId, message);

        if (racer.getNotifications() == null) {
            racer.setNotifications(new ArrayList<>());
        }
        racer.getNotifications().add(notification);

        if (dataManager != null) {
            dataManager.updateRecord("notifications", racer.getUserId(), notification.toString());
        }

        System.out.println("Notification for " + racer.getName() + ": " + message);

    }
    
    public void generateSystemMessage(String eventDetails) {
        // TODO: Implement logic to trigger automated event notifications (e.g., race canceled, registration open)
    }




}