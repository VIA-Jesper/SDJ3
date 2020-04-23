package main.java.via.sdj3.rest.service;

import main.java.via.sdj3.rest.model.SmartMom;

import java.util.HashMap;
import java.util.Map;

public class SmartMomService {
    private Map<Long, SmartMom> inventory = new HashMap<>();

    public Map<Long, SmartMom> getAll() {
        inventory.put(23401L, new SmartMom(23401L, "Legey", "2ll"));
        inventory.put(23501L, new SmartMom(23501L, "Scooter", "SC3"));
        inventory.put(23601L, new SmartMom(23601L, "Bike", "IronHorse"));

        return inventory;
    }
}