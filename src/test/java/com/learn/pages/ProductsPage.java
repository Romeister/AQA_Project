package com.learn.pages;

import com.learn.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsPage extends BasePage {

    private final String url = "https://automationexercise.com/products";
    private final Locator viewCartBtn = page.locator("div.shop-menu.pull-right >> text=Cart");

    public ProductsPage(Page page) {
        super(page);
    }

    public boolean isAtProductsPage() {
        return page.url().equalsIgnoreCase(url);
    }

    //TODO Handle case where there is a product missing, for example: id=10 has no product, test stalls
    private ProductsPage hoverAndClickProducts(String id) {
        page.hover("div.features_items >> [data-product-id='" + id + "']");
        page.click("[data-product-id='" + id + "']");
        return this;
    }

    public ProductsPage addProductsToCart(String... productIDs)
    {
        for (String id : productIDs)
        {
            hoverAndClickProducts(id);
            assertTrue(isSuccessModalPresent(), "Success modal should be present");
            handleSuccessModalContinueShopping();

        }
        return this;
    }

    public boolean isSuccessModalPresent()
    {
        return page.locator("div.modal-body >> text=Your product has been added to cart.").isVisible();
    }

    public ProductsPage handleSuccessModalContinueShopping()
    {
        page.locator("div.modal-content >> button:has-text('Continue Shopping')").click();
        return this;
    }

    public ViewCartPage goToViewCartPage()
    {
        viewCartBtn.click();
        return new ViewCartPage(page);
    }
}
