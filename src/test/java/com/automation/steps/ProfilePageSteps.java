package com.automation.steps;

import com.automation.pages.ProfilePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProfilePageSteps {

    ProfilePage profilePage = new ProfilePage();

    @Then("verify profile page is displayed")
    public void verifyProfilePageIsDisplayed() {
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
    }

    @Then("verify profile is changed")
    public void verifyProfileIsChanged() {
        Assert.assertTrue(profilePage.isProfileChanged());
    }

    @When("user clicks on save changes button")
    public void userClicksOnSaveChangesButton() {
        profilePage.clickOnSaveChangesButton();
    }

    @Then("verify changes have been saved")
    public void verifyChangesHaveBeenSaved() {
        Assert.assertTrue(profilePage.isChangesSaved());
    }

    @When("user clicks on logout link")
    public void userClicksOnLogoutLink() {
        profilePage.clickOnLogoutLink();
    }

    @When("user selects profile as {string}")
    public void userSelectsProfileAs(String profileImgPath) {
        profilePage.clickOnUploadBtn(ConfigReader.getConfigValue(profileImgPath));
    }

    @And("user updates name as {string}")
    public void userUpdatesNameAs(String updatedName) {
        profilePage.enterUpdateName(ConfigReader.getConfigValue(updatedName));
    }

    @And("user updates welcome message as {string}")
    public void userUpdatesWelcomeMessageAs(String updatedMsg) {
        profilePage.enterUpdateMsg(ConfigReader.getConfigValue(updatedMsg));
    }
}
