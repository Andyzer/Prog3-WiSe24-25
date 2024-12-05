package eventLogic;

import java.util.EventObject;

public class CargoEvent extends EventObject {

    private final String message;

    public CargoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
