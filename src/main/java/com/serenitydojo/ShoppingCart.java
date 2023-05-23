package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;

    List<ShoppingCartItem> items = new ArrayList<>();

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public void addToCart(Fruit fruit, double quantity) {
        //add to cart
        items.add(new ShoppingCartItem((Fruit) fruit, (int) quantity));

    }

    public double getRunningTotal() {
        return items.stream()
                .mapToDouble(item -> priceOf(item))
                .sum();
//        double runningTotal = 0.0;
//        for (ShoppingCartItem item : items) {
//            runningTotal += catalog.getPriceOf(item.fruit()) * item.quantity();
//        }
//        return runningTotal;
    }

    private double priceOf(ShoppingCartItem item) {
        if (item.quantity() >= 5.0) {
            return catalog.getPriceOf(item.fruit()) * item.quantity() * 0.9;
        } else {
            return catalog.getPriceOf(item.fruit()) * item.quantity();
        }
    }

    public void removeFromCart(Fruit fruit, double quantity) {
        items.remove(new ShoppingCartItem(fruit, quantity));
    }

    public void removeAllFromCart(Fruit fruit) {
        items.removeIf(item -> item.fruit().equals(fruit));
    }

    public String getTypesOfItems() {
        return items.stream()
                .map(item -> item.fruit().name())
                .distinct()
                .reduce("", (item1, item2) -> item1 + ", " + item2);
    }
}
