package eventLogic;

import java.util.LinkedList;
import java.util.List;

public class CargoEventHandler {
    private final List<CargoEventListener> listenerList = new LinkedList<>();

    public void add(CargoEventListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(CargoEventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(CargoEvent event) {
        for (CargoEventListener listener : listenerList) {
            listener.onCargoEvent(event);
        }
    }
}