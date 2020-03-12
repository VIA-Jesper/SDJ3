package server;

import shared.DBTransactions;
import shared.MoM;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SoSmartDBClient implements Remote {

    DBTransactions db;
    public SoSmartDBClient() throws RemoteException {

        // implement client and pull interface from server to be able to run methods on server
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1098);
        try {
            // pull method from server
            db = (DBTransactions) registry.lookup("DB");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Client connected to db...");
    }

    public void addMoM(String name, String mom) {
        try
        {
            db.addMoM(name, mom);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    public MoM getMoM(String name) {
        try
        {
            return db.getMom(name);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}