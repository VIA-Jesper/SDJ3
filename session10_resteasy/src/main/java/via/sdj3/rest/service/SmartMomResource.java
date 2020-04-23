package main.java.via.sdj3.rest.service;

import main.java.via.sdj3.rest.model.SmartMom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Path("smartmoms")
public class SmartMomResource {

    private SmartMomService ms = new SmartMomService();

    @GET
    @Produces("application/json")
    public List<SmartMom> getMoms(){
        return ms.getAll().values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

}