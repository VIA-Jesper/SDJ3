package main.java.exercises_messages;

import main.java.requiredsource.ByteConverter;
import main.java.requiredsource.Task;

import java.io.*;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientComm extends UnicastRemoteObject {

    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    private DataInputStream dataInputStream;

    protected ClientComm() throws RemoteException {
        super(1099);
    }



    public void startServerSocket() {


        try {
            socket = new Socket("localhost", 1337);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] doOperation(Task message) {
        try {

            objectOutputStream.writeObject(message);

            int length = dataInputStream.readInt(); // read length of message (incase more packages needs to be sent)
            if (length > 0) {
                byte[] msg = new byte[length];
                dataInputStream.readFully(msg, 0, msg.length); // read the message from index 0, till the length of msg.length, place it in msg.
                return msg; // return the newly bytes
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        // return null if everything fails
        System.out.println("Length was zero.");
        return null;
    }


}
