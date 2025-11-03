package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Page;

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
}
