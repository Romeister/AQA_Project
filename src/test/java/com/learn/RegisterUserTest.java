package com.learn;

import com.learn.base.BaseTest;
import com.learn.pages.*;
import com.learn.pages.HomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegisterUserTest extends BaseTest {

    @Test
    @Tag("registerUser_happypath")
    void registerUser_happypath()
    {
        String name = "Romeo";
        String email = "romeo@yahoo.com";
        String password = "romeo123";

        //Homepage handling
        HomePage home = new HomePage(page)
                .open()
                .handleConsent();

        assertTrue(home.assertHomepageTitle(), "Title should contain 'automation'");

        //Signup / Login handling
        LoginSignupPage auth = home.goToSignupLogin();
        assertTrue(auth.isNewUserSignupVisible(), "'New User Signup' should be visible");
        EnterAccountInfoPage form = auth.startSignup(name, email);
        auth.submitSignup();

        //Enter account info
        assertTrue(form.isHeaderVisible(), "'ENTER ACCOUNT INFORMATION' should be visible");
        form.fillAccountInformation(name , password , "1" , "1", "2000")
                .fillAddressInformation(
                        "Romeo", "Ast", "QASoft",
                        "New York City,101303", "Chicago,123554",
                        "United States", "New York", "New York City",
                        "101303", "+19999999999"
                        );
        form.submitCreateAccount();

        //Verify account created
        assertTrue(page.locator("text=ACCOUNT CREATED!").isVisible(),
                "'ACCOUNT CREATED' text should be visible");
        page.locator("[data-qa='continue-button']").click();
        assertTrue(page.locator("div.shop-menu.pull-right >> text=Logged in as " + name).isVisible(),
                "'Logged in as' " + name + " should be visible");

        //Delete account
        page.locator("div.shop-menu.pull-right >> text=Delete Account").click();
        assertTrue(page.locator("text=ACCOUNT DELETED!").isVisible(),
                "'ACCOUNT DELETED!' text should be visible");
        page.locator("[data-qa='continue-button']").click();

        //Verify if account got deleted (if page is back to Signup / Login)
        assertTrue(page.locator("div.shop-menu.pull-right >> text=Signup / Login").isVisible(),
                "'Signup / Login' should be visible again");
    }
}
