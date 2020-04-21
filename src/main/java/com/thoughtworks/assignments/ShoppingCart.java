package com.thoughtworks.assignments;

import java.text.DecimalFormat;
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

        double preciseTotalCartWithTax = getPreciseTaxValue(totalCart * salesTaxPercent);
        double preciseSalesTax = getPreciseTaxValue(preciseTotalCartWithTax - totalCart);

        return Arrays.asList(preciseSalesTax, preciseTotalCartWithTax);
    }

    private double getPreciseTaxValue(double v) {
        return Double.parseDouble(new DecimalFormat("##.##").format(v));
    }
}
