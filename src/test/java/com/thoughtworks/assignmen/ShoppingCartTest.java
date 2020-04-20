package com.thoughtworks.assignmen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void givenShoppingCart_whenAddOneItem_ThenShouldReturnTotalCart() {
        ShoppingCart shoppingCart = new ShoppingCart("apple",1,0.99);
        double cartTotal = shoppingCart.calculateCartTotal();
        Assertions.assertEquals(0.99, cartTotal);
    }
}
