package com.example.demo.restservice;

import com.example.demo.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AnyWareTestController {

    private List<User> users;
    private AnyWareTestController() {
        System.out.println("Test controller initialized");
        users = new ArrayList<>();
        users.add(new User(1, "admin","admin", "Administrator", "Admin von Admin", "admin@site.com", "WOWWAy 4", "BongoLand", "55000", "88888888"));
        users.add(new User(2, "manager","manager", "Manager", "", "", "", "", "", ""));
        users.add(new User(2, "customer","manager", "Customer", "", "", "", "", "", ""));

    }

    @GetMapping("api/users")
    public List<User> getUsers() {
        System.out.println("getting all users");
            return users;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "api/users/{username}")
    public User getUsername(@PathVariable String username){
        for (User user : users) {
            if (user.username.toLowerCase().equals(username.toLowerCase())){
                System.out.println("found user " + username + " in db...");
                return user;
            }

        }
        return null;
    }

}
