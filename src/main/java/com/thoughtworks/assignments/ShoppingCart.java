package com.thoughtworks.assignments;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private ShoppingCartCalculator cartCalculator;
    private Map<String, Integer> productQuantities = new HashMap<>();


    ShoppingCart() {
        this.cartCalculator = new ShoppingCartCalculator();
    }

    public int getQuantity(String name) {
        return productQuantities.get(name);
    }

    public double getTotalCartWithTax() {
        return cartCalculator.getTotal();
    }

    public double getSalesTax() {
        return cartCalculator.getSalesTax();
    }

    public void addCart(Product product, int quantity) {
        incrementQuantity(product, quantity);
        double amount = getProductTotal(product, quantity);
        cartCalculator.updateAmount(amount);
    }

    private void incrementQuantity(Product product, int quantity) {
        if (productQuantities.containsKey(product.getName())) {
            Integer existingQuantity = productQuantities.get(product.getName());
            productQuantities.put(product.getName(), existingQuantity + quantity);
            return;
        }
        productQuantities.put(product.getName(), quantity);
    }

    private double getProductTotal(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

    public void addCart(Product product, int quantity, String offer) {

        int offerQuantity = 2;
        int freeQuantity = 1;

        int totalQuantity = offerQuantity + freeQuantity;

        incrementQuantity(product, totalQuantity);

        double amount = getProductTotal(product, offerQuantity);
        double extraAmount = getProductTotal(product, freeQuantity);


        cartCalculator.updateAmount(amount);
    }
}

