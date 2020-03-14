package rmiexchangerate.client;

import rmiexchangerate.shared.Event;
import rmiexchangerate.shared.Observer;
import rmiexchangerate.shared.Subject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RmiClient extends UnicastRemoteObject implements Observer {

    Subject server;

    public RmiClient() throws RemoteException {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (Subject) registry.lookup("exchange");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Make sure the server is running...");
            return;
        }
        System.out.println("Client started...");

        // subscribing to events
        server.attach("exchangerate", this);
    }

    @Override
    public void update(Event m) {
        System.out.println("Update has been received with event: " + m.getType() + " and payload: " + m.getPayLoad());
        // bank can now do whatever with the exchange rates
    }

}
