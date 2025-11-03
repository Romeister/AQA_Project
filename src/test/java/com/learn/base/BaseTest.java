package com.learn.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public abstract class BaseTest
{
    protected Playwright pw;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setup()
    {
        pw = Playwright.create();
        browser = pw.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
        context = browser.newContext();
        page = context.newPage();


    }

    @AfterEach
    void teardown()
    {
        if (context!=null) context.close();
        if (browser!=null) context.close();
        if (pw!=null) pw.close();
    }
}
