package com.deb.listeners;

import com.deb.reports.ExtentLogger;
import com.deb.reports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }

    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " is failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }

    public void onFinish(ITestContext context) {
        ExtentReport.flushReport();
    }
}
