package shared;

import shared.MoM;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DBTransactions extends Remote
{
  void addMoM(String name, String MoM) throws RemoteException;
  MoM getMom(String name) throws RemoteException;
}
