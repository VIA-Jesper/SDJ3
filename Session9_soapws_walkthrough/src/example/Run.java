package example;

import javax.xml.ws.Endpoint;

public class Run {

    public static void main(String[] argv) {
        Object implementor = new HelloWorld ();
        String address = "http://localhost:9000/HelloWorld";
        Endpoint.publish(address, implementor);
    }
}
