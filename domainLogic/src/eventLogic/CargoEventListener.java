package eventLogic;

import java.util.EventListener;

public interface CargoEventListener extends EventListener {
    void onCargoEvent(CargoEvent event);
}