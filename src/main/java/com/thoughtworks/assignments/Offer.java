package com.thoughtworks.assignments;

import java.util.List;

import static com.thoughtworks.assignments.Utility.SALES_TAX_PERCENT;
import static com.thoughtworks.assignments.Utility.format;

public abstract class Offer extends Cart {
    Cart shoppingCart;

    Offer(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addCart(Product product, int quantity) {
        shoppingCart.addCart(product, quantity);
    }

    @Override
    public double getItemsTotal() {
        double discount = getOfferDiscount();
        return format(shoppingCart.getItemsTotal() - discount);
    }

    @Override
    public double getSalesTax() {
        return format(getItemsTotal() * SALES_TAX_PERCENT);
    }

    @Override
    public double getTotalCartWithTax() {
        return format(getItemsTotal() + getSalesTax());
    }

    @Override
    public double getDiscount() {
        return shoppingCart.getDiscount() + getOfferDiscount();
    }

    abstract double getOfferDiscount();

    @Override
    public List<CartItem> getCartItems() {
        return shoppingCart.getCartItems();
    }

    @Override
    public String toString() {
        return shoppingCart.toString();
    }
}

