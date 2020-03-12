package shared.clientserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClerkTransactions extends Remote {

    void deposit(int accountNo, double amount) throws RemoteException;
    void withdraw(int accountNo, double amount) throws RemoteException;

}
