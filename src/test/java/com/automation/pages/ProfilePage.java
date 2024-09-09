package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class ProfilePage extends BasePage {

    Locator profilePageTitle;
    Locator uploadPictureBtn;
    Locator applyBtn;
    Locator profileImage;
    Locator saveChangesBtn;
    Locator savedMsg;
    Locator logoutLink;
    Locator nameInput;
    Locator textareaInput;

    Page page;

    public ProfilePage(Page page) {
        this.page = page;
        profilePageTitle = page.locator("//div/h1");
        uploadPictureBtn = page.locator("//div[@data-component='avatar-editor']//label/span/input");
        applyBtn = page.locator("//div/button/span[contains(text(),'Apply')]");
        profileImage = page.locator("//div[@data-component='avatar-editor']//img");
        saveChangesBtn = page.locator("//div/button/span[contains(text(),'Save')]");
        savedMsg = page.locator("//div[@aria-live='polite']");
        logoutLink = page.locator("//a/span[contains(text(),'Logout')]");
        nameInput = page.locator("//input[@name='name']");
        textareaInput = page.locator("//textarea[@type='textarea']");
    }

    public boolean isProfilePageDisplayed() {
        return profilePageTitle.textContent().equals("Profile");
    }

    public void clickOnUploadBtn(String path) {
        uploadPictureBtn.setInputFiles(Paths.get(System.getProperty("user.dir") + path));
        applyBtn.click();
    }

    public boolean isProfileChanged() {
        return profileImage.getAttribute("src").contains("data:image/png");
    }

    public void clickOnSaveChangesButton() {
        saveChangesBtn.click();
    }

    public boolean isChangesSaved() {
        System.out.println(savedMsg.textContent());
        return savedMsg.textContent().equals("Your settings have been saved!");
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public void enterUpdateName(String updatedName) {
        nameInput.fill(updatedName);
    }

    public void enterUpdateMsg(String updatedMsg) {
        textareaInput.fill(updatedMsg);
    }
}
