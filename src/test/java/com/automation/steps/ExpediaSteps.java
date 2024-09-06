package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ExpediaSteps {
    HomePage homePage = new HomePage();

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        homePage.openWebsite();

    }

    @When("user clicks on flight section")
    public void userClicksOnFlightSection() {
        homePage.selectFlightSection();

    }

    @When("user clicks on oneWay")
    public void userClicksOnOneWay() {

        homePage.clickOnOneWay();


    }

    @When("user selects source as {string}")
    public void user_selects_source_as(String string) {
        homePage.clickOnSource();
        homePage.enterFlightOrigin(string);
    }

    @When("user selects destination as {string}")
    public void user_selects_destination_as(String string) {
        homePage.clickOnDestination();
        homePage.enterFlightDestination(string);
    }

    @When("user selects date")
    public void user_selects_date() {
        homePage.clickOnDateButton();
        homePage.clickOnDateSelected();
        homePage.clickOnDone();
    }

    @When("user selects number of adult travelers as {string}")
    public void user_selects_number_of_adult_travelers_as(String string) {
        homePage.clickTraveller();
        homePage.selectNumberOfAdults(string);
    }

    @When("user selects number of child travelers as {string}")
    public void user_selects_number_of_child_travelers_as(String string) {
        homePage.selectNumberOfChildren(string);
    }

    @When("user selects age for child travelers")
    public void user_selects_age_for_child_travelers() {
        homePage.clickDoneButtonAfter();
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        homePage.clickSearch();
    }

    @Then("verify search flight is listed")
    public void verify_search_flight_is_listed() {
        Assert.assertTrue(homePage.isPriceSame());
    }


    @When("user selects location for stay as {string}")
    public void userSelectsLocationForStayAs(String arg0) {
        homePage.clickOnDateButton();
        homePage.clickOnWhereTo();
        homePage.enterWhereTo(arg0);
    }

    @When("user selects date as {string} to {string}")
    public void userSelectsDateAsTo(String arg0, String arg1) {
        homePage.fromDate(arg0);
        homePage.toDate(arg1);
        homePage.clickOnDone();

    }

    @Then("verify stays are listed")
    public void verifyStaysAreListed() {
    }
}
