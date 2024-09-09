package com.automation.steps;

import com.automation.pages.RoutingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RoutingPageSteps {

    RoutingPage routingPage = new RoutingPage();

    @Then("verify routing page is displayed")
    public void verifyRoutingPageIsDisplayed() {
        Assert.assertTrue(routingPage.isRoutingPageDisplayed());
    }

    @When("user clicks on new routing form button")
    public void userClicksOnNewRoutingFormButton() {
        routingPage.clickOnNewRoutingButton();
    }

    @And("clicks on create new form")
    public void clicksOnCreateNewForm() {
        routingPage.clickOnCreateNewForm();
    }

    @Then("verify routing popup is displayed")
    public void verifyRoutingPopupIsDisplayed() {
        Assert.assertTrue(routingPage.isRoutingFormPopUpDisplayed());
    }


    @When("user enters routing form name as {string}")
    public void user_enters_routing_form_name_as(String routingName) {
        routingPage.enterRoutingName(ConfigReader.getConfigValue(routingName));
    }

    @When("clicks on create form")
    public void clicks_on_create_form() {
        routingPage.clickOnCreateFormBtn();
    }

    @When("user clicks on Add a question")
    public void user_clicks_on_add_a_question() {
        routingPage.clickOnAddQuestionButton();
    }

    @When("selects name and perform click")
    public void selects_name_and_perform_click() {
        routingPage.selectNameOption();
    }

    @When("user writes a question for name {string}")
    public void user_writes_a_questionForName(String nameQuestion) {
        routingPage.enterQuestion(ConfigReader.getConfigValue(nameQuestion));
    }

    @And("user writes a question for email {string}")
    public void userWritesAQuestionForEmail(String emailQuestion) {
        routingPage.enterQuestion(ConfigReader.getConfigValue(emailQuestion));
    }

    @And("selects email and perform click")
    public void selectsEmailAndPerformClick() {
        routingPage.selectEmailOption();
    }

    @When("clicks on save button")
    public void clicks_on_save_button() {
        routingPage.clickOnSaveBtn();
    }

    @Then("verify changes saved")
    public void verify_changes_saved() {
        Assert.assertTrue(routingPage.isChangesSavedMsgDisplayed());
    }

    @When("user clicks on next button of routing page")
    public void user_clicks_on_next_button_of_routing_page() {
        routingPage.clickOnNextButton();
    }

    @When("clicks on publish button")
    public void clicks_on_publish_button() {
        routingPage.clickOnPublishBtn();
    }

    @Then("verify copy routing link popup is displayed")
    public void verify_copy_routing_link_popup_is_displayed() {
        Assert.assertTrue(routingPage.isCopyPopUpDisplayed());
    }

    @Then("verify name section is added")
    public void verifyNameSectionIsAdded() {
        Assert.assertTrue(routingPage.isNameSectionAdded());
    }

    @Then("verify email section is added")
    public void verifyEmailSectionIsAdded() {
        Assert.assertTrue(routingPage.isEmailSectionAdded());
    }

    @When("user clicks on options of routing name {string}")
    public void userClicksOnOptionsOfRoutingName(String routingName) {
        routingPage.clickOnRoutingOption(ConfigReader.getConfigValue(routingName));
    }

    @And("clicks on delete option")
    public void clicksOnDeleteOption() {
        routingPage.clickOnDeleteBtn();
    }

    @Then("verify delete confirmation popup is displayed")
    public void verifyDeleteConfirmationPopupIsDisplayed() {
        Assert.assertTrue(routingPage.isConfirmationDeletePopUpDisplayed());
    }

    @When("user clicks on confirm delete button")
    public void userClicksOnConfirmDeleteButton() {
        routingPage.clickOnConfirmDeleteBtn();
    }


    @Then("verify routing form {string} is deleted")
    public void verifyRoutingFormIsDeleted(String routingName) {
        Assert.assertTrue(routingPage.isRoutingFormDeleted(routingName));
    }
}
