package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage extends BasePage {

    Locator loginLink;


    // Constructor to initialize the Page and locators
    public LandingPage() {

        loginLink = page.locator("//ul[@id='right-side-components']//a[contains(@class,'button-link') and @data-testid='login-header']");
    }

    // Open the website
    public void openWebsite() {
        page.navigate("https://calendly.com/");
    }

    // Click on the login link
    public void clickOnLoginLink() {
        loginLink.click();
    }

    // Check if the landing page is displayed
    public boolean isLandingPageDisplayed() {
        return loginLink.isVisible();
    }
}
