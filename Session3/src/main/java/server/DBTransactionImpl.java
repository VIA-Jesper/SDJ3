package server;

import shared.DBTransactions;
import shared.MoM;

import java.rmi.RemoteException;

public class DBTransactionImpl implements DBTransactions
{
  SoSmartDBClient db;
  public DBTransactionImpl() {

    try
    {
      db = new SoSmartDBClient();

      db.addMoM("Jesper", "Ducati");
    }
    catch (RemoteException e)
    {
      System.out.println("Make sure DB Server runs first");
      e.printStackTrace();
    }
  }

  @Override public void addMoM(String name, String MoM) throws RemoteException
  {
      db.addMoM(name, MoM);
  }

  @Override public MoM getMom(String name) throws RemoteException
  {
    return db.getMoM(name);
  }
}
