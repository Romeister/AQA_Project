package com.learn;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PlaywrightTest {

    @Test
    void openHomeAndCheckTitle() {
        // 1) Start the Playwright engine. try-with-resources will auto-close it.
        try (Playwright pw = Playwright.create()) {

            // 2) Launch a real browser (Chromium). setHeadless(false) = show the UI.
            Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
                    //.setSlowMo(2000));

            // 3) Create an isolated context (like a fresh incognito window).
            BrowserContext context = browser.newContext();

            // 4) Open a new tab (Page).
            Page page = context.newPage();

            // 5) Navigate to the site. Playwright waits for the page to load.
            page.navigate("https://automationexercise.com/");

            // 6) Read the document title and print it.
            String title = page.title();
            System.out.println("Page title = " + title);

            // 7) A tiny assertion: title should contain 'Automation'.
            assertTrue(title.toLowerCase().contains("automation"),
                    "Title should mention 'Automation'");

            // 8) Close context and browser (cleanup).
            context.close();
            browser.close();
        }
    }

    @Test
    @Tag("RegisterTest")
    void registerUser() {
        //Starting Playwright engine.
        try (Playwright pw = Playwright.create()) {

            //Launching Browser (Firefox), show UI.
            Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(1000));

            //Create Context
            BrowserContext context = browser.newContext();

            //Open new page
            Page page = context.newPage();

            //Navigate to specified URL.
            page.navigate("https://automationexercise.com");

            //Read title and check if it contains specified text
            String title = page.title();
            assertTrue(title.toLowerCase().contains("automation"), "Title should contain 'automation'");

            //Handle consent window
            page.locator(".fc-consent-root button:has-text('Consent')").click();

            //Navigate to signup/login page and assert
            page.locator("text= Signup / Login").click();
            assertTrue(page.locator("text=New User Signup!").isVisible());

            //Fill name,email and click
            page.locator("[data-qa='signup-name']").fill("Romeo");
            page.locator("[data-qa='signup-email']").fill("romeo@yahoo.com");
            page.locator("button:has-text('Signup')").click();

            //Assert specified text present
            assertTrue(page.locator("text=ENTER ACCOUNT INFORMATION").isVisible());
            //Fill title, name,password and date of birth
            page.locator("[id='id_gender1']").click();
            page.locator("[data-qa='name']").fill("Romeo");
            page.locator("[data-qa='password']").fill("romeo123");

            //Handle date of birth dropdowns using selectOption
            page.selectOption("[data-qa='days']" , "1");
            page.selectOption("[data-qa='months']" , "1");
            page.selectOption("[data-qa='years']" , "2000");

            //Handle newsletter and special offers checks
            page.locator("[name='newsletter']").check();
            page.locator("[name='optin']").check();

            //Fill firstname,lastname,company,address,address2,country,state,city,zipcode,mobile number
            page.locator("[name='first_name']").fill("Romeo");
            page.locator("[name='last_name']").fill("Ast");
            page.locator("[name='company']").fill("QASoft");
            page.locator("[name='address1']").fill("New York City,101303");
            page.locator("[name='address2']").fill("Chicago,123554");
            page.selectOption("[name='country']" , "United States");
            page.locator("[name='state']").fill("New York");
            page.locator("[name='city']").fill("New York City");
            page.locator("[name='zipcode']").fill("101303");
            page.locator("[name='mobile_number']" ).fill("+19999999999");

            //Click create acoount button
            page.locator("button:has-text('Create Account')").click();



            assertTrue(page.locator("text=ACCOUNT CREATED!").isVisible());
            //page.waitForTimeout(3000000);

            page.locator("button:has-text('Continue')").click();
            page.locator("button:has-text('Delete Account')"); //should check for logged in as here

            assertTrue(page.locator("ACCOUNT DELETED!").isVisible());
            page.locator("data-qa='continue-button'").click();

            assertTrue(page.locator("button:has-text('Signup / Login')").isVisible());



        }
    }
}
