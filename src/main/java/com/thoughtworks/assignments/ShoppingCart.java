package com.thoughtworks.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.thoughtworks.assignments.Formatter.format;

public class ShoppingCart implements IShoppingCart {
    protected List<CartItem> cartItems;
    protected double itemsTotal = 0.0;
    private double tax;

    ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public double getItemsTotal() {
        return this.itemsTotal;
    }

    @Override
    public List<CartItem> getCartItems() {
        return Collections.unmodifiableList(cartItems);
    }

    public double getTotalCartWithTax() {
        return format(getItemsTotal() + tax);
    }

    public double getSalesTax() {
        tax = format(getItemsTotal() * SALES_TAX_PERCENT);
        return this.tax;
    }

    public void addCart(Product product, int quantity) {
        CartItem cartItem = cartItemFor(product, quantity);

        if (!cartItems.contains(cartItem)) {
            cartItems.add(cartItem);
            return;
        }
        cartItem.incrementQuantity(quantity);
    }

    private CartItem cartItemFor(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        itemsTotal += cartItem.getPrice();

        for (CartItem item : cartItems) {
            if (item.isExists(product.getName())) {
                cartItem = item;
                break;
            }
        }
        return cartItem;
    }

    public double getDiscount() {
        double discount = 0;
        return format(discount);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartItems=" + cartItems +
                '}';
    }
}