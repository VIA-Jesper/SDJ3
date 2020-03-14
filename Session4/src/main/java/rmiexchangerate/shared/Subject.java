package rmiexchangerate.shared;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subject extends Remote, Serializable {

    public void attach(String type, Observer o) throws RemoteException;
    public void detachType(String type, Observer o) throws RemoteException;
    public void notifyUpdateType(String type, Event m) throws RemoteException;

}
