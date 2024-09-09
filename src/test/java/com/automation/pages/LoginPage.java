package com.automation.pages;

import com.microsoft.playwright.Page;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;


public class LoginPage extends BasePage {

    Locator loginBtn;
    Locator emailInput;
    Locator passwordInput;
    Locator continueBtn;
    Locator noSuchAccount;
    Locator cookieAccept;

    public LoginPage() {

        loginBtn = page.locator("//button[@data-testid='primary-button']");
        emailInput = page.locator("//div[@data-testid='email-input']/input");
        passwordInput = page.locator("//form//input");
        continueBtn = page.locator("//button/span[text()='Continue']");
        noSuchAccount = page.locator("//form/div/div/div[text()]");
        cookieAccept = page.locator("#onetrust-accept-btn-handler");
    }


    public void enterEmail(String email) {
        emailInput.fill(email);
    }


    public void enterPassword(String password) {
        passwordInput.fill(password);
    }


    public void clickOnLoginBtn() {
        loginBtn.click();
    }


    public boolean isLoginBtnDisplayed() {

        page.waitForSelector("//button[@data-testid='primary-button']",new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        return loginBtn.isVisible();
    }


    public boolean isNoSuchAccountDisplayed() {
        return noSuchAccount.isVisible();
    }


    public void clickOnContinue() {
        continueBtn.click();
    }


    public void acceptCookies() {
        cookieAccept.click();
    }
}
