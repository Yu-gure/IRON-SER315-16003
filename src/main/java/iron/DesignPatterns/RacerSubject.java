package iron.DesignPatterns;

import iron.model.Notification;

public interface RacerSubject {
    void addObserver(RacerObserver observer);
    void removeObserver(RacerObserver observer);
    void notifyObservers(Notification notification);
}