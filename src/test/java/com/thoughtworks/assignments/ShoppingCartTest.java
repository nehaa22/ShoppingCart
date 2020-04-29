package com.thoughtworks.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void givenShoppingCart_whenAddOneApple_ThenShouldReturnTotalCart()  {
        Product apple = new Product("Apple", 0.99);
        Cart shoppingCart = new Cart();
        shoppingCart.addCart(apple, 1);
        Assertions.assertEquals(0.02, shoppingCart.getSalesTax());
        Assertions.assertEquals(1.01, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=1}]}", shoppingCart.toString());
    }

    @Test
    public void givenShoppingCart_whenAddOneAppleWithFiveQuantity_ThenShouldReturnTotalCart() {
        Product apple = new Product("Apple", 0.99);
        Cart shoppingCart = new Cart();
        shoppingCart.addCart(apple, 5);
        Assertions.assertEquals(0.1, shoppingCart.getSalesTax());
        Assertions.assertEquals(5.05, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=5}]}", shoppingCart.toString());

    }

    @Test
    public void givenShoppingCart_whenAddOneMaskWithFiveQuantity_ThenShouldReturnTotalCart() {
        Product mask = new Product("Mask", 1.99);
        Cart shoppingCart = new Cart();
        shoppingCart.addCart(mask, 5);
        Assertions.assertEquals(0.2, shoppingCart.getSalesTax());
        Assertions.assertEquals(10.15, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Mask', price=1.99}, quantity=5}]}", shoppingCart.toString());

    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMask() {
        Product mask = new Product("Mask", 1.99);
        Product apple = new Product("Apple", 0.99);
        Cart shoppingCart = new Cart();
        shoppingCart.addCart(apple, 3);
        shoppingCart.addCart(mask, 3);
        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMaskIncludingTax() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        Cart shoppingCart = new Cart();
        shoppingCart.addCart(apple, 2);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(mask, 3);
        Assertions.assertEquals(0.18, shoppingCart.getSalesTax());
        Assertions.assertEquals(9.12, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=3}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
    }

    @Test
    public void givenShoppingCart_whenAddTwoApplesWithOffer_ThenShouldReturnTotalCartOfAppleIncludingTax()  {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        Cart shoppingCart = new BuyTwoGetThreeOffer(new Cart());
        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(mask, 3);
        Assertions.assertEquals(0.22, shoppingCart.getSalesTax());
        Assertions.assertEquals(10.13, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(1.98, shoppingCart.getDiscount());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=6}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
    }

    @Test
    public void givenShoppingCart_whenAddTwoApplesWithExtraOffer_ThenShouldReturnTotalCartOfAppleIncludingTax() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        Cart shoppingCart = new TenPercentOffOnCart(
                new BuyTwoGetThreeOffer(
                        new Cart()));
        shoppingCart.addCart(apple, 10);
        shoppingCart.addCart(mask, 3);
        Assertions.assertEquals(0.23, shoppingCart.getSalesTax());
        Assertions.assertEquals(11.84, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(4.26, shoppingCart.getDiscount());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
    }

    @Test
    public void givenShoppingCart_whenAddOneAppleFiveTimesWithExtraOffer_ThenShouldReturnTotalCartOfAppleIncludingTax() {
        Product apple = new Product("Apple", 0.99);
        Product mask = new Product("Mask", 1.99);
        Cart shoppingCart = new TenPercentOffOnCart(
                new BuyTwoGetThreeOffer(
                        new Cart()));
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 1);
        shoppingCart.addCart(apple, 5);
        shoppingCart.addCart(mask, 2);
        shoppingCart.addCart(mask, 1);

        Assertions.assertEquals(0.23, shoppingCart.getSalesTax());
        Assertions.assertEquals(11.84, shoppingCart.getTotalCartWithTax());
        Assertions.assertEquals(4.26, shoppingCart.getDiscount());
        Assertions.assertEquals("ShoppingCart{cartItems=[CartItem{product=Product{name='Apple', price=0.99}, quantity=10}, CartItem{product=Product{name='Mask', price=1.99}, quantity=3}]}", shoppingCart.toString());
    }
}