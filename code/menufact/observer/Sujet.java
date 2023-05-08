package menufact.observer;

import java.util.ArrayList;
import java.util.List;

public interface Sujet {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

