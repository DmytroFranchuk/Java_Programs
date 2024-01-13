package org.example.task2.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public ShoppingCart(List<CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }
}
