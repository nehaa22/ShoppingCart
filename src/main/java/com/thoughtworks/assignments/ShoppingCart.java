package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart implements IShoppingCart {
    private static final double SALES_TAX_PERCENT = 0.02;
    protected List<CartItem> cartItems;
    private double total = 0.0;
    protected double itemsTotal = 0.0;
    private double tax;
    private double itemsTotalWithoutOffer = 0;
    private double itemsTotalWithOffer = 0;
    private double discount = 0;

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
        total = format(getItemsTotal() + tax);
        return this.total;
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
        return format(discount);
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