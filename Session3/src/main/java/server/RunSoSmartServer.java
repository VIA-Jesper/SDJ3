package server;

import shared.DBTransactions;
import shared.MoM;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RunSoSmartServer implements DBTransactions
{

  public static void main(String[] args)
  {
    try {
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.bind("MoM",  new RunSoSmartServer());
      System.out.println("Server started...");
    } catch (RemoteException | AlreadyBoundException e) {
      e.printStackTrace();
    }


  }

  private DBTransactions soSmart;


  public RunSoSmartServer() throws RemoteException
  {
      UnicastRemoteObject.exportObject(this, 0);
      this.soSmart = new DBTransactionImpl();
  }


  @Override public void addMoM(String name, String MoM) throws RemoteException
  {
    soSmart.addMoM(name, MoM);
  }

  @Override public MoM getMom(String name) throws RemoteException
  {
    return soSmart.getMom(name);
  }
}
