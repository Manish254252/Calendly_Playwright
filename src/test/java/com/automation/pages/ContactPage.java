package com.automation.pages;

import com.automation.utils.ConfigWriter;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class ContactPage extends BasePage {

    Locator contactsSection;
    Locator addToContactIcon;
    Locator firstName;
    Locator email;
    Locator timeZone;
    Locator searchBarForTimeZone;
    Locator indianStandardTime;
    Locator phoneNumber;
    Locator saveContactBtn;
    Locator contactNameAfterSave;
    Locator contactProfileCloseButton;
    Locator editBtn;
    Locator removeBtn;
    Locator removeConfirmationBtn;

    List<Locator> rows;
    String timezone_XPATH = "//div[text()='%s']";
    String nameAndEmail_XPATH = "(//tr[@class='r15404cu'])[%s]/td[%s]//div[text()]";
    String actions_XPATH = "(//tr[@class='r15404cu'])[%s]/td[6]//button[@aria-label='Contact Actions Button']";



    public ContactPage() {

        contactsSection = page.locator("//span[text()='Contacts']");
        addToContactIcon = page.locator("(//div[@data-component='home-content']//button/span)[1]");
        firstName = page.locator("(//form//input)[2]");
        email = page.locator("(//form//input)[3]");
        timeZone = page.locator("//button[@aria-controls='timezone-picker']");
        searchBarForTimeZone = page.locator("//div[@role='combobox']//input");
        indianStandardTime = page.locator("//div[text()='India Standard Time']");
        phoneNumber = page.locator("(//form//input)[4]");
        saveContactBtn = page.locator("//span[text()='Save contact']");

        contactNameAfterSave = page.locator("//tbody//tr/td[2]/div//div/button/following-sibling::div").all().getLast();
        contactProfileCloseButton = page.locator("#contact_profile_close_button");
        rows = page.locator("//tr[@class='r15404cu']").all();
        editBtn = page.locator("//div[text()='Edit']");
        removeBtn = page.locator("//div[text()='Remove']");
        removeConfirmationBtn = page.locator("//button//span[text()='Remove']");
    }

    public void clickOnContactSection() {
        contactsSection.click();
    }

    public void clickOnAddToContactIcon() {
        addToContactIcon.click();
    }

    public void clickOnTimeZone() {
        timeZone.click();
    }

    public void clickOnIndianTimeZone() {
//        indianStandardTime.click();
    }

    public void clickOnSaveContactBtn() {
        saveContactBtn.click();
    }

    public void clickOnContactProfileCloseButton() {
        contactProfileCloseButton.click();
    }

    public void enterFirstName(String data) {
        firstName.fill(data);
    }

    public void enterEmail(String data) {
        String emailRandom = getRandomEmail();
        ConfigWriter.writeToPropertiesFile(data, emailRandom);
        System.out.println(emailRandom);
        email.fill(emailRandom);
    }

    public void enterTimeZone(String data) {
        searchBarForTimeZone.fill(data);
        page.locator(String.format(timezone_XPATH, data)).click();
    }

    public void enterPhoneNumber(String data) {
        System.out.println(data);
        phoneNumber.fill(data);
    }

    public boolean isFirstNameDisplayed() {
        return firstName.isVisible();
    }

    public boolean isContactSaved(String contactName) {
        clickOnContactProfileCloseButton();
        page.waitForTimeout(3000);
        System.out.println(contactNameAfterSave.innerText()+"text content");
        System.out.println(contactNameAfterSave.innerText().contains(contactName));
        return contactNameAfterSave.innerText().contains(contactName);
    }

    public void removeSpecifiedContact(String name, String email) {
        int n = rows.size();
        for (int i = 1; i <= n; i++) {
            Locator detailsLocator = page.locator(String.format(nameAndEmail_XPATH, i, 2));
            String details = detailsLocator.textContent();
            if (details.contains(name) && details.contains(email)) {
                Locator action = page.locator(String.format(actions_XPATH, i));
                action.click();
                removeBtn.click();
                removeConfirmationBtn.click();
                break;
            }
        }
    }

    public void editSpecifiedContact(String oldName, String oldPhone, String newName, String newPhone, String email) {
        int n = rows.size();
        boolean contactFound = false;
        for (int i = 1; i <= n; i++) {
            Locator detailsLocator = page.locator(String.format(nameAndEmail_XPATH, i, 2));
            String details = detailsLocator.textContent();
            if (details.contains(email)) {
                contactFound = true;
                Locator action = page.locator(String.format(actions_XPATH, i));
                action.click();
                editBtn.click();
                enterFirstName(newName);
                enterPhoneNumber(newPhone);
                break;
            }
        }
        if (!contactFound) {
            Locator action = page.locator(String.format(actions_XPATH, 1));
            action.click();
            editBtn.click();
            enterFirstName(newName);
            enterPhoneNumber(newPhone);
        }
    }

    public Boolean isContactPresent(String name, String email) {
        int n = rows.size();
        for (int i = 1; i <= n; i++) {
            Locator detailsLocator = page.locator(String.format(nameAndEmail_XPATH, i, 2));
            String details = detailsLocator.textContent();
            if (details.contains(email)) {
                return true;
            }
        }
        return false;
    }
}
