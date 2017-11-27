import java.util.*;

public class Observable {
    private ArrayList<Observer> observes;

    Observable() {
        this.observes = new ArrayList<Observer>();
    }

    Observable addObserver(Observer observer) {
        this.observes.add(observer);
        return this;
    }

    Observable removeObserver(Observer observer) {
        this.observes.remove(observer);
        return this;
    }

    Observable notifyObserves() {
        for (Observer observer : this.observes) {
            observer.update();
        }
        System.out.println("All user were notified");
        return this;
    }
}
