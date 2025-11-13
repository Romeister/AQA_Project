package com.learn;

import com.learn.base.BaseTest;
import com.learn.pages.*;
import com.learn.pages.HomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTests extends BaseTest {

    @Test
    void addProductsInChart()
    {
        HomePage home = new HomePage(page)
                .open()
                .handleConsent();

        assertTrue(home.isAtHomePage(), "User should be on Homepage");

        ProductsPage products = home.clickProductsBtn();

        assertTrue(products.isAtProductsPage(), "User should be on products page");

        page.hover("div.sing");

    }

}
