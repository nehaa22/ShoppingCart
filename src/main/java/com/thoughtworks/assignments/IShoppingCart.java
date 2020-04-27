package com.thoughtworks.assignments;

import java.util.List;

public interface IShoppingCart {
    void addCart(Product product, int quantity);

    double getSalesTax();

    double getTotalCartWithTax();

    double getDiscount();

    double getItemsTotal();

    List<CartItem> getCartItems();
}
