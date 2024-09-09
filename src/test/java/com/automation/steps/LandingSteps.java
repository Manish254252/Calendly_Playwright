package com.automation.steps;

import com.automation.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LandingSteps {

    LandingPage landingPage = new LandingPage();
    @Given("user opens website")
    public void user_opens_website() {
       landingPage.openWebsite();
    }

    @When("user clicks on loginLink")
    public void userClicksOnLoginLink() {
        landingPage.clickOnLoginLink();
    }

    @Then("verify is on landing page")
    public void verifyIsOnLandingPage() {
        Assert.assertTrue(landingPage.isLandingPageDisplayed());
    }
}
