package com.thoughtworks.assignments;

import java.util.List;

public interface IShoppingCart {

    double SALES_TAX_PERCENT = 0.02;

    void addCart(Product product, int quantity);

    double getSalesTax();

    double getTotalCartWithTax();

    double getDiscount();

    double getItemsTotal();

    List<CartItem> getCartItems();
}