package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.List;

public abstract class Offer implements IShoppingCart {
    protected final IShoppingCart shoppingCart;

    Offer(IShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addCart(Product product, int quantity) {
        shoppingCart.addCart(product, quantity);
    }

    @Override
    public double getItemsTotal() {
        double discount = getOfferDiscount();
        double itemTotal = format(shoppingCart.getItemsTotal() - discount);
        return itemTotal;
    }

    @Override
    public double getSalesTax() {
        double salesTax = format(getItemsTotal() * 0.02);
        return salesTax;
    }

    @Override
    public double getTotalCartWithTax() {
        double total = format(getItemsTotal() + getSalesTax());
        return total;
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

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }

    @Override
    public String toString() {
        return shoppingCart.toString();
    }
}
