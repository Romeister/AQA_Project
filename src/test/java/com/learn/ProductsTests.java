package com.learn;

import com.learn.base.BaseTest;
import com.learn.pages.*;
import com.learn.pages.HomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTests extends BaseTest {

    @Test
    void addProductsInCart()
    {   //Open homepage and handle consent
        HomePage home = new HomePage(page)
                .open()
                .handleConsent();

        assertTrue(home.isAtHomePage(), "User should be on Homepage");

        //Go to ProductsPage
        ProductsPage products = home.clickProductsBtn();
        assertTrue(products.isAtProductsPage(), "User should be on products page");

        //Add Features Items to chart (Some i
        products.addProductsToCart("1","5" ,"8");

        //Go to View Cart page
        ViewCartPage cart = products.goToViewCartPage();
        assertTrue(cart.isAtViewCartPage(), "User should be on View Cart page");
        /*
        TODO verify if the products are added to cart, and verify their prices, quantity and total price.
         Perhaps a separate method that retains these details and compares with what is found in the cart?
        */



    }

}
