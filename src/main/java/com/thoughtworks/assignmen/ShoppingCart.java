package com.thoughtworks.assignmen;

public class ShoppingCart {
    String proiductName;
    int quantity;
    double price;

    public ShoppingCart(String proiductName, int quantity, double price) {
        this.proiductName = proiductName;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateCartTotal() {
        return quantity * price;
    }
}
