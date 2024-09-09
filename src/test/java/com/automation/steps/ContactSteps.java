package com.automation.steps;

import com.automation.pages.ContactPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactSteps {
    ContactPage contactPage = new ContactPage();

    @Given("user navigates to the Add to Contacts section")
    public void user_navigates_to_the_section() {
        contactPage.clickOnContactSection();
    }

    @When("user clicks on the Add to Contacts icon")
    public void user_clicks_on_the_add_to_contacts_icon() {
        contactPage.clickOnAddToContactIcon();
    }

    @Then("verify the Add Contact form is displayed")
    public void verify_the_add_contact_form_is_displayed() {
        Assert.assertTrue(contactPage.isFirstNameDisplayed());
    }

    @When("user enters {string} as the first name for the contact")
    public void user_enters_as_the_first_name_for_the_contact(String string) {
        if (string.equals("contact.firstname"))
        {
            contactPage.enterFirstName(ConfigReader.getConfigValue(string));

        }else {
            contactPage.enterFirstName(string);
        }

    }

    @When("user enters {string} as the email for the contact")
    public void user_enters_as_the_email_for_the_contact(String string) {
//        if (string.equals("contact.email"))
//        {
//            contactPage.enterEmail(ConfigReader.getConfigValue(string));
//
//        }else {
            contactPage.enterEmail(string);
//        }
    }

    @When("user selects {string} as the timezone for the contact")
    public void user_selects_as_the_timezone_for_the_contact(String string) {
        if (string.equals("contact.timezone"))
        {
            contactPage.clickOnTimeZone();
            contactPage.enterTimeZone(ConfigReader.getConfigValue(string));
            contactPage.clickOnIndianTimeZone();

        }else {
            contactPage.clickOnTimeZone();
            contactPage.enterTimeZone(string);
            contactPage.clickOnIndianTimeZone();
        }

    }

    @When("user enters {string} as the phone number for the contact")
    public void user_enters_as_the_phone_number_for_the_contact(String string) {
        if (string.equals("contact.phoneNo"))
        {
            contactPage.enterPhoneNumber(ConfigReader.getConfigValue(string));

        }else {
            contactPage.enterPhoneNumber(string);
        }
    }

    @When("user clicks on the Save Contact button")
    public void user_clicks_on_the_button() {
        contactPage.clickOnSaveContactBtn();
    }

    @Then("verify the contact {string} is successfully added to the contact list")
    public void verify_the_contact_is_successfully_added_to_the_contact_list(String string) {
        string = ConfigReader.getConfigValue(string);
        System.out.println(string);
        Assert.assertTrue(contactPage.isContactSaved(string));
    }


    @When("user clicks on remove button of {string} with email as {string}")
    public void userClicksOnRemoveButtonOf(String name,String email) {
        contactPage.removeSpecifiedContact(ConfigReader.getConfigValue(name),ConfigReader.getConfigValue(email));
    }



    @Then("Verify contact with name {string} and  email as {string} is removed")
    public void verifyContactWithNameAndEmailAsIsRemoved(String name, String email) {
        Assert.assertFalse(contactPage.isContactPresent(ConfigReader.getConfigValue(name), ConfigReader.getConfigValue(email)));
    }

    @When("user edits  {string} to {string} and {string} to {string}")
    public void userEditsToAndTo(String oldName, String newName, String oldEmail, String newEmail) {

    }

    @Then("verify the contact {string} is successfully edited")
    public void verifyTheContactIsSuccessfullyEdited(String newName) {

        Assert.assertFalse("contact does not exists",contactPage.isContactPresent(ConfigReader.getConfigValue(newName),ConfigReader.getConfigValue("contact.email")));
    }

    @When("user edits  {string} to {string} and {string} to {string} with email {string}")
    public void userEditsToAndToWithEmail(String oldName, String newName, String oldPhone, String newPhone, String email) {

        oldName = ConfigReader.getConfigValue(oldName);
        oldPhone = ConfigReader.getConfigValue(oldPhone);
        newName = ConfigReader.getConfigValue(newName);
        newPhone = ConfigReader.getConfigValue(newPhone);
        email =  ConfigReader.getConfigValue(email);
        contactPage.editSpecifiedContact(oldName, oldPhone,newName, newPhone,email);
    }

}
