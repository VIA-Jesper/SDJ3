package main.java;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService()
public class HelloWorld {


    @WebMethod
    public String test() {
        System.out.println("IM here");
        return "TEST";
    }


    public static void main(String[] argv) {
        Object implementor = new HelloWorld ();
        String address = "http://localhost:9001/HelloWorld";
        Endpoint.publish(address, implementor);
        System.out.println("Web now running at: " + address);
    }
}
