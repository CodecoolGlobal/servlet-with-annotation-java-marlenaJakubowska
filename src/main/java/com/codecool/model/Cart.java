package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items = new ArrayList<>();

    public Cart(List<Item> items) {
        this.items = items;
    }

    public Cart() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }
}
