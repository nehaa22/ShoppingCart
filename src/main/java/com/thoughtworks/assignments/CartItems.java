package com.thoughtworks.assignments;

import com.thoughtworks.assignments.Exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CartItems {

    private List<CartItem> cartItems = new ArrayList<>();

    public void updatedQuantity(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.isExists(product.getName())) {
                item.updateQuantity(quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public int quantityFor(String name) throws ProductNotFoundException {
        for (CartItem item : cartItems) {
            if (item.isExists(name)) {
                return item.getQuantity();
            }
        }
        throw new ProductNotFoundException();
    }

    public String getContents() {
        String message = "The cart contains ";
        int lengthOfProduct = cartItems.size();
        for (int cartIndex = 0; cartIndex < lengthOfProduct; cartIndex++) {
            CartItem cartItem = cartItems.get(cartIndex);
            Product product = cartItem.getProduct();
            if (lengthOfProduct == 1)
                return message.concat((cartItem.getQuantity()) + " " + product.getName() + " of " + product.getPrice() + " each");

            if (cartIndex == lengthOfProduct - 1) {
                message = message.concat(" and ");

            }
            message = message.concat((cartItem.getQuantity()) + " " + product.getName() + " of " + product.getPrice() + " each");
        }
        return message;
    }
}
