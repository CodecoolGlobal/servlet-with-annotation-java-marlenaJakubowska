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
        items.add(new Item("QualityLand", 29.99));
        items.add(new Item("Vox", 27.99));
        items.add(new Item("Kallocain", 39.99));
        items.add(new Item("Fahrenheit 451", 33.99));
        items.add(new Item("Brave New World", 25.99));
        return items;
    }

    public Item getItem(int id) {

        return items.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

}
