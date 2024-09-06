package com.automation.pages;

import com.automation.utils.DriverManager;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;


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


