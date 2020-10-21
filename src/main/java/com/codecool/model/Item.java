package com.codecool.model;

public class Item {

    private static int nextId;
    private int id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
