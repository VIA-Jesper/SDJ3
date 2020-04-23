package rmiexchangerate.client;

import java.rmi.RemoteException;

public class RunClient {

    public static void main(String[] args) {
        try {
            new RmiClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
