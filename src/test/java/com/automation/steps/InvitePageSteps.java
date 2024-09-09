package com.automation.steps;

import com.automation.pages.InvitePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class InvitePageSteps {

    InvitePage invitePage = new InvitePage();

    @And("user clicks on invite users button")
    public void userClicksOnInviteUsersButton() {
        invitePage.clickOnInviteUserButton();
    }

    @And("user enters invite emails {string}")
    public void userEntersInviteEmails(String email) {

        invitePage.enterInvitesEmails(email);
    }

    @And("clicks on set roles")
    public void clicksOnSetRoles() {
        invitePage.clickSetRoleButton();
    }

    @And("clicks on send invitation")
    public void clicksOnSendInvitation() {
        invitePage.clickOnSendInvite();
    }

    @And("clicks on assign event button")
    public void clicksOnAssignEventButton() {
        invitePage.clickOnAssignEventButton();
    }

    @Then("verify invitations are sent")
    public void verifyInvitationsAreSent() {
        Assert.assertTrue(invitePage.isInvitationSent());
    }

    @Then("verify upgrade plan popUp is displayed")
    public void verifyUpgradePlanPopUpIsDisplayed() {
        Assert.assertTrue(invitePage.isUpgradePlanPopUpDisplayed());
    }
}
