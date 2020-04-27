package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class BuyTwoGetThreeOffer extends Offer {
    private CartItem cartItem;

    public BuyTwoGetThreeOffer(IShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public double getOfferDiscount() {
        for (CartItem cartItem : getCartItems()) {
            if (cartItem.isExists("Apple")) {
                this.cartItem = cartItem;
            }
        }

        int offerQauntity = 2;
        int count = cartItem.getQuantity();
        int ineligibleCount = count % 3;
        int discountableCount = (count - ineligibleCount) / 3;
        if (ineligibleCount == offerQauntity) {
            shoppingCart.addCart(new Product("Apple", 0.99), 1);
            discountableCount += 1;
        }

        CartItem discountItem = new CartItem(new Product("Apple", 0.99), discountableCount);
        double discount = format(discountItem.getPrice());
        return discount;
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}




//                int remainingQuantity = quantity;
//                int buyQuantity = 2;
//                int freeQuantity = 1;
//                int getQuantities = buyQuantity + freeQuantity;
//                int totalGetQuantities = 0;
//                int freeQuantities = 0;
//
//                while (remainingQuantity > 1) {
//                    totalGetQuantities += getQuantities;
//                    freeQuantities += freeQuantity;
//
//                    remainingQuantity -= getQuantities;
//                }
//
//                if (remainingQuantity > 0)
//                    totalGetQuantities += remainingQuantity;
//                int totalBuyQuantities = totalGetQuantities - freeQuantities;
//
//                CartItem freeCartItem = new CartItem(product, freeQuantities);
//                discount += freeCartItem.getPrice();
//                discount = format(discount);
//
//                CartItem totalCartItem = new CartItem(product, quantity);
//                itemsTotal += (totalCartItem.getPrice() - discount);
//                itemsTotal = format(itemsTotal);
//                tax = format(itemsTotal * SALES_TAX_PERCENT);
//                total = format(itemsTotal + tax);