package database.server;

import database.database.DBTransactions;
import database.database.SQLiteJDBC;
import shared.database.Record;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DBServer implements DBTransactions {

    SQLiteJDBC sql;

    public DBServer() throws RemoteException {
        // make bank server unicast to run in the background.
        UnicastRemoteObject.exportObject(this, 0);

        sql = new SQLiteJDBC();

    }


    @Override
    public int createCustomer(double startAmount) throws RemoteException {
        try {
            return sql.createCustomer(startAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            throw new Exception("Could not create customer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void withdraw(int account, double amount) throws RemoteException {
        sql.withdraw(account, amount);
    }

    @Override
    public void deposit(int account, double amount) throws RemoteException {
            sql.deposit(account, amount);
    }

    @Override
    public double getBalance(int account) throws RemoteException {
        try {
            return sql.getBalance(account);
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            throw new Exception("Problem getting balance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Record> getRecords() throws RemoteException {
        return sql.getRecords();
    }
}
