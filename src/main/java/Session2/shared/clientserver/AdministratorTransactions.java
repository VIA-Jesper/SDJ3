package Session2.shared.clientserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdministratorTransactions extends Remote {

    void createAccount(int accountNo, int pin, double startBalance) throws RemoteException;

    boolean accountExists(int accountNo) throws RemoteException;
}
