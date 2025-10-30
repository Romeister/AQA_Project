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
                    .setHeadless(false)
                    .setSlowMo(2000));

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
        try (Playwright pw = Playwright.create()) {

            Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(1000));

            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.navigate("https://automationexercise.com");

            String title = page.title();

            assertTrue(title.toLowerCase().contains("automation"), "Title should contain 'automation'");

            page.locator(".fc-consent-root button:has-text('Consent')").click();

            page.locator("text= Signup / Login").click();

            assertTrue(page.locator("text=New User Signup!").isVisible());


            page.locator("[data-qa='signup-name']").fill("Romeo");
            page.locator("[data-qa='signup-email']").fill("romeo@yahoo.com");
            page.locator("button:has-text('Signup')").click();

            assertTrue(page.locator("text=ENTER ACCOUNT INFORMATION").isVisible());


        }
    }
}
