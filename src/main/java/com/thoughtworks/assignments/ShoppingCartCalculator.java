package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class ShoppingCartCalculator {

    double initialAmount = 0.0;
    double itemsTotal = 0.0;
    private static final double salesTaxPercent = 0.02;

    public double getTotal() {
        return this.initialAmount;
    }


    public double getSalesTax() {
        return format(initialAmount - itemsTotal);
    }

    public void updateAmount(double amount) {
        itemsTotal += amount;
        initialAmount = format(itemsTotal * (1 + salesTaxPercent));
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}

