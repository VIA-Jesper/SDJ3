package main.java.object_transfer_socket_java_to_java.client;

import main.java.object_transfer_socket_java_to_java.shared.Converter;
import main.java.object_transfer_socket_java_to_java.shared.JsonUtil;
import main.java.object_transfer_socket_java_to_java.shared.Student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RunClient {

    public static void main(String[] args) {

        // open connection
        RunClient r = new RunClient();
        // Initiate socket connection
        r.startSocket();



        // send msg as string to test its working
        r.sendMessage("This is from the client");

        while (true) {
            try {
                Thread.sleep(3000);

                // create student and send as json and send to check its converted
                String json = JsonUtil.convertStudentToJson(new Student(1, "test from client"));
                r.sendMessage(json);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }




    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public void startSocket() {
        try {
            socket = new Socket("localhost", 1337);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // listen for incoming messages.
            Runnable task = () -> {
                while(true) {
                    try {
                        byte[] lenBytes = new byte[4];
                        dataInputStream.read(lenBytes, 0, 4);
                        int length = Converter.lenghtBytesToInteger(lenBytes);

                        System.out.println("lenght: " + length);

                        if (length > 0) {
                            byte[] msg = new byte[length];
                            dataInputStream.readFully(msg, 0, msg.length); // read the message from index 0, till the length of msg.length, place it in msg.
                            JsonUtil.convertBytesToString(msg, length);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        // break out of thread if server stops
                        break;
                    }
                }
            };
            // start the thread
            new Thread(task).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void sendMessage(String message) {
        try {
            // get message length
            int length = message.length();
            // convert to lenght byte to send
            byte[] lenBytes = Converter.integerToBytes(length);
            // send length to server
            dataOutputStream.write(lenBytes);
            // convert message to bytes
            byte[] bytes = message.getBytes();
            // then send the actual message as bytes
            dataOutputStream.write(bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
