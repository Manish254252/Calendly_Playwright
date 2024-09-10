package com.automation.steps;

import com.automation.pages.NewEventPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class NewEventSteps {

    NewEventPage newEventPage = new NewEventPage();

    @Then("verify new event type page is displayed")
    public void verifyNewEventTypePageIsDisplayed() {

        Assert.assertTrue(newEventPage.isEventPageDisplayed());
    }

    @And("user choose the event type {string}")
    public void userChooseTheEventType(String eventType) {
        newEventPage.clickOnTheEventType(ConfigReader.getConfigValue(eventType));
    }

    @And("user clicks on next button")
    public void userClicksOnNextButton() {
        newEventPage.clickOnNextButton();
    }

    @And("user enters event name {string} and duration {string}")
    public void userEntersEventNameAndDuration(String eventName, String duration) {

        newEventPage.enterEventNameAndDuration(ConfigReader.getConfigValue(eventName), ConfigReader.getConfigValue(duration));
    }

    @And("clicks on continue Button")
    public void clicksOnContinueButton() {
        newEventPage.clickContinueButton();
    }

    @Then("verify new Event is ready message is displayed")
    public void verifyNewEventIsReadyMessageIsDisplayed() {
        Assert.assertTrue(newEventPage.isEventReadyMsgIsDisplayed());
    }

    @When("user clicks on done button")
    public void userClicksOnDoneButton() {
        newEventPage.clickDoneButton();

    }
}
