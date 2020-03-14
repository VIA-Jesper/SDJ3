package publishsubscriberbroker;

public interface Subject {

    public void attach(String type, Observer o);
    public void detachType(String type, Observer o);
    public void detachAll(Observer o);
    public void broadcast();
    public void broadcast(String type);
    public void addPayLoad(String type, Event e);
    public void removePayLoad(Event e);
    public void notifyUpdateType(String type, Event m);

}
