package com.thoughtworks.assignments;

import static com.thoughtworks.assignments.Utility.format;

class TenPercentOffOnCart extends Offer {
    public TenPercentOffOnCart(Cart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public double getOfferDiscount() {
        double discount = 0;
        double itemsTotal = shoppingCart.getItemsTotal();
        if (itemsTotal > 10)
            discount = itemsTotal * 0.1;
        return format(discount);
    }
}
