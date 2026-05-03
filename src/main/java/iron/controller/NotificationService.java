package iron.controller;

import iron.model.DataManager;
import iron.model.Notification;
import iron.model.Racer;
import iron.DesignPatterns.RacerObserver;
import iron.DesignPatterns.RacerSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Subject - manages observers and delivers notifications
public class NotificationService implements RacerSubject {
    private DataManager dataManager;
    private final List<RacerObserver> observers = new ArrayList<>();

    public NotificationService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void addObserver(RacerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(RacerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Notification notification) {
        for (RacerObserver observer : observers) {
            observer.receiveNotification(notification);
        }
    }

    public void sendNotification(Racer racer, String message) {
        if (racer == null || message == null) { return; }

        String notificationId = UUID.randomUUID().toString();        Notification notification = new Notification(notificationId, message);

        if (racer.getNotifications() == null) {
            racer.setNotifications(new ArrayList<>());
        }
        racer.getNotifications().add(notification);

        if (dataManager != null) {
            dataManager.updateRecord("notifications", racer.getUserId(),
                    notification.toString());
        }

        // notify all registered observers
        notifyObservers(notification);
    }

    public void generateSystemMessage(String eventDetails) {
        // TODO: Implement logic
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}