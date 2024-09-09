package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class RoutingPage extends BasePage {

    Locator newRoutingFormBtn;
    Locator routingPageTitle;
    Locator createNewFormBtn;
    Locator newFormPopUpHeading;
    Locator formNameInput;
    Locator createFormBtn;
    Locator formHeadingName;
    Locator addAQuestionBtn;
    Locator nameOption;
    Locator emailOption;
    Locator questionInput;
    Locator saveBtn;
    Locator changesSavedMsg;
    Locator nextBtn;
    Locator publishFormBtn;
    Locator copyPopUp;
    Locator copyLinkBtn;
    Locator closeBtn;
    Locator addedSectionList;
    Locator formNameList;
    Locator optionsList;
    Locator deleteOption;
    Locator deleteConfirmationBtn;



    public RoutingPage() {

        newRoutingFormBtn = page.locator("//span[contains(text(),'routing form')]");
        routingPageTitle = page.locator("//div[@data-component='main']//h1");
        createNewFormBtn = page.locator("//button/span[text() = 'Create a new form']");
        newFormPopUpHeading = page.locator("//div[@role='dialog']//h1");
        formNameInput = page.locator("//input[@placeholder='Routing form name']");
        createFormBtn = page.locator("//span[contains(text(),'Create form')]");
        formHeadingName = page.locator("//div[@data-component='main']//h1");
        addAQuestionBtn = page.locator("//button[contains(text(), 'Add a question')]");
        nameOption = page.locator("//button[@role='menuitem']/div[contains(text(), 'Name')]");
        emailOption = page.locator("//button[@role='menuitem']/div[contains(text(), 'Email')]");
        questionInput = page.locator("//input[@placeholder='Write a question']");
        saveBtn = page.locator("//span[text()='Save']");
        changesSavedMsg = page.locator("//div[@aria-live='polite']");
        nextBtn = page.locator("//div[@data-component='sticky-footer']//button/span[text()='Next']");
        publishFormBtn = page.locator("//span[text()='Publish form']");
        copyPopUp = page.locator("//div[@role='dialog']//p[contains(text(),'Copy')]");
        copyLinkBtn = page.locator("//span[contains(text(),'Copy link')]");
        closeBtn = page.locator("//span[contains(text(),'Close')]");
        addedSectionList = page.locator("//div[@aria-disabled='false']//label");
        formNameList = page.locator("//tbody//tr//p//a");
        optionsList = page.locator("//tbody//tr//td//button[@aria-label='Options']");
        deleteOption = page.locator("//tbody//tr//td//div//button//div[contains(text(),'Delete')]");
        deleteConfirmationBtn = page.locator("//div[@role='dialog']//button/span[contains(text(),'Delete')]");
    }

    public boolean isRoutingPageDisplayed() {
        return newRoutingFormBtn.isVisible() && routingPageTitle.textContent().equals("Routing");
    }

    public void clickOnNewRoutingButton() {
        newRoutingFormBtn.click();
    }

    public void clickOnCreateNewForm() {
        createNewFormBtn.click();
    }

    public boolean isRoutingFormPopUpDisplayed() {
        return newFormPopUpHeading.textContent().equals("New routing form");
    }

    public void enterRoutingName(String routingName) {
        formNameInput.fill(routingName);
    }

    public void clickOnCreateFormBtn() {
        createFormBtn.click();
    }

    public void clickOnAddQuestionButton() {
        addAQuestionBtn.click();
    }

    public void selectNameOption() {
        nameOption.click();
    }

    public void enterQuestion(String nameQuestion) {
        questionInput.fill(nameQuestion);
    }

    public void clickOnSaveBtn() {
        saveBtn.click();
    }

    public void selectEmailOption() {
        emailOption.click();
    }

    public boolean isChangesSavedMsgDisplayed() {
        return changesSavedMsg.textContent().equals("Changes saved");
    }

    public void clickOnNextButton() {
        nextBtn.click();
    }

    public void clickOnPublishBtn() {
        publishFormBtn.click();
    }

    public boolean isCopyPopUpDisplayed() {
        boolean popUpDisplayed = copyPopUp.isVisible() && copyLinkBtn.isVisible();
        closeBtn.click();
        return popUpDisplayed;
    }

    public boolean isNameSectionAdded() {
        return addedSectionList.allInnerTexts().contains("Name");
    }

    public boolean isEmailSectionAdded() {
        return addedSectionList.allInnerTexts().contains("Email");
    }

    public void clickOnRoutingOption(String routingName) {
        for (int i = 0; i < formNameList.count(); i++) {
            if (formNameList.nth(i).textContent().equals(routingName)) {
                optionsList.nth(i).click();
                break;
            }
        }
    }

    public void clickOnDeleteBtn() {
        deleteOption.click();
    }

    public boolean isConfirmationDeletePopUpDisplayed() {
        return deleteConfirmationBtn.isVisible();
    }

    public void clickOnConfirmDeleteBtn() {
        deleteConfirmationBtn.click();
    }

    public boolean isRoutingFormDeleted(String routingName) {
        return !formNameList.allInnerTexts().contains(routingName);
    }
}
