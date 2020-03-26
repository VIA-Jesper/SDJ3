package main.java.exercises_messages;

import java.rmi.RemoteException;

public class RunServerComm {

    public static void main(String[] args) {
        ServerComm srv = null;
        srv = new ServerComm();
        srv.startServerSocket();



    }
}
