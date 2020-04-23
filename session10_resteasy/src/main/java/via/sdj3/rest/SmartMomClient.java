package main.java.via.sdj3.rest;

import main.java.via.sdj3.rest.model.SmartMom;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class SmartMomClient {

    private static final String FULLPATH = "http://localhost:8080/";

    public static void main(String[] args) {

        SmartMom ts = new SmartMom(23404L, "TeslaBike", "TB2LL");

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target(FULLPATH);

            Response response = target.request().post(Entity.entity(ts, "application/json"));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        } catch (Exception e) {
            // handle e
        }
    }


}
