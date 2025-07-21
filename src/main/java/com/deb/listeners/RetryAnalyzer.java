package com.deb.listeners;

import com.deb.factories.ConfigFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;

    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (ConfigFactory.getConfig().retryFailedTests().equalsIgnoreCase("yes")) {
            value = count < retries;
            count++;
        }
        return value;
    }
}
