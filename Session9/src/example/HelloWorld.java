


package example;

import javax.jws.WebMethod;
import javax.jws.WebService;

/*
Install tomcat and use to launch the application, under edit configuration

POWERSHELL:

> $url = "http://localhost:8080/services/HelloWorld?wsdl"
> $soapws = New-WebServiceProxy -Uri $url -Namespace WebServiceProxy -Class HelloWorld
> $soapws.sayHelloWorldFrom("Star wars")

// in the console, you can now see Hello, world, from Star wars

next, install SoapUI

 */

@WebService
public class HelloWorld {

  @WebMethod
  public String toUpper(String lowercase) {
    System.out.println("String: " + lowercase.toUpperCase());
    return lowercase.toUpperCase();
  }

  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
}
