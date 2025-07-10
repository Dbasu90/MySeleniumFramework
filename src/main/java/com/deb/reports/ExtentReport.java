package com.deb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.deb.constants.FrameworkConstants;

public class ExtentReport {

    private static ExtentReports report;

    public static void initReport() {
        report = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        report.attachReporter(sparkReporter);
    }

    public static void flushReport() {
        report.flush();
    }

    public static void createTest(String testcaseName) {
        ExtentTest test = report.createTest(testcaseName);
        ExtentManager.setThreadTest(test);
    }

}
