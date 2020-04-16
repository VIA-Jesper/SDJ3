package example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

// created the webservice project by selecting java and web services.

@WebService()
public class HelloWorld {

  @WebMethod
  public String test() {
    return "This is a test";
  }

  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }



}
