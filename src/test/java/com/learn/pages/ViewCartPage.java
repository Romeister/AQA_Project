package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ViewCartPage extends BasePage {
private final String url = "https://automationexercise.com/view_cart";

    public ViewCartPage(Page page) {
        super(page);
    }

    public boolean isAtViewCartPage()
    {
        return page.url().equalsIgnoreCase(url);
    }
}
