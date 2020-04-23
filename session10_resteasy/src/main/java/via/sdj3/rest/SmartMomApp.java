package main.java.via.sdj3.rest;

import main.java.via.sdj3.rest.service.SmartMomResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class SmartMomApp extends Application {


    private Set<Object> singletons = new HashSet<>();

    public SmartMomApp() {
        singletons.add(new SmartMomResource());
    }


    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
