package exercise5_1__pubsub.models;

public class PubSubObject {
    private ElementType type;
    private Object payload;

    public PubSubObject(){}

    public PubSubObject(ElementType type, Object payload) {
        this.type = type;
        this.payload = payload;
    }
    public ElementType getType() {
        return type;
    }
    public void setTopic(ElementType type) {
        this.type = type;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}