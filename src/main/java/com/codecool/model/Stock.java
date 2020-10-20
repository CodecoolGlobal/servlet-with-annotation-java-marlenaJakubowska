package com.codecool.model;

import java.util.HashSet;

public class Stock {

    private HashSet<Item> items;

    public Stock() {
        items = initialiseItems();
    }

    public HashSet<Item> getItems() {
        return items;
    }

    private HashSet<Item> initialiseItems() {
        HashSet<Item> items = new HashSet<>();
        items.add(new Item(1, "QualityLand", 29.99));
        items.add(new Item(2, "Vox", 27.99));
        items.add(new Item(3, "Kallocain", 39.99));
        items.add(new Item(4, "Fahrenheit 451", 33.99));
        items.add(new Item(5, "Brave New World", 25.99));
        return items;
    }

    public Item getItem(int id) {
        return items.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

}
