package com.deb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.deb.config.ConfigFactory;
import com.deb.utils.ScreenshotUtil;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        if (ConfigFactory.getConfig().screenshotForPassedSteps()) {
            ExtentManager.getThreadTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.captureScreenshot()).build());
        } else {
            ExtentManager.getThreadTest().pass(message);

        }

    }

    public static void fail(String message) {
        ExtentManager.getThreadTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.captureScreenshot()).build());
    }

    public static void info(String message) {
        ExtentManager.getThreadTest().info(message);
    }

}
