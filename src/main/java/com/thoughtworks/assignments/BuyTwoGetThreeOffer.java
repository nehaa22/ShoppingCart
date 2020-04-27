package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class BuyTwoGetThreeOffer extends Offer {
    Product offerProduct = new Product("Apple", 0.99);
    private CartItem cartItem;

    public BuyTwoGetThreeOffer(IShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public double getOfferDiscount() {
        for (CartItem cartItem : getCartItems()) {
            if (cartItem.isExists(offerProduct.getName())) {
                this.cartItem = cartItem;
            }
        }

        int offerQuantity = 2;
        int freeQuantity = 1;
        int totalBuyQuantity = offerQuantity + freeQuantity;
        int productCount = cartItem.getQuantity();
        int ineligibleCount = productCount % totalBuyQuantity;
        int discountableCount = (productCount - ineligibleCount) / totalBuyQuantity;
        if (ineligibleCount == offerQuantity) {
            shoppingCart.addCart(offerProduct, freeQuantity);
            discountableCount += freeQuantity;
        }

        CartItem discountItem = new CartItem(offerProduct, discountableCount);
        return format(discountItem.getPrice());
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}
