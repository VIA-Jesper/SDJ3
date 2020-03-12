package database.database;

import shared.database.Record;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DBTransactions extends Remote {

    int createCustomer(double startAmount) throws RemoteException;
    void withdraw(int account, double amount) throws RemoteException;
    void deposit(int account, double amount) throws RemoteException;
    double getBalance(int account) throws RemoteException;
    List<Record> getRecords() throws RemoteException;


}
