package com.thoughtworks.assignments;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private double itemsTotal = 0.0;
    private static final double salesTaxPercent = 0.02;
    private double total = 0.0;
    Map<String, Integer> productQuantities = new HashMap<>();
//    AppleBuyThreeForTwo offer = new AppleBuyThreeForTwo();

//    public double getTotal() {
//        return total;
//    }

    public int getQuantity(String  name) {
        return productQuantities.get(name);
    }

    public double getTotalCartWithTax() {
        return total;
    }

    public double getSalesTax() {
        return format(total - itemsTotal);
    }

    public void addCart(Product product, int quantity) {
        incrementQuantity(product, quantity);
        itemsTotal += getProductTotal(product, quantity);
        total = format(itemsTotal * (1 + salesTaxPercent));
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

    private double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }

//    public void addCart(Product product, int quantity,String offer) {
//        double extraTotalCart = 0;
//        int offerQuantity = 2;
//        incrementQuantity(product, quantity);
//        totalCart += getProductTotal(product, offerQuantity);
//        offerQuantity++;
//
//            extraTotalCart = totalCart + getProductTotal(product, 1);
//
//        }


//        double finalPrice = totalCart/extraTotalCart * 100;

//    }
}

