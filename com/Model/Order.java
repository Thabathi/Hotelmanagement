package com.Model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Menu> items = new ArrayList<>();

    public void addItem(Menu item) {
        items.add(item);
    }

    public List<Menu> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (Menu item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
