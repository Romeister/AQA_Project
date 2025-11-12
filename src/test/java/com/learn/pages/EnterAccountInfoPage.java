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

    public EnterAccountInfoPage fillAccountInformation(String name, String password,
                                                       String dayValue, String monthValue, String yearValue)
    {
        page.locator("[id='id_gender1']").click();
        page.locator("[data-qa='name']").fill(name);
        //Email pre-filled by website from previous page
        page.locator("[data-qa='password']").fill(password);
        page.selectOption("[data-qa='days']" , dayValue);
        page.selectOption("[data-qa='months']" , monthValue);
        page.selectOption("[data-qa='years']" , yearValue);
        page.locator("[name='newsletter']").check();
        page.locator("[name='optin']").check();

        return this;
    }

    public EnterAccountInfoPage fillAddressInformation(String firstName, String lastName, String companyName,
                                                       String address, String address2, String country,
                                                       String state, String city, String zipcode,
                                                       String mobileNumber)
            /*
            Could change zipcode and mobileNumber to be int instead of String, to prevent incorrect entries?
            But some zipcodes could contain letters, and some forms require symbols like '+', so it will be decided on a case-by-case basis.
             */
    {
        page.locator("[name='first_name']").fill(firstName);
        page.locator("[name='last_name']").fill(lastName);
        page.locator("[name='company']").fill(companyName);
        page.locator("[name='address1']").fill(address);
        page.locator("[name='address2']").fill(address2);
        page.selectOption("[name='country']" , country);
        page.locator("[name='state']").fill(state);
        page.locator("[name='city']").fill(city);
        page.locator("[name='zipcode']").fill(zipcode);
        page.locator("[name='mobile_number']" ).fill(mobileNumber);

        return this;

    }
    public void submitCreateAccount()
    {
        page.locator("button:has-text('Create Account')").click();
    }
}
