package bank.administrator;

import shared.clientserver.AdministratorTransactions;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Implemented remote to make it passable to rmi
public class AdministratorClient implements Remote {


    private AdministratorTransactions administratorTransactions;


    public AdministratorClient() throws RemoteException {


        // implement client and pull interface from server to be able to run methods on server
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        try {
            // pull method from server
            administratorTransactions = (AdministratorTransactions) registry.lookup("Bank");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Client started...");

    }

    private boolean accountExists(int accountNo) throws RemoteException {
        return administratorTransactions.accountExists(accountNo);
    }

    public void createAccount(int accountNo, int pin, double startBalance) throws Exception {
        if (!accountExists(accountNo)) {
            administratorTransactions.createAccount(accountNo, pin, startBalance);
        } else {
            throw new Exception("Account already exists");
        }

    }


}
