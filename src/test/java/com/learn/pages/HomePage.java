package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;


//Should probably add check login status here since it's used in 2 tests already.
//Should create separate delete account test/method to easily delete account. Implementation to be decided.
//Should change credential handling to be secure.

public class HomePage extends BasePage {
    private final String url = "https://automationexercise.com";


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
             return page.url().equalsIgnoreCase("https://automationexercise.com/");

        }
}
