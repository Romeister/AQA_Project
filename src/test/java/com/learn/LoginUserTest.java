package com.learn;

import com.learn.base.BaseTest;
import com.learn.pages.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginUserTest extends BaseTest {

    @Test
    @Tag("loginUser_happypath_withDelete")
    void loginUser_happypath_withDelete()
    {
        //SHOULD CHANGE TO SECURE CREDENTIALS!!! , simple non-secure credentials for now.
       String email = "romeo@yahoo.com";
       String password = "romeo123";
       String name = "Romeo";

       //Handle HomePage
       HomePage home = new HomePage(page)
               .open()
               .handleConsent();


       assertTrue(home.isAtHomePage() , "User should be on Homepage");
       LoginSignupPage login = home.goToSignupLogin();

       //Handle Login
       assertTrue(login.isLoginToYourAccountVisible() ,
               "'Login to your account' text should be visible");

        login.startLogin(email , password);
        login.submitLogin();

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


    @Test
    @Tag("loginUser_happypath_withLogout")
    void loginUser_happypath_withLogout()
    {
        //SHOULD CHANGE TO SECURE CREDENTIALS!!! , simple non-secure credentials for now.
        String email = "romeo@yahoo.com";
        String password = "romeo123";
        String name = "Romeo";

        //Handle HomePage
        HomePage home = new HomePage(page)
                .open()
                .handleConsent();


        assertTrue(home.isAtHomePage() , "User should be on Homepage");
        LoginSignupPage login = home.goToSignupLogin();

        //Handle Login
        assertTrue(login.isLoginToYourAccountVisible() ,
                "'Login to your account' text should be visible");

        login.startLogin(email , password);
        login.submitLogin();

        assertTrue(page.locator("div.shop-menu.pull-right >> text=Logged in as " + name).isVisible(),
                "'Logged in as' " + name + " should be visible");

        //Logout account
        page.locator("div.shop-menu.pull-right >> text=Logout").click();

        //Verify if logged out (if page is back to Signup / Login)
        assertTrue(page.locator("div.shop-menu.pull-right >> text=Signup / Login").isVisible(),
                "'Signup / Login' should be visible again");
    }
}
