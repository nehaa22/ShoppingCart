package com.thoughtworks.assignments;

import java.util.HashMap;
import java.util.List;
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

    public String getContent(List<Product> products) {
        String message = "The cart contains ";
        for (int index = 0; index < products.size(); index++) {
            Product product = products.get(index);
            if (products.size() == 1)
                return message.concat(productQuantities.get(product.getName()) + " " + product.getName() + " of " + product.getPrice() + " each");

            if (index == products.size() - 1) {
                message = message.concat(" and ");
            }
            message = message.concat(productQuantities.get(product.getName()) + " " + product.getName() + " of " + product.getPrice() + " each");
        }
        return message;
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
        if (quantity == 2) {
            int totalQuantity = quantity + 1;
            incrementQuantity(product, totalQuantity);
            double amount = getProductTotal(product, quantity);
            cartCalculator.updateAmount(amount);
        } else {
            int offerQuantity = quantity - 1;
            incrementQuantity(product, quantity);
            double amount = getProductTotal(product, offerQuantity);
            cartCalculator.updateAmount(amount);
        }
    }

    public double getDiscount() {
        return 0.99;
    }


}

