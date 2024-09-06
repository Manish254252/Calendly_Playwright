package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class HomeSteps {

    HomePage homePage = new HomePage();
    @And("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isCreateBtnDisplayed());
    }


    @When("user clicks on new event type button")
    public void userClicksOnNewEventTypeButton() {
        homePage.clickOnNewEventTypeButton();
    }

    @Then("verify event is listed on home page")
    public void verifyEventIsListedOnHomePage() {

    }

    @Then("verify event {string} and {string} is listed on home page")
    public void verifyEventAndIsListedOnHomePage(String eventName, String eventDuration) {
        Assert.assertTrue(homePage.isEventListedOnHomePage(ConfigReader.getConfigValue(eventName), ConfigReader.getConfigValue(eventDuration)));
    }

    @When("user deletes the event of name {string}")
    public void userDeletesTheEventOfNameAndDuration(String eventName) {
        homePage.deleteEventsOfName(ConfigReader.getConfigValue(eventName));
    }

    @Then("verify events are deleted of name {string}")
    public void verifyEventsAreDeletedOfName(String eventName) {
        Assert.assertTrue(homePage.isEventDeleted(ConfigReader.getConfigValue(eventName)));
    }

    @When("user clicks on event of name {string} and duration {string}")
    public void userClicksOnEventOfNameAndDuration(String eventName, String eventDuration) {
        homePage.clickOnBookingEventLink(ConfigReader.getConfigValue(eventName), ConfigReader.getConfigValue(eventDuration));
    }

    @And("switch the tab")
    public void switchTheTab() {
        homePage.switchTab();
    }


    @When("user clicks on availability")
    public void user_clicks_on_availability() {
        homePage.clickOnAvailabilityButton();
    }

    @When("user clicks on meetings link")
    public void userClicksOnMeetingsLink() {
        homePage.clickOnMeetingLink();
    }


    @When("user clicks on profile icon")
    public void userClicksOnProfileIcon() {
        homePage.clickOnProfileIcon();
    }

    @And("clicks on profile link")
    public void clicksOnProfileLink() {
        homePage.clickOnProfileLink();
    }


    @When("user clicks on routing link")
    public void userClicksOnRoutingLink() {
        homePage.clickOnRoutingLink();
    }

}
