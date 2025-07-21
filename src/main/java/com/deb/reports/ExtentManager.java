package com.deb.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {

    private ExtentManager() {
    }

    private static final ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    static ExtentTest getExTest() {
        return exTest.get();
    }

    static void setExTest(ExtentTest test) {
        if (Objects.nonNull(test)) {
            exTest.set(test);
        }
    }

    static void unload() {
        exTest.remove();
    }
}
