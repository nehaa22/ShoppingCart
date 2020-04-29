package com.thoughtworks.assignments;

import java.util.List;

import static com.thoughtworks.assignments.Utility.format;

public abstract class Offer extends Cart{
    Cart shoppingCart;

    Offer(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addCart(Product product, int quantity) {
        shoppingCart.addCart(product, quantity);
    }

    public double getItemsTotal() {
        double discount = getOfferDiscount();
        return format(shoppingCart.getItemsTotal() - discount);
    }

    public double getTotalCartWithTax() {
        return format(getItemsTotal() + getSalesTax());
    }

    public double getDiscount() {
        return shoppingCart.getDiscount() + getOfferDiscount();
    }

    abstract double getOfferDiscount();

    public List<CartItem> getCartItems() {
        return shoppingCart.getCartItems();
    }

    public String toString() {
        return shoppingCart.toString();
    }
}

