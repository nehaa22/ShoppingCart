package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class ShoppingCartCalculator {

    double total = 0.0;
    double itemsTotal = 0.0;
    private static final double salesTaxPercent = 0.02;

    public double getTotal() {
        return this.total;
    }


    public double getSalesTax() {
        return format(total - itemsTotal);
    }

    public void updateAmount(double amount) {
        itemsTotal += amount;
        total = format(itemsTotal * (1 + salesTaxPercent));
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}

