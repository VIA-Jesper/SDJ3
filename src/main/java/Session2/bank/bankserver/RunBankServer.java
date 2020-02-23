package Session2.bank.bankserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunBankServer {


    // runs the bank server
    public static void main(String[] args) {
        try {
            // setup the server, since no reply is needed, we can instantiate bankserv directly ind the bind
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Bank",  new BankServer(new BankDBClient()));
            System.out.println("Bank server started...");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
