package com.thoughtworks.assignmen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void givenShoppingCart_whenAddOneApple_ThenShouldReturnTotalCart() {
        ShoppingCart shoppingCart = new ShoppingCart("apple",1,0.99);
        double cartTotal = shoppingCart.calculateCartTotal();
        Assertions.assertEquals(0.99, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddOneAppleWithFiveQuantity_ThenShouldReturnTotalCart() {
        ShoppingCart shoppingCart = new ShoppingCart("apple",5,0.99);
        double cartTotal = shoppingCart.calculateCartTotal();
        Assertions.assertEquals(4.95, cartTotal);
    }
}
