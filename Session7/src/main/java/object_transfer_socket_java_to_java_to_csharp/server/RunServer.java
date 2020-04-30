package main.java.object_transfer_socket_java_to_java_to_csharp.server;

import main.java.object_transfer_socket_java_to_java_to_csharp.shared.Converter;
import main.java.object_transfer_socket_java_to_java_to_csharp.shared.Student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RunServer {


    public static void main(String[] args) {
        RunServer r = new RunServer();
        r.listen();

        // wait for the client to send the string and object, then return a new student object

        int i = 1;
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Student newStudent = new Student(i++, "Server student" );
            r.sendMessage(Converter.convertStudentToJson(newStudent));
        }



    }




    private DataInputStream dataInputStream;

    private List<Socket> connectedSockets;

    public void listen() {
        connectedSockets = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(1337);

            System.out.println("Server is now listening...");

            // listen for incoming in seperate thread so we can do other stuff while
            Runnable task = () -> {
                while (true) {
                    try {
                        // continue listing for incoming messages
                        Socket socket = serverSocket.accept();
                        System.out.println("Connection established");
                        // add the connected peer to list for resend.
                        connectedSockets.add(socket);

                        // upon accept, create another thread for continual listening
                        Runnable receiveTask = () -> {
                            while (true) {
                                try {
                                    // When it accepts a communication, it should read a Message and hand it on to a Recipient. Then it should send the response from the Recipient back to the caller.
                                    dataInputStream = new DataInputStream(socket.getInputStream());

                                    // receive lenght as byte
                                    byte[] lenByte = new byte[4];
                                    dataInputStream.read(lenByte, 0, 4);

                                    // convert to integer
                                    int length = Converter.lengthBytesToInteger(lenByte);

                                    // wait for the package or object as bytes
                                    if (length > 0) {
                                        byte[] msg = new byte[length];
                                        dataInputStream.readFully(msg, 0, msg.length); // read the message from index 0, till the length of msg.length, place it in msg.
                                        // convert bytes to json string
                                        String json = Converter.convertBytesToString(msg, length);
                                        // convert json to object
                                        Student student = Converter.convertJsonToStudent(json);
                                        // use object or print in console
                                        System.out.println(student.toString());
                                    }

                                } catch (IOException e) {
                                    System.out.println("connection reset");
                                    connectedSockets.remove(socket);
                                    break;
                                }
                            }
                        };
                        new Thread(receiveTask).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            // start the thread
            new Thread(task).start();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void sendMessage(String message) {
        // to avoid ConcurrentModificationException we have to modify the list after its done iterating
        List<Socket> disconnectedSockets = new ArrayList<>();

        // loop through connected clients if any and send message.
        for (Socket socket : connectedSockets) {
            try {
                // get output stream to send
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                // get length
                int length = message.length();

                byte[] lenBytes = Converter.integerToBytes(length);

                // convert message to bytes
                byte[] bytes = message.getBytes();
                // send length
                dataOutputStream.write(lenBytes);
                // send bytes
                dataOutputStream.write(bytes, 0, length);
                System.out.println("Message sent...");
            } catch (IOException e) {
                // error means the client does not exists or is connected anymore... remove
                disconnectedSockets.add(socket);
                System.out.println("client removed");
            }
        }

        // to avoid ConcurrentModificationException we have to modify the list after its done iterating
        for (Socket socket : disconnectedSockets) {
            connectedSockets.remove(socket);
        }

    }


}
