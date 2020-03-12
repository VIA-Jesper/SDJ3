package bank.bankserver;

import shared.clientserver.Account;
import shared.clientserver.AdministratorTransactions;
import shared.clientserver.ClerkTransactions;
import shared.clientserver.CustomerTransaction;
import bank.bankserver.BankDBClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BankServer implements CustomerTransaction, AdministratorTransactions, ClerkTransactions {

    private BankDBClient bankDBClient;

    public BankServer(BankDBClient bankDBClient) throws RemoteException {
        this.bankDBClient = bankDBClient;
        // make bank server unicast to run in the background.
        UnicastRemoteObject.exportObject(this, 0);

    }


    // method to run whenever customer runs method
    @Override
    public void customerWithdraw(double amount, int accountNo) throws RemoteException {
        bankDBClient.withdraw(accountNo, amount);
    }

    @Override
    public double getBalance(int account) throws RemoteException {
        return bankDBClient.getBalance(account);
    }


    // administrator actions
    @Override
    public void createAccount(int accountNo, int pin, double startBalance) throws RemoteException {
        int acc = bankDBClient.createCustomer(startBalance);
        System.out.println("New acc created with acc: " + acc);
    }

    @Override
    public boolean accountExists(int accountNo) {
        return bankDBClient.exist(accountNo);
    }


    // Clerk actions
    @Override
    public void deposit(int accountNo, double amount) throws RemoteException {
        bankDBClient.deposit(accountNo, amount);

    }

    @Override
    public void withdraw(int accountNo, double amount) throws RemoteException {
        bankDBClient.withdraw(accountNo, amount);
    }
}
