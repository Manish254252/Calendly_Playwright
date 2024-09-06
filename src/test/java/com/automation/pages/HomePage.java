package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;


public class HomePage extends BasePage {

    Locator flightSection = page.locator("//a[@aria-controls='search_form_product_selector_flights']");
    Locator oneWayFlight = page.locator("//a[@aria-controls='FlightSearchForm_ONE_WAY']");

    Locator sourceButton = page.locator("//button[@data-stid='origin_select-menu-trigger']");
    Locator sourceInput = page.locator("//input[@data-stid='origin_select-menu-input']");
    Locator searchSuggest = page.locator("(//button[@data-stid='destination_form_field-result-item-button'])[1]");
    Locator destinationButton = page.locator("//button[@data-stid='destination_select-menu-trigger']");
    Locator destinationInput = page.locator("//input[@data-stid='destination_select-menu-input']");


    Locator dateButton = page.locator("//button[@data-testid='uitk-date-selector-input1-default']");
    Locator dateSelected = page.locator("(//div[text()='30'])[1]");

    Locator doneButton = page.locator("//button[@data-stid='apply-date-selector']");

    Locator travellerButton = page.locator("//button[@data-stid='open-room-picker']");



    Locator childOneAgeSelector = page.locator("#age-traveler_selector_children_age_selector-0");
    Locator childTwoAgeSelector = page.locator("#age-traveler_selector_children_age_selector-1");

    Locator doneButtonAfter = page.locator("#travelers_selector_done_button");
    Locator searchButton = page.locator("#search_button");

    Locator priceOfDay = page.locator("//button[@aria-label='Monday, September 30 2024, $48, Lowest price, Selected date']/span[contains(text(),'$')]");
    Locator sortSelector = page.locator("#sort-filter-dropdown-SORT");
    Locator firstFlightButton = page.locator("//button[@stid='FLIGHTS_DETAILS_AND_FARES-index-1-leg-0-fsr-FlightsActionButton']");
    Locator priceOfCheapestFlight = page.locator("(//section/span)[1]");

    Locator whereTo = page.locator("//button[@data-stid=\"destination_form_field-menu-trigger\"]");
    Locator whereToinput = page.locator("//input[@data-stid=\"destination_form_field-menu-input\"]");
    String fromDateLocator = "//div[contains(@aria-label, '%s')]";
    String toDateLocator ="//div[contains(@aria-label, '%s')]";


    public void openWebsite() {
        page.navigate("https://www.expedia.com");
        page.waitForTimeout(20000);
        page.waitForLoadState();
    }

    public void selectFlightSection() {
        flightSection.click();
    }

    public void clickOnOneWay() {
        oneWayFlight.click();
    }

    public void clickOnSource() {
        sourceButton.click();
    }

    public void enterFlightOrigin(String data) {
        sourceInput.fill(data);
        page.keyboard().press("Enter");
//        searchSuggest.click();
    }

    public void clickOnDestination() {
        destinationButton.click();
    }

    public void enterFlightDestination(String data) {
        destinationInput.fill(data);
        page.keyboard().press("Enter");
//        searchSuggest.click();
    }

    public void clickOnDateButton() {
        dateButton.click();
    }

    public void clickOnDateSelected() {
        dateSelected.click();
    }
    public void clickOnDone()
    {
        doneButton.click();
    }
    public void clickTraveller()
    {
        travellerButton.click();
    }

    public void selectNumberOfAdults(String number)
    {
        int count =Integer.parseInt(number);
        count--;
        while ((count>0))
        {
            Locator adultsButton = page.locator("(//button[@class='uitk-layout-flex-item uitk-step-input-touch-target'][2])[1]");
            adultsButton.click();
            count--;
        }
    }

    public void selectNumberOfChildren(String number)
    {
        int count =Integer.parseInt(number);
//        count--;
        while ((count>0))
        {
            Locator childButton = page.locator("(//button[@class='uitk-layout-flex-item uitk-step-input-touch-target'][2])[2]");
            childButton.click();
            count--;
        }
        childOneAgeSelector.selectOption(new SelectOption().setLabel("10"));
        childTwoAgeSelector.selectOption(new SelectOption().setLabel("10"));
    }
    public void clickDoneButtonAfter()
    {
        doneButtonAfter.click();
    }

    public void clickSearch()
    {
        searchButton.click();
        try {
            Thread.sleep(80000);
        }catch (Exception e)
        {

        }

    }
    public boolean isPriceSame() {
        System.out.println("in is peice");
//        System.out.println(priceOfDay.innerText());
        sortSelector.selectOption(new SelectOption().setLabel("Price (lowest to highest)"));
        firstFlightButton.click();
        System.out.println(priceOfCheapestFlight.innerText());
        return  true;
    }

    public void clickOnWhereTo()
    {
        whereTo.click();
    }

    public void enterWhereTo(String data)
    {
        whereToinput.fill(data);
        page.keyboard().press("Enter");
    }

    public void fromDate(String data)
    {
        page.locator(String.format(fromDateLocator,data));
    }
    public void toDate(String data)
    {
        page.locator(String.format(toDateLocator,data));
    }
}
