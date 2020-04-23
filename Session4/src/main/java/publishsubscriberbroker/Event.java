package publishsubscriberbroker;

//  The events should have a type and a payload (some kind of object).

public class Event {

    private final String type;
    private final String payLoad;

    public Event(String type, String payLoad) {
        this.type = type;
        this.payLoad = payLoad;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public String getType() {
        return type;
    }
}
