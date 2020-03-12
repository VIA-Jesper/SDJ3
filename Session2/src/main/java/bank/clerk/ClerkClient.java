package bank.clerk;

import shared.clientserver.ClerkTransactions;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClerkClient implements Remote {


    private ClerkTransactions clerkTransactions;

    public ClerkClient() throws RemoteException {

        // implement client and pull interface from server to be able to run methods on server
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        try {
            // pull method from server
            clerkTransactions = (ClerkTransactions) registry.lookup("Bank");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Client started...");
    }


    public void withdraw(int accountNo, double amount) {
        try {
            clerkTransactions.withdraw(accountNo, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deposit(int accountNo, double amount) {
        try {
            clerkTransactions.deposit(accountNo, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
