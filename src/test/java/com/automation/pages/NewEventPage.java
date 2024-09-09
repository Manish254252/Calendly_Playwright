package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;


import java.util.List;

public class NewEventPage extends BasePage {

    String XPATH_EVENT_TYPE = "//button//h2[contains(text(), '%s')]";

    Locator nextBtn;
    Locator newEventNameInput;
    Locator eventDuration;
    Locator continueBtn;
    Locator inviteUserButton;
    Locator confirmationDialogueBox;
    Locator durationFirstOption;
    Locator doneBtn;
    Locator eventPageTitle;
    List<Locator> eventTypeList;
    Locator inviteLimitInput;



    public NewEventPage() {

        nextBtn = page.locator("//button/span[contains(text(),'Next')]");
        newEventNameInput = page.locator("//input[@id='event-name-field']");
        eventDuration = page.locator("//div[@name='eventDuration']");
        continueBtn = page.locator("//button[@type='submit']");
        inviteUserButton = page.locator("//div/button/span[text()='Invite users']");
        confirmationDialogueBox = page.locator("//h1[contains(text(), 'Your event type is ready!')]");
        durationFirstOption = page.locator("//div[@role='listbox']/button[1]");
        doneBtn = page.locator("//button[contains(text(),'Done')]");
        eventPageTitle = page.locator("//h1[contains(text(), 'Create New Event')]");
        eventTypeList = page.locator("//tbody/tr//button").all();
        inviteLimitInput = page.locator("//input[@name='inviteesLimit']");
    }

    public boolean isEventPageDisplayed() {
        return eventPageTitle.isVisible() && eventTypeList.get(0).isVisible();
    }

    public void clickOnTheEventType(String eventType) {
        String xpath = String.format(XPATH_EVENT_TYPE, eventType);
        page.locator(xpath).click();
    }

    public void clickOnNextButton() {
        nextBtn.click();
    }

    public void enterEventNameAndDuration(String eventName, String duration) {
        newEventNameInput.fill(eventName);
        eventDuration.click();
        durationFirstOption.click();

        if (inviteLimitInput.isVisible()) {
            inviteLimitInput.fill(ConfigReader.getConfigValue("maxInviteLimit"));
        }
    }

    public void clickContinueButton() {
        continueBtn.click();
    }

    public boolean isEventReadyMsgIsDisplayed() {
        return confirmationDialogueBox.isVisible();
    }

    public void clickDoneButton() {
        doneBtn.click();
    }
}
