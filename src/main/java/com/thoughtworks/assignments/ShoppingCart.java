package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class ShoppingCart {

    private double totalCart = 0.0;
    private static final double salesTaxPercent = 1.02;
    private int appleCount = 0;
    private int maskCount = 0;
    private double cartAmountWithTax = 0.0;


    public double getTotalCart() {
        return totalCart;
    }

    public double getAppleCount() {
        return appleCount;
    }

    public double getMaskCount() {
        return maskCount;
    }

    public double getTotalCartWithTax() {
        return cartAmountWithTax;
    }

    public double getSalesTax() {
        return format(cartAmountWithTax - totalCart);
    }

    public void addCart(Product product, int quantity) {
        if (product instanceof Apple) {
            appleCount += quantity;
        } else {
            maskCount += quantity;
        }
        totalCart += product.getPrice() * quantity;

        cartAmountWithTax = format(totalCart * salesTaxPercent);

    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}

