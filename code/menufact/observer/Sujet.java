package menufact.observer;

<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> Stashed changes
public interface Sujet {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

