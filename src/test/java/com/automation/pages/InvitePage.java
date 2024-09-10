package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.List;

public class InvitePage extends BasePage {

    Locator inviteUsersBtn;
    Locator emailAddressBox;
    List<Locator> previousEmailCloseBtn;
    Locator setRolesBtn;
    Locator assignEventButton;
    Locator sendInvitationBtn;
    Locator confirmationMsg;
    Locator upgradePlanHeading;



    public InvitePage() {

        inviteUsersBtn = page.locator("//div/button/span[text()='Invite users']");
        emailAddressBox = page.locator("//label[@for='invitee_emails_input']");
        previousEmailCloseBtn = page.locator("//div[@data-container='invitee-email-valid']/div[@aria-label='Remove']").all();
        setRolesBtn = page.locator("//div/button/span[contains(text(), 'Set roles')]");
        assignEventButton = page.locator("//div/button/span[contains(text(), 'Assign event')]");
        sendInvitationBtn = page.locator("//div/button/span[contains(text(), 'Send invitation')]");
        confirmationMsg = page.locator("//div[@data-component='main']//h1[contains(text(), 'All done')]");
        upgradePlanHeading = page.locator("//div[@role='dialog']//h3");
    }

    public void clickOnInviteUserButton() {
        inviteUsersBtn.click();
    }

    public void enterInvitesEmails(String email) {
        ConfigReader.setConfigValue(email, getRandomEmail());
        email = ConfigReader.getConfigValue(email);
        emailAddressBox.click();
        emailAddressBox.fill(email);
    }

    public void clickSetRoleButton() {
        setRolesBtn.click();
    }

    public void clickOnSendInvite() {
        sendInvitationBtn.click();
    }

    public void clickOnAssignEventButton() {
        assignEventButton.click();
    }

    public boolean isInvitationSent() {
        page.waitForSelector("//div[@data-component='main']//h1[contains(text(), 'All done')]",new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        return confirmationMsg.isVisible();
    }

    public boolean isUpgradePlanPopUpDisplayed() {
        return upgradePlanHeading.textContent().equalsIgnoreCase("Upgrade to Standard");
    }
}
