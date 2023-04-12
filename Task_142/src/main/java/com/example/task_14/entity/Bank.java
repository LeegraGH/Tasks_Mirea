package com.example.task_14.entity;


public class Bank {
    private String name;
    private String address;

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", address = " + address;
    }
}
