package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage extends BasePage {

    private final String url = "https://automationexercise.com/products";

    public ProductsPage(Page page) {
        super(page);
    }

    public boolean isAtProductsPage()
    {
        return page.url().equalsIgnoreCase(url);
    }



}
