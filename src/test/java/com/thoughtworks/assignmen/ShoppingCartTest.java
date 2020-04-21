package com.thoughtworks.assignmen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void givenShoppingCart_whenAddOneApple_ThenShouldReturnTotalCart() {
        ShoppingCart shoppingCart = new ShoppingCart("apple",1,0.99);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(0.99, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddOneAppleWithFiveQuantity_ThenShouldReturnTotalCart() {
        ShoppingCart shoppingCart = new ShoppingCart("apple",5,0.99);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(4.95, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddOneMaskWithFiveQuantity_ThenShouldReturnTotalCart() {
        ShoppingCart shoppingCart = new ShoppingCart("mask",5,1.99);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(9.95, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMask(){
        Product productOne = new Product("apple",1,0.99);
        Product productTwo = new Product("apple",1,0.99);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        products.add(productTwo);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(0.99, cartTotal);

    }
}
