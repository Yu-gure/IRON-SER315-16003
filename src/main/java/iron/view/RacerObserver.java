package iron.view;

import iron.model.Notification;

public interface RacerObserver {
    void receiveNotification(Notification notification);
}
