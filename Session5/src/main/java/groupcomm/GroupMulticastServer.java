package groupcomm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GroupMulticastServer
{
  // group multicast IP is in the range 224.0.0.0 to 239.255.255.255
  // 224.0.0.0 is reserved
  final static String INET_ADDR = "228.5.6.7";
  final static int PORT = 6789;

  public static void main(String[] args) throws UnknownHostException
  {
    String[] sslangs = {"Java", "Python ", "Erlang", "R-programming", "JavaScript", "F#-Script  "};
    // get the address  to connect to
    InetAddress address = InetAddress.getByName(INET_ADDR);

    // open a new DatagramSocket for sending data
    try (DatagramSocket serverSocket = new DatagramSocket()) {
      for (String mm : sslangs){
        String message = "SoSmart class is cool with " + mm;
        // create a packet with the data
        DatagramPacket messagePacket = new DatagramPacket(message.getBytes(), message.getBytes().length, address, PORT);
        // send the packet
        serverSocket.send(messagePacket);
        System.out.println("Server has sent a packet with message: " + message);
      }
    } catch (IOException ioe){
      ioe.printStackTrace();
    }



  }

}
