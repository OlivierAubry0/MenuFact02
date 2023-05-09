package menufact.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();
    /**
     * Registers an Observer to this Observable.
     *
     * @param observer the Observer to register
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    /**
     * Unregisters an Observer from this Observable.
     *
     * @param observer the Observer to unregister
     */
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }
    /**
     * Notifies all registered Observers with a message.
     *
     * @param message the message to send to the Observers
     */
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.actualiser(message);
        }
    }
}

