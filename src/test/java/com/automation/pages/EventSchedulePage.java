package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class EventSchedulePage extends BasePage {

    Locator selectDateTitle;
    Locator calendar;
    List<Locator> availableDates;
    Locator nextMonthButton;
    Locator monthHeader;
    Locator timeListDiv;
    List<Locator> timeButtons;
    Locator nextBtn;
    Locator nameInput;
    Locator emailInput;
    Locator textareaInput;
    Locator scheduleEventBtn;
    Locator scheduleConfirmationMsg;



    public EventSchedulePage() {

        selectDateTitle = page.locator("//div[@data-component='spotpicker']/h2");
        calendar = page.locator("//div[@data-testid='calendar']");
        availableDates = page.locator("//button[contains(@aria-label, 'Times available')]/span").all();
        nextMonthButton = page.locator("//button[@aria-label='Go to next month']");
        monthHeader = page.locator("//div[@data-testid='calendar-header']/div[@data-testid='title']");
        timeListDiv = page.locator("//div[@data-component='spot-list']");
        timeButtons = page.locator("//button[@data-container='time-button']").all();
        nextBtn = page.locator("//button[contains(@aria-label, 'Next')]");
        nameInput = page.locator("//input[@name='full_name']");
        emailInput = page.locator("//div/input[@type='email']");
        textareaInput = page.locator("//textarea[@type='textarea']");
        scheduleEventBtn = page.locator("//button/span[contains(text(), 'Schedule Event')]");
        scheduleConfirmationMsg = page.locator("//div[@data-component='confirmation-header']/h1");
    }

    public boolean isEventSchedulePageDisplayed() {
        return selectDateTitle.textContent().contains("Select a Date") && calendar.isVisible();
    }

    public void selectDate(String stringDate) {
        String monthYear = stringDate.substring(stringDate.indexOf(" ") + 1);
        String date = stringDate.substring(0, stringDate.indexOf(" "));

        while (!monthHeader.textContent().equals(monthYear)) {
            nextMonthButton.click();
            page.waitForSelector("//div[@data-testid='calendar-header']/div[@data-testid='title']");
        }

        for (Locator dateEle : availableDates) {
            if (dateEle.textContent().equals(date)) {
                dateEle.click();
                break;
            }
        }
    }

    public void selectTime() {
        if (timeListDiv.isVisible()) {
            timeButtons.get(0).click();
            nextBtn.click();
        }
    }

    public void enterEventNameAndMsg(String name, String email, String msg) {
        nameInput.fill(name);
        emailInput.fill(email);
        textareaInput.fill(msg);
    }

    public void clickScheduleButton() {
        scheduleEventBtn.click();
    }

    public boolean isEventScheduled() {
        return scheduleConfirmationMsg.textContent().contains("You are scheduled");
    }
}
