package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EnterAccountInfoPage extends BasePage {
    private final Locator header = page.locator("text=ENTER ACCOUNT INFORMATION");

    public boolean isHeaderVisible()
    {
        return header.isVisible();
    }



    public EnterAccountInfoPage (Page page)
    {
        super(page);
    }
}
