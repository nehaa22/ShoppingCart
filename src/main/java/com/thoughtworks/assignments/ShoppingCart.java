package com.thoughtworks.assignments;

import java.util.List;

public class ShoppingCart {

    private List<Product> products;
    private double totalCart = 0.0;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public double calculateTotalCart() {
        for (Product item : products) {
            totalCart += item.quantity * item.price;
        }
        return totalCart;
    }
}
