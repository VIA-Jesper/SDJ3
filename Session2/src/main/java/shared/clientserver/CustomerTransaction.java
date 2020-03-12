package shared.clientserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CustomerTransaction extends Remote {

    void customerWithdraw(double amount, int accountNo) throws RemoteException;

    double getBalance(int account) throws RemoteException;
}
