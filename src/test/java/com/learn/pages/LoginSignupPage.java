package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginSignupPage extends BasePage {
    //Text locators
    private final Locator newUserTitle = page.locator("text=New User Signup!");
    private final Locator loginUserTitle = page.locator("text=Login to your account");
    private final Locator loginError = page.locator("div.login-form >> text=Your email or password is incorrect!");

    //Signup locators
    private final Locator signupNameInput = page.locator("[data-qa='signup-name']");
    private final Locator signupEmailInput = page.locator("[data-qa='signup-email']");
    private final Locator signupBtn = page.locator("button:has-text('Signup')");

    // Login locators
    private final Locator loginEmailInput = page.locator("[data-qa='login-email']");
    private final Locator loginPasswordInput = page.locator("[data-qa='login-password']");
    private final Locator loginBtn = page.locator("button:has-text('Login')");

    public LoginSignupPage(Page page) {
        super(page);
    }

    public boolean isNewUserSignupVisible()
    {
        return newUserTitle.isVisible();
    }

    public boolean isLoginToYourAccountVisible()
    {
        return loginUserTitle.isVisible();
    }

    public boolean isLoginErrorVisisble()
    {
        return loginError.isVisible();
    }

    public EnterAccountInfoPage startSignup (String name, String email)
    {
        signupNameInput.fill(name);
        signupEmailInput.fill(email);
        return new EnterAccountInfoPage(page);
    }

    public void submitSignup()
    {
        signupBtn.click();
    }

    public LoginSignupPage startLogin (String email, String password)
    {
        loginEmailInput.fill(email);
        loginPasswordInput.fill(password);
        return this;
    }

    public void submitLogin()
    {
        loginBtn.click();
    }

}
