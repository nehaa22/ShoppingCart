package com.thoughtworks.assignments;

import com.thoughtworks.assignments.Exception.ProductNotFoundException;

public class ShoppingCart {

    private ShoppingCartCalculator cartCalculator;
    private CartItems cartItems;

    ShoppingCart() {
        this.cartCalculator = new ShoppingCartCalculator();
        this.cartItems = new CartItems();
    }

    public int getQuantity(String productName) throws ProductNotFoundException {
        return cartItems.quantityFor(productName);
    }

    public double getTotalCartWithTax() {
        return cartCalculator.getTotal();
    }

    public double getSalesTax() {
        return cartCalculator.getSalesTax();
    }

    public void addCart(Product product, int quantity) {
        cartItems.updatedQuantity(product,quantity);
        double amount = getProductTotal(product, quantity);
        cartCalculator.updateAmount(amount);
    }

    private double getProductTotal(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

    public void addCart(Product product, int quantity, String offer) {
        if (quantity == 2) {
            int totalQuantity = quantity + 1;
            cartItems.updatedQuantity(product,totalQuantity);
            double amount = getProductTotal(product, quantity);
            cartCalculator.updateAmount(amount);
        } else {
            int offerQuantity = quantity - 1;
            cartItems.updatedQuantity(product,quantity);
            double amount = getProductTotal(product, offerQuantity);
            cartCalculator.updateAmount(amount);
        }
    }

    public double getDiscount() {
        return 0.99;
    }

    @Override
    public String toString() {
        return cartItems.getContents();
    }
}

