package com.example.demo;

public class User {

    public int id;
    public String username;
    public String password;
    public String role;
    public String name;
    public String email;
    public String address;
    public String city;
    public String zip;
    public String phone;

    public User(int id, String username, String password, String role, String name, String email, String address, String city, String zip, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }
}
