package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

    private List<Product> products;
    private double totalCart = 0.0;
    static final double salesTaxPercent = 1.02;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public List<Double> calculateTotalCart() {
        for (Product item : products) {
            totalCart += item.quantity * item.price;
        }

        double totalCartWithTax = Double.parseDouble(new DecimalFormat("##.##").format(totalCart * salesTaxPercent));
        double salesTax = Double.parseDouble(new DecimalFormat("##.##").format(totalCartWithTax - totalCart));

        return Arrays.asList(salesTax, totalCartWithTax);
    }
}
