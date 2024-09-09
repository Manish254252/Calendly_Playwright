package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Then("verify user on login page")
    public void verify_user_on_login_page() {
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
    }

    @When("user enters email as {string}")
    public void userEntersEmailAs(String email) {

        if(email.equals("userEmail"))
            loginPage.enterEmail(ConfigReader.getConfigValue(email));
        else
            loginPage.enterEmail(email);
    }

    @And("user clicks on loginBtn")
    public void userClicksOnLoginBtn() {
        loginPage.clickOnLoginBtn();
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {

        if(password.equals("password"))
            loginPage.enterPassword(ConfigReader.getConfigValue(password));
        else
            loginPage.enterPassword(password);
    }

    @Then("user clicks on continue button")
    public void userClicksOnContinueButton() {
        loginPage.clickOnContinue();
    }


    @And("verify user is on not able to login")
    public void verifyUserIsOnNotAbleToLogin() {

        Assert.assertTrue(loginPage.isNoSuchAccountDisplayed());
    }
}
