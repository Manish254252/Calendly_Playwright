package com.automation.steps;

import com.automation.pages.EventSchedulePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EventSchedulePageSteps {

    EventSchedulePage eventSchedulePage = new EventSchedulePage();

    @Then("verify user is on event schedule page")
    public void verifyUserIsOnEventSchedulePage() {
        Assert.assertTrue(eventSchedulePage.isEventSchedulePageDisplayed());
    }

    @When("user selects date {string}")
    public void userSelectsDate(String date) {
        eventSchedulePage.selectDate(ConfigReader.getConfigValue(date));
    }

    @And("user selects time")
    public void userSelectsTime() {
        eventSchedulePage.selectTime();
    }

    @And("clicks on schedule button")
    public void clicksOnScheduleButton() {
        eventSchedulePage.clickScheduleButton();
    }

    @Then("verify event is scheduled")
    public void verifyEventIsScheduled() {
        Assert.assertTrue(eventSchedulePage.isEventScheduled());
    }

    @And("user enters event name {string} email {string} and {string}")
    public void userEntersEventNameEmailAnd(String name, String email, String msg) {
        eventSchedulePage.enterEventNameAndMsg(ConfigReader.getConfigValue(name),ConfigReader.getConfigValue(email) ,ConfigReader.getConfigValue(msg));
    }
}
