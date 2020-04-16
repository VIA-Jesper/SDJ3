package main.java;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class testservice {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  @WebMethod
  public String getHello() {
    return "HELLO WORLD";
  }

  public static void main(String[] argv) {
    Object implementor = new testservice ();
    String address = "http://localhost:9000/testservice";
    Endpoint.publish(address, implementor);
  }
}
