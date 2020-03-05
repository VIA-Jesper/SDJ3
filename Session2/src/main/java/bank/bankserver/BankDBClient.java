package Session2.bank.bankserver;

import database.database.DBTransactions;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BankDBClient implements Remote {

    DBTransactions db;
    public BankDBClient() throws RemoteException {

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


    public void withdraw(int accountNo, double amount) {
        try {
            db.withdraw(accountNo, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int createCustomer(double startAmount) {
        try {
            return db.createCustomer(startAmount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean exist(int accountNo) {
        try {
            return db.getBalance(accountNo) > 0;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deposit(int accountNo, double amount) {
        try {
            db.deposit(accountNo, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public double getBalance(int account) throws RemoteException {
        return db.getBalance(account);
    }
}