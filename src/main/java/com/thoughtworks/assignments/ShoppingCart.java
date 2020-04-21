package com.thoughtworks.assignments;

import java.util.List;

public class ShoppingCart {

    List<Product> products;

    double totalCart = 0.0;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public double calculateTotalCart() {
        totalCart = 0;
        for (Product item : products) {
            totalCart += item.quantity * item.price;
        }
        return totalCart;
    }
}
