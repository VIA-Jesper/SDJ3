package client;


import shared.DBTransactions;
import shared.MoM;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SoSmartClient implements Remote
{

  public static void main(String[] args)
  {
    try {
      new SoSmartClient();
    } catch (RemoteException e) {
      e.printStackTrace();
    }

  }

  private DBTransactions soSmart;

  public SoSmartClient() throws RemoteException {
    // implement client and pull interface from server to be able to run methods on server
    UnicastRemoteObject.exportObject(this, 0);
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    try {
      // pull method from server
      soSmart = (DBTransactions) registry.lookup("MoM");
    } catch (NotBoundException e) {
      e.printStackTrace();
      System.out.println("Make sure the server is running");
    }
    System.out.println("Client started...");
  }


  public String findMoM(String key) {
    try
    {
      MoM mom = soSmart.getMom(key);
      if (mom == null) {
        return "Cannot find name";
      }
      return mom.getMom();

    }
    catch (RemoteException e)
    {
      //e.printStackTrace();
    }
    return "Error";
  }

}
