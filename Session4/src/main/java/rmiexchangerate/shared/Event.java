package rmiexchangerate.shared;

//  The events should have a type and a payload (some kind of object).

import java.io.Serializable;

public class Event implements Serializable {

    private final String type;
    private final Object payLoad;

    public Event(String type, Object payLoad) {
        this.type = type;
        this.payLoad = payLoad;
    }

    public Object getPayLoad() {
        return payLoad;
    }

    public String getType() {
        return type;
    }
}
