package server;

import shared.ISoSmart;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SoSmartServer implements ISoSmart
{

  public static void main(String[] args)
  {
    try {
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.bind("MoM",  new SoSmartServer(new SoSmartImpl()));
      System.out.println("Server started...");
    } catch (RemoteException | AlreadyBoundException e) {
      e.printStackTrace();
    }
  }

  private ISoSmart soSmart;


  public SoSmartServer(ISoSmart soSmart) throws RemoteException
  {
      UnicastRemoteObject.exportObject(this, 0);
      this.soSmart = soSmart;
  }

  public String findMoM(String key) throws RemoteException
  {

    System.out.println("SoSmartServer");
    return soSmart.findMoM(key);
  }
}
