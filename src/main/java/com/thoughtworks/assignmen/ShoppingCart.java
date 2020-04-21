package com.thoughtworks.assignmen;

import java.util.List;

public class ShoppingCart {

    List<Product> products;

    double totalCart;


    public ShoppingCart(List<Product> products) {
        this.products = products;
    }


    public double calculateTotalCart() {
        for (Product item : products) {
            totalCart = item.quantity * item.price;
        }
        return totalCart;
    }
}
