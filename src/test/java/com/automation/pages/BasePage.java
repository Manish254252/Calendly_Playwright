package com.automation.pages;

import com.automation.utils.DriverManager;
import com.microsoft.playwright.Page;



public class BasePage {

    public static Page page;


    BasePage() {
        page = DriverManager.getPage();

    }


}


