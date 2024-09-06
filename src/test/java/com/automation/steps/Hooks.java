package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initConfig();
        DriverManager.init();
        ExtentReportManager.initExtentReport();
        CucumberReportManager.initReport(scenario);
        ExtentReportManager.createTest(scenario.getName());
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.attachScreenShot();
            CucumberReportManager.attachScreenShot();
            ExtentReportManager.getExtentTest().fail(scenario.getName()+" Failed");

        }
        DriverManager.close();
        ExtentReportManager.flush();
    }

}
