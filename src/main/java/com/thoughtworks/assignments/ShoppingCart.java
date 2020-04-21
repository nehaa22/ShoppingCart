package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.List;

public class ShoppingCart {

    private List<Product> products;
    private double totalCart = 0.0;
    static final double salesTax = 1.02;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public double calculateTotalCart() {
        for (Product item : products) {
            totalCart += item.quantity * item.price;
        }
        return Double.parseDouble(new DecimalFormat("##.##").format(totalCart*salesTax));
    }
}
