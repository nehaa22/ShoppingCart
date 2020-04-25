package com.thoughtworks.assignments;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isExists(String productName) {
        return product.getName().equals(productName);
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }


}
