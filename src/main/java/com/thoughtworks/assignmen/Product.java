package com.thoughtworks.assignmen;

public class Product {

    double totalCart;

    String productName;
    int quantity;
    double price;

    public Product(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

}
