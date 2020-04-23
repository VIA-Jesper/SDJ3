package main.java.exercises_messages;

import main.java.requiredsource.ByteConverter;
import main.java.requiredsource.Task;
import main.java.requiredsource.TaskList;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerComm  {

    Recipient recipient;
    TaskDispatcher taskDispatcher;

    public ServerComm() {
        taskDispatcher = new TaskDispatcher(new TaskList());
    }

    // socket used for exercise 6.2
    public void startServerSocket() {

        try {
            ServerSocket serverSocket = new ServerSocket(1337);
            System.out.println("Server is now listening...");
            while (true) {
                // continue listing for incoming messages
                Socket socket = serverSocket.accept();

                // When it accepts a communication, it should read a Message and hand it on to a Recipient. Then it should send the response from the Recipient back to the caller.
                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());

                Task task = (Task) inFromClient.readObject();

                // not sure this is what the teacher wants, its pretty unclear from the text.
                taskDispatcher.addMessage(task);

                byte[] messageBytes = taskDispatcher.getMessage(task);

                // return the message as bytes. send length then the bytes
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeInt(messageBytes.length);
                dataOutputStream.write(messageBytes);

                System.out.println("Operation done.");

            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
