package client;

import shared.ISoSmart;

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

  private ISoSmart soSmart;

  public SoSmartClient() throws RemoteException {
    // implement client and pull interface from server to be able to run methods on server
    UnicastRemoteObject.exportObject(this, 0);
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    try {
      // pull method from server
      soSmart = (ISoSmart) registry.lookup("MoM");
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
    System.out.println("Client started...");
  }


  public String findMoM(String key) {
    try
    {
      return soSmart.findMoM(key);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return "Error";
  }

}
