package com.automation.pages;

import com.automation.utils.DriverManager;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.Random;


public class BasePage {

    public static Page page;


    BasePage() {
        page = DriverManager.getPage();

    }

    public boolean isPresent(Locator eventNames) {
        try {
            eventNames.waitFor();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder();

        Random random = new Random();


        int usernameLength = 8 + random.nextInt(5);
        for (int i = 0; i < usernameLength; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }


        String[] domains = {"gmail.com", "hotmail.com", "fakemail.net", "sample.org", "mockemail.co"};
        email.append("@").append(domains[random.nextInt(domains.length)]);

        return email.toString();
    }

    public void switchTab() {

        BrowserContext context = page.context();
        List<Page> pages = context.pages();


        Page currentPage = context.pages().get(0);


        if (pages.size() > 1) {
            Page newPage = pages.get(1);
            newPage.bringToFront();
        } else {
            System.out.println("Only one tab is open.");
        }
    }
}


