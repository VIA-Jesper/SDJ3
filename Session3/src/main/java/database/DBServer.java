package database;

import shared.DBTransactions;
import shared.MoM;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class DBServer implements DBTransactions
{

    SQLiteAdapter sql;

    public DBServer() throws RemoteException
    {
        // make server unicast to run in the background.
        UnicastRemoteObject.exportObject(this, 0);

        sql = new SQLiteAdapter();

    }



    @Override public void addMoM(String name, String mom)
    {
        try
        {
            sql.addMoM(name, mom);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override public MoM getMom(String name)
    {
        try
        {
            return sql.getMoM(name);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
