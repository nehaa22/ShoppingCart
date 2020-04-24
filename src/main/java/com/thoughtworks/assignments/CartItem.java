package com.thoughtworks.assignments;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isExists(String productName) {
        return product.getName().equals(productName);
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public Product getProduct() {
        return product;
    }
}
