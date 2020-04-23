package rmiexchangerate.server;

import rmiexchangerate.shared.Event;
import rmiexchangerate.shared.Observer;
import rmiexchangerate.shared.Subject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RmiServer extends UnicastRemoteObject implements Subject {

    private double exchangeRate;

    public RmiServer() throws RemoteException {
        super();

    }

    public void updateExchangeRate(double value) {
        exchangeRate = value;
        Event m = new Event("exchange", value);
        notifyUpdateType("exchangerate", m);
        //broadcast();
    }

    public double getExchangeRate(){
        return exchangeRate;
    }

    // hashmap, allow unique key and list of subscribers to that type of event.
    private Map<String, ArrayList<Observer>> observers = new HashMap<>();
    // stored objects and their types for time loosely coupled objects
    private Map<String, List<Event>> keyValuePairObjects = new HashMap<>();

    // attach observer to a specific type
    @Override
    public void attach(String type, Observer o) {
        System.out.println("Observer subscribing to event: " + type);
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
        if (observers.containsKey(type)){
            observers.get(type).remove(o);
        }
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
            ArrayList<Observer> get = observers.get(type);
            // has to be fori loop since its not possible to change foreach loop while iterating through
            for (int i = 0; i < get.size(); i++) {
                Observer o = get.get(i);
                try {
                    o.update(m);
                } catch (RemoteException e) {
                    System.out.println("Could not contact observer, removing from list...");
                    detachType(type, o);
                }
            }
        }
    }
}
