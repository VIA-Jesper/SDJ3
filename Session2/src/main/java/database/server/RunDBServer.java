package database.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunDBServer {


    // runs the DB server
    public static void main(String[] args) {
        try {
            // setup the server, since no reply is needed, we can instantiate db  directly ind the bind
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.bind("DB",  new DBServer());
            System.out.println("DB server started");
        } catch (AlreadyBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
