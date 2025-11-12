package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginSignupPage extends BasePage {
    private final Locator newUserTitle = page.locator("text=New User Signup!");
    private final Locator nameInput = page.locator("[data-qa='signup-name']");
    private final Locator emailInput = page.locator("[data-qa='signup-email']");
    private final Locator signupBtn = page.locator("button:has-text('Signup')");

    public LoginSignupPage(Page page) {
        super(page);
    }

    public boolean isNewUserSignupVisible()
    {
        return newUserTitle.isVisible();
    }

    public EnterAccountInfoPage startSignup (String name, String email)
    {
        nameInput.fill(name);
        emailInput.fill(email);
        return new EnterAccountInfoPage(page);
    }

    public void submitSignup()
    {
        signupBtn.click();
    }
}
