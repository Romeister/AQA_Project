package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;


//TODO Should probably add check login status here since it's used in 2 tests already.
//TODO Should create separate delete account test/method to easily delete account. Implementation to be decided.
//TODO Should change credential handling to be secure.

public class HomePage extends BasePage {
    //URL locators
    private final String url = "https://automationexercise.com/";
    //Button locators
    private final Locator productsBtn = page.locator("div.shop-menu.pull-right >> text=Products");


    public HomePage(Page page) {
        super(page);
    }

    public HomePage open()
    {
        page.navigate(url);
        return this;
    }

    public HomePage handleConsent()
        {
            if (page.locator(".fc-consent-root button:has-text('Consent')").isVisible())
                page.locator(".fc-consent-root button:has-text('Consent')").click();
            return this;
        }

        public LoginSignupPage goToSignupLogin()
        {
            page.locator("text= Signup / Login").click();
            return new LoginSignupPage(page);
        }

        public boolean isAtHomePage()
        {
             return page.url().equalsIgnoreCase(url);

        }

        public ProductsPage clickProductsBtn()
        {
            productsBtn.click();
            return new ProductsPage(page);
        }

        public void checkLogs()
        {
            System.out.println("Expected: " + url);
            System.out.println("Actual:   " + page.url());

        }
}
