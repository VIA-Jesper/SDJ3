package Session2.bank.customer;

import Session2.shared.clientserver.CustomerTransaction;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CustomerClient implements Remote {

    private CustomerTransaction customerTransaction;
    private int accountNo;

    public CustomerClient(int accNo, int pin) throws RemoteException {

        this.accountNo = accNo;


        // implement client and pull interface from server to be able to run methods on server
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        try {
            // pull method from server
            customerTransaction = (CustomerTransaction) registry.lookup("Bank");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Client started...");
    }



    public void withdraw(double amount) throws RemoteException {
        System.out.println("Withdrawing " + amount + " from account " + accountNo);
        customerTransaction.customerWithdraw(amount, accountNo);
    }

    public double getBalance() throws RemoteException {
        return customerTransaction.getBalance(accountNo);
    }


}
