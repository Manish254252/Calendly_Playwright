package com.automation.utils;


import com.microsoft.playwright.*;

public class DriverManager {
    private static Page page;
    private static Playwright playwright;
    private static Browser browser;

    public static void init() {
        try {
            playwright = Playwright.create();
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setChannel("msedge");

            browser = playwright.chromium().launch(options);
            BrowserContext context = browser.newContext();
            page = context.newPage();
        } catch (Exception e) {
            System.err.println("Error initializing Playwright: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Page getPage() {
        return page;
    }

    public static void close() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
