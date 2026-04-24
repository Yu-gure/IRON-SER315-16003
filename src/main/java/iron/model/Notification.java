package iron.model;

public class Notification {
    private String notificationId;
    private String message;
    
    //constructor
    public Notification(String notificationId, String message) {
        this.notificationId = notificationId;
        this.message = message;
    }

    public String getNotificationId() { return notificationId; }
    public void setNotificationId(String notificationId) { this.notificationId = notificationId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    // notify racer
    public void sendToRacer() {
        // TODO
    }
}
