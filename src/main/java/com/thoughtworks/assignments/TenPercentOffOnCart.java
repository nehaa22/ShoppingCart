package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class TenPercentOffOnCart extends Offer {
    public TenPercentOffOnCart(IShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public double getOfferDiscount() {
        double discount = 0;
        double itemsTotal = shoppingCart.getItemsTotal();
        if (itemsTotal > 10)
            discount = itemsTotal * 0.1;
        double updateDiscount = format(discount);
        return updateDiscount;
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}

// Nikhil... ye decorator use karke pahle 4Th run karenge, uske badd wo commit kRENGE..
// MAI CODE ALREDAY copy karungi 10th ka.....
// fir 5th case ki test case likhake, wo code paste karenge, shayed uske baad solution bhi mil jaye.
// good idea ot not ?