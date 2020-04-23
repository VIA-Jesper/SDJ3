package groupcomm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class GroupMulticastClientX
{
  final static String INET_ADDR = "228.5.6.7";
  final static int PORT = 6789;

  public static void main(String[] args) throws UnknownHostException
  {
    // get the address to connect to
    InetAddress address = InetAddress.getByName(INET_ADDR);
    // create a buffer of bytes to store the incoming bytes from the server
    byte[] buf = new byte[1024];

    // create a new Multicast socket
    try (MulticastSocket clientSocket = new MulticastSocket(PORT)) {
      // join the group
      clientSocket.joinGroup(address);
      // Recieve the group message
      while (true) {
        // create a packet with data
        DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
        // receive the packet
        clientSocket.receive(msgPacket);
        String msgReceived = new String(buf, 0, buf.length);
        System.out.println("X group recieved: " + msgReceived);
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }


  }
}
