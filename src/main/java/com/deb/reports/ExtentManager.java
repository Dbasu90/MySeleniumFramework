package com.deb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager() {
    }

    private static final ThreadLocal<ExtentTest> threadTest = new ThreadLocal<>();

    static ExtentTest getThreadTest() {
        return threadTest.get();
    }

    static void setThreadTest(ExtentTest test) {
        threadTest.set(test);
    }
}
