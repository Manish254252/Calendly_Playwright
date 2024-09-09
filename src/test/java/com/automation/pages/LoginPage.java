package com.automation.pages;

import com.microsoft.playwright.Page;


import com.microsoft.playwright.Locator;


public class LoginPage extends BasePage {

    Locator loginBtn;
    Locator emailInput;
    Locator passwordInput;
    Locator continueBtn;
    Locator noSuchAccount;
    Locator cookieAccept;

    public LoginPage() {
        // Initializing locators
        loginBtn = page.locator("//button[@data-testid='primary-button']");
        emailInput = page.locator("//div[@data-testid='email-input']/input");
        passwordInput = page.locator("//form//input");
        continueBtn = page.locator("//button/span[text()='Continue']");
        noSuchAccount = page.locator("//form/div/div/div[text()]");
        cookieAccept = page.locator("#onetrust-accept-btn-handler");
    }

    // Enter email
    public void enterEmail(String email) {
        emailInput.fill(email);
    }

    // Enter password
    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    // Click on the login button
    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    // Check if the login button is displayed
    public boolean isLoginBtnDisplayed() {
        return loginBtn.isVisible();
    }

    // Check if "No such account" message is displayed
    public boolean isNoSuchAccountDisplayed() {
        return noSuchAccount.isVisible();
    }

    // Click on the Continue button
    public void clickOnContinue() {
        continueBtn.click();
    }

    // Accept cookies
    public void acceptCookies() {
        cookieAccept.click();
    }
}
