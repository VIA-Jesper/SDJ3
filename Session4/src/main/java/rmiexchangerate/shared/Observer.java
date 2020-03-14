package rmiexchangerate.shared;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Observer extends Remote, Serializable {

    public void update(Event m) throws RemoteException;

}
