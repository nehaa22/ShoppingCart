package com.thoughtworks.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void givenShoppingCart_whenAddOneApple_ThenShouldReturnTotalCart() {
        Product productOne = new Product("apple",1,0.99);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(0.99, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddOneAppleWithFiveQuantity_ThenShouldReturnTotalCart() {
        Product productOne = new Product("apple",5,0.99);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(4.95, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddOneMaskWithFiveQuantity_ThenShouldReturnTotalCart() {
        Product productOne = new Product("mask",5,1.99);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(9.95, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMask(){
        Product productOne = new Product("apple",3,0.99);
        Product productTwo = new Product("mask",3,1.99);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        products.add(productTwo);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(8.94, cartTotal);
    }

    @Test
    public void givenShoppingCart_whenAddThreeMaskAndThreeApple_ThenShouldReturnTotalCartOfAppleAndMaskIncludingTax(){
        Product productOne = new Product("apple",3,0.99);
        Product productTwo = new Product("mask",3,1.99);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        products.add(productTwo);
        ShoppingCart shoppingCart = new ShoppingCart(products);
        double cartTotal = shoppingCart.calculateTotalCart();
        Assertions.assertEquals(9.12, cartTotal);
    }
}
