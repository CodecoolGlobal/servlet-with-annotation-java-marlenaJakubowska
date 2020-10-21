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

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
