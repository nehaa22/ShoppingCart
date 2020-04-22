package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class ShoppingCartCalculator {
    private double itemsTotal;
    private double cartAmount;
    private final double salesTaxPercent;

    public ShoppingCartCalculator(double cartAmount, double itemsTotal, double salesTaxPercent) {
        this.cartAmount = cartAmount;
        this.itemsTotal = itemsTotal;
        this.salesTaxPercent  = salesTaxPercent;
    }

    public double getTotal() {
        return this.cartAmount;
    }

    public double getSalesTax() {
        return format(cartAmount - itemsTotal);
    }

    public void updateAmount(double amount) {
        itemsTotal += amount;
        cartAmount = format(itemsTotal * (1 + salesTaxPercent));
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}

