package com.example.LibraryManagement.Pojo;

import javax.persistence.Id;

public class User {

    @Id
    private Integer id;

    private String Name;
    private String address;
    private String phoneNumber;

    public User(Integer id, String name, String address, String phoneNumber) {
        this.id = id;
        Name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
