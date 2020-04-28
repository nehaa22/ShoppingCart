package com.thoughtworks.assignments;

import static com.thoughtworks.assignments.Utility.format;

public class BuyTwoGetThreeOffer extends Offer {
    Product offerProduct = new Product("Apple", 0.99);
    private CartItem cartItem;

    public BuyTwoGetThreeOffer(Cart shoppingCart) {
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
        }

        CartItem discountItem = new CartItem(offerProduct, discountableCount);
        return format(discountItem.getPrice());
    }
}
