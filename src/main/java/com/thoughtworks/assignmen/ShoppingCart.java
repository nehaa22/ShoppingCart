package com.thoughtworks.assignmen;

public class ShoppingCart {

    double totalCart;

    String productName;
    int quantity;
    double price;

    public ShoppingCart(String proiductName, int quantity, double price) {
        this.productName = proiductName;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotalCart() {
        totalCart = quantity * price;
        return totalCart;
    }
}
