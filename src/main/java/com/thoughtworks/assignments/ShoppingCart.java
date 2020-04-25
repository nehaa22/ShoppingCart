package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final double SALES_TAX_PERCENT = 0.02;
    private List<CartItem> cartItems;
    private double total = 0.0;
    private double itemsTotal = 0.0;
    private double tax;

    ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public double getTotalCartWithTax() {
        return this.total;
    }

    public double getSalesTax() {
        return this.tax;
    }

    public void addCart(Product product, int quantity) {
        CartItem cartItem = cartItemFor(product, quantity); //1

        if (!cartItems.contains(cartItem)) {
            cartItems.add(cartItem);
            return;
        }
        cartItem.incrementQuantity(quantity);

    }

    private CartItem cartItemFor(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        itemsTotal += cartItem.getPrice();
        tax = format(itemsTotal * SALES_TAX_PERCENT);
        total = format(itemsTotal + tax);

        for (CartItem item : cartItems) {
            if (item.isExists(product.getName())) {
                cartItem = item;
                break;
            }
        }
        return cartItem;
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartItems=" + cartItems +
                '}';
    }


}




