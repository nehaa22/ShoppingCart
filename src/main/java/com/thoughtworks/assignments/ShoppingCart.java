package com.thoughtworks.assignments;

import com.thoughtworks.assignments.Exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private ShoppingCartCalculator cartCalculator;
    private List<CartItem> cartItems = new ArrayList<>();


    ShoppingCart() {
        this.cartCalculator = new ShoppingCartCalculator();
    }

    public int getQuantity(String name) throws ProductNotFoundException {
        for (CartItem item : cartItems) {
            if (item.isExists(name)) {
                return item.getQuantity();
            }
        }
        throw new ProductNotFoundException();
    }

    public double getTotalCartWithTax() {
        return cartCalculator.getTotal();
    }

    public double getSalesTax() {
        return cartCalculator.getSalesTax();
    }

    public void addCart(Product product, int quantity) {
        updateQuantity(product, quantity);
        double amount = getProductTotal(product, quantity);
        cartCalculator.updateAmount(amount);
    }

    private void updateQuantity(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.isExists(product.getName())) {
                item.updateQuantity(quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    private double getProductTotal(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

    public void addCart(Product product, int quantity, String offer) {
        if (quantity == 2) {
            int totalQuantity = quantity + 1;
            updateQuantity(product, totalQuantity);
            double amount = getProductTotal(product, quantity);
            cartCalculator.updateAmount(amount);
        } else {
            int offerQuantity = quantity - 1;
            updateQuantity(product, quantity);
            double amount = getProductTotal(product, offerQuantity);
            cartCalculator.updateAmount(amount);
        }
    }

    public double getDiscount() {
        return 0.99;
    }

    @Override
    public String toString() {
        String message = "The cart contains ";
        int lengthOfProduct = cartItems.size();
        for (int cartIndex = 0; cartIndex < lengthOfProduct; cartIndex++) {
            CartItem cartItem = cartItems.get(cartIndex);
            Product product = cartItem.getProduct();
            if (lengthOfProduct == 1)
                return message.concat((cartItem.getQuantity()) + " " + product.getName() + " of " + product.getPrice() + " each");

            if (cartIndex == lengthOfProduct - 1) {
                message = message.concat(" and ");

            }
            message = message.concat((cartItem.getQuantity()) + " " + product.getName() + " of " + product.getPrice() + " each");
        }
        return message;
    }
}

