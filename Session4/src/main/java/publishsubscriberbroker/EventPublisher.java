package publishsubscriberbroker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Broker

public class EventPublisher implements Subject {

/*
Design and implement a simple publish/subscribe broker.
     The broker should allow clients to subscribe to certain types of events.
     The broker should allow clients to publish events to all subscribers.
     The events should have a type and a payload (some kind of object).
     If one of the subscribers fail, the message should still reach the other subscribers.
 */

    // hashmap, allow unique key and list of subscribers to that type of event.
    Map<String, ArrayList<Observer>> observers = new HashMap<>();
    // stored objects and their types for time loosely coupled objects
    Map<String, List<Event>> keyValuePairObjects = new HashMap<>();

    // attach observer to a specific type
    @Override
    public void attach(String type, Observer o) {

        // check if key exists if not, create and add the observer
        if (!observers.containsKey(type)) {
            ArrayList<Observer> newList = new ArrayList<>();
            newList.add(o);
            observers.put(type, newList);
        } else {
            // if key exists update arraylist with the new observer
            ArrayList<Observer> currentList = observers.get(type);
            currentList.add(o);
            observers.put(type, currentList);

            // will this work:
            //observers.get(type).add(o);
        }


    }

    // detach observer from type
    @Override
    public void detachType(String type, Observer o) {
        if (observers.containsKey(type))
        {
            observers.get(type).remove(o);
        }
    }

    // detach subscriber from all types
    @Override
    public void detachAll(Observer o) {

    }

    // notify all regardless of type
    @Override
    public void broadcast() {
        System.out.println("Broadcasts all stored messages to subscribers");
        // loop through stored messages keys
        for (Map.Entry<String, List<Event>> entry : keyValuePairObjects.entrySet()){
            String type = entry.getKey();
            List<Event> payLoads = entry.getValue();
            // loop through observers
            for(Observer observer : observers.get(type)) {
                observer.updateList(payLoads);

            }
        }

    }    @Override
    public void broadcast(String type) {
        System.out.println("Broadcasting to subscribers of : " + type);
        List<Event> payLoads = keyValuePairObjects.get(type);
        for (Observer observer : observers.get(type)) {
            observer.updateList(payLoads);
        }
    }

    @Override
    public void addPayLoad(String type, Event e) {
        List<Event> list = keyValuePairObjects.get(type);
        if (list != null ) {
            list.add(e);
        } else {
            list = new ArrayList<>();
            list.add(e);
        }
        keyValuePairObjects.put(type, list);
    }

    @Override
    public void removePayLoad(Event e) {

    }


    // notify only subscribers to specific type
    @Override
    public void notifyUpdateType(String type, Event m) {

        List<Event> eventList = keyValuePairObjects.get(type);
        if (eventList == null) {
            eventList = new ArrayList<>();
            eventList.add(m);
        } else {
            eventList.add(m);
        }
        keyValuePairObjects.put(type, eventList);

        if (observers.containsKey(type)){
            for (Observer o : observers.get(type)) {
                o.update(m);
            }
        }
    }

}
