package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private double totalCart = 0.0;
    private static final double salesTaxPercent = 1.02;
    private double cartAmountWithTax = 0.0;
    Map<Product, Integer> productQuantities = new HashMap<>();

    public double getTotalCart() {
        return totalCart;
    }

    public int getQuantity(Product product){
        return productQuantities.get(product);
    }

    public double getTotalCartWithTax() {
        return cartAmountWithTax;
    }

    public double getSalesTax() {
        return format(cartAmountWithTax - totalCart);
    }

    public void addCart(Product product, int quantity) {
        incrementQuantity(product, quantity);
        totalCart += getProductTotal(product, quantity);
        cartAmountWithTax = format(totalCart * salesTaxPercent);
    }

    private void incrementQuantity(Product product, int quantity) {
        if(productQuantities.containsKey(product)){
            Integer existingQuantity = productQuantities.get(product);
            productQuantities.put(product, existingQuantity + quantity);
            return;
        }
        productQuantities.put(product,quantity);
    }

    private double getProductTotal(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}

