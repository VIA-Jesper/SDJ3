package main.java.exercises_messages;

import main.java.requiredsource.ByteConverter;
import main.java.requiredsource.Task;

import java.io.IOException;
import java.rmi.RemoteException;

public class RunClientComm {

    public static void main(String[] args) {
        ClientComm cc = null;
        try {
            cc = new ClientComm();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        cc.startServerSocket();

        ITaskList taskList = new TaskListProxy(cc);
        taskList.addTask(new Task("Test message", 1000));

//
//        byte[] bytes = cc.doOperation(new Task("Test", 1000));
//
//
//        // just for testing purpose
//        try {
//            Task converted = (Task) ByteConverter.serializableFromByteArray(bytes);
//            System.out.println("Received from in bytes: " + converted.getText());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
