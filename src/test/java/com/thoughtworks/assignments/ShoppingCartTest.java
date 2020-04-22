package com.thoughtworks.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void givenShoppingCart_whenAddOneApple_ThenShouldReturnTotalCart() {
        Product apple = new Apple();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple,1);
        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1,shoppingCart.getQuantity(apple));
    }

    @Test
    public void givenShoppingCart_whenAddOneAppleWithFiveQuantity_ThenShouldReturnTotalCart() {
        Product apple = new Apple();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple,5);
        Assertions.assertEquals(0.1, shoppingCart.getSalesTax());
        Assertions.assertEquals(5.05, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(5,shoppingCart.getQuantity(apple));

    }

    @Test
    public void givenShoppingCart_whenAddOneMaskWithFiveQuantity_ThenShouldReturnTotalCart() {
        Product mask = new Mask();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(mask,5);
        Assertions.assertEquals(0.2, shoppingCart.getSalesTax());
        Assertions.assertEquals(10.15,shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(5,shoppingCart.getQuantity(mask));
    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMask(){
        Product apple = new Apple();
        Product mask = new Mask();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple,3);
        shoppingCart.addCart(mask,3);
        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity(mask));
        Assertions.assertEquals(3, shoppingCart.getQuantity(apple));

    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMaskIncludingTax(){

        Product apple = new Apple();
        Product mask = new Mask();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple,2);
        shoppingCart.addCart(apple,1);
        shoppingCart.addCart(mask,3);
        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity(mask));
        Assertions.assertEquals(3, shoppingCart.getQuantity(apple));
    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndFiveAppleWithOffer_ThenShouldReturnTotalCartOfAppleAndMaskIncludingTax(){

        Product apple = new Apple();
        Product mask = new Mask();
        AppleBuyThreeForTwo offer = new AppleBuyThreeForTwo();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCart(apple,5, offer);
        shoppingCart.addCart(mask,3);
        Assertions.assertEquals(0.16, shoppingCart.getSalesTax());
        Assertions.assertEquals(8.11, shoppingCart.getTotalCart());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(3, shoppingCart.getQuantity(mask));
        Assertions.assertEquals(5, shoppingCart.getQuantity(apple));
    }
}
