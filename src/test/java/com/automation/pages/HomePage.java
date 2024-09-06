package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;


public class HomePage extends BasePage {


    Locator newEventTypeButton;


    Locator createBtn;


    List<Locator> eventNamesList;


    List<Locator> eventDurationList;


    List<Locator> eventBookingPageLink;


    List<Locator> settingOptions;


    Locator availabilityLink;


    Locator meetingsLink;


    Locator routingLink;


    Locator profileIconBtn;


    Locator deleteConfirmBtn;


    Locator profileLink;

    static int noOfEventsBeforeDeletion;
    static int noOfEventsAfterDeletion;

    public HomePage() {
        newEventTypeButton = page.locator("//div[contains(@class,'list-header')]//span[contains(text(),'New Event Type')]");
        createBtn = page.locator("#home-bar-create-button");
        eventNamesList = page.locator("//div[@data-component='sortable']//h2").all();
        eventDurationList = page.locator(" //div[@data-component='sortable']//p").all();
        eventBookingPageLink = page.locator("//div[@data-component='sortable']//div/a").all();
        settingOptions = page.locator(" //div[@data-component='sortable']//h2/ancestor::div[@data-component='event-type-card-list']//button[@aria-expanded]").all();
        availabilityLink = page.locator("    //div[@data-calendly-label='left-nav-main-items-container']//span[contains(text(),'Availability')]");
        meetingsLink = page.locator(" //div[@data-calendly-label='left-nav-main-items-container']//span[contains(text(),'Meetings')]");
        routingLink = page.locator("//div[@data-calendly-label='left-nav-main-items-container']//span[contains(text(),'Routing')]");
        deleteConfirmBtn = page.locator("//button/span[text()='Yes']");
        profileLink = page.locator("//div[@id='main-user-menu']//div/a/div[contains(text(),'Profile')]");
        profileIconBtn = page.locator("#main-user-menu-toggle");
    }


    public void clickOnNewEventTypeButton() {
        newEventTypeButton.click();
    }

    public boolean isCreateBtnDisplayed() {
        return createBtn.isVisible();
    }

    public boolean isEventListedOnHomePage(String eventName, String eventDuration) {
        boolean isEventPresent = false;
        boolean isDurationPresent = false;


        for (Locator event : eventNamesList) {

            if (isPresent(event)) {
                if (event.innerText().contains(eventName)) {
                    isEventPresent = true;
                    break;
                }
            }
        }
        if (eventDuration.equals("60 min")) {
            eventDuration = "1 hr";
        }
        for (Locator event : eventDurationList) {
            if (event.innerText().contains(eventDuration)) {
                isDurationPresent = true;
                break;
            }
        }

        return isEventPresent && isDurationPresent;
    }

    boolean eventsDeleted = false;

    public void deleteEventsOfName(String eventName) {

        while (!eventsDeleted) {
            List<Locator> eventNamesList = page.locator("//div[@data-component='sortable']//h2").all();
            List<Locator> settingOptions = page.locator("//div[@data-component='sortable']//h2/ancestor::div[@data-component='event-type-card-list']//button[@aria-expanded]").all();
            noOfEventsBeforeDeletion = eventNamesList.size();
            if (eventNamesList.size() != settingOptions.size()) {
                continue;
            }
            for (int i = 0; i < eventNamesList.size(); i++) {

                try {
                    Locator eventNameElement = eventNamesList.get(i);
                    Locator settingOptionElement = settingOptions.get(i);

                    if (eventNameElement.innerText().equals(eventName)) {
                        settingOptionElement.click();
                        Locator deleteButton = settingOptionElement.locator("//div[@data-component='event-type-card-list']//button[@aria-expanded]/following-sibling::div//button/div[text()='Delete']");
                        deleteButton.click();
                        deleteConfirmBtn.click();

                        eventsDeleted = true;

                        break;
                    }
                } catch (Exception e) {
                    eventsDeleted = true;
                    break;
                }
            }
        }
    }

    public boolean isEventDeleted(String eventName) {

        return eventsDeleted;

    }

    public void clickOnBookingEventLink(String eventName, String eventDuration) {
        for (int i = 0; i < eventBookingPageLink.size(); i++) {
            if (eventNamesList.get(i).innerText().equals(eventName) && eventDurationList.get(i).innerText().contains(eventDuration)) {
                eventBookingPageLink.get(i).click();
                break;
            }
        }
    }

    public void clickOnAvailabilityButton() {
        availabilityLink.click();
    }

    public void clickOnMeetingLink() {
        meetingsLink.click();
    }

    public void clickOnProfileIcon() {
        profileIconBtn.click();
    }

    public void clickOnProfileLink() {
        profileLink.click();
    }

    public void clickOnRoutingLink() {
        routingLink.click();
    }


}
