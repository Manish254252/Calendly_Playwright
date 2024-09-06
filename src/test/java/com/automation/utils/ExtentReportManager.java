package com.automation.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.util.Random;

public class ExtentReportManager {
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    static ExtentSparkReporter sparkReporter;

    public static void initExtentReport() {
        sparkReporter = new ExtentSparkReporter("ExtentReport/extentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Extent Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public static void flush() {
        extentReports.flush();
    }

    public static void createTest(String name) {
        extentTest = extentReports.createTest(name);
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    public static void attachScreenShot() {
        System.out.println("screenshot attached");
        extentTest.addScreenCaptureFromPath(takeScreenShot());
    }

    public static String takeScreenShot() {
        Page page = DriverManager.getPage();

        Random num = new Random();
        int n = num.nextInt(100);
        String path = "src/test/resources/screenshots/screenshot" + n + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return System.getProperty("user.dir") + "/" + path;
    }
}
