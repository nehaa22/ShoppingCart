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
    private  double itemsTotalWithOffer= 0.0;
    private double itemsTotalWithoutOffer = 0.0;
    double discount = 0;

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

    private CartItem cartItemForOfferIn(Product product, int quantity) {

        int freeQuantity = 1;
        int offerQuantity;

        CartItem cartItem;
        CartItem cartItemWithOffer = null;

        cartItem = new CartItem(product, quantity);
        if (quantity % 2 != 0) {
            offerQuantity = quantity + freeQuantity;
            itemsTotalWithoutOffer += cartItem.getPrice() - product.getPrice();
        } else {
            itemsTotalWithoutOffer += cartItem.getPrice();
            offerQuantity = quantity;

        }

        if (quantity > 2) {
            cartItemWithOffer = new CartItem(product, offerQuantity);
            itemsTotalWithOffer = cartItemWithOffer.getPrice();

            discount = itemsTotalWithOffer - itemsTotalWithoutOffer;
            itemsTotal = itemsTotalWithoutOffer - discount;

            tax = format(itemsTotal * SALES_TAX_PERCENT);
            total = format(itemsTotal + tax);

            for (CartItem item : cartItems) {
                if (item.isExists(product.getName())) {
                    cartItemWithOffer = item;
                    break;
                }
            }
        }
        return cartItemWithOffer;

    }

    public void addCart(Product product, int quantity, String offer) {
        CartItem cartItem = cartItemForOfferIn(product, quantity); //1

        if (!cartItems.contains(cartItem)) {
            cartItems.add(cartItem);
            return;
        }
        cartItem.incrementQuantity(quantity);
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




