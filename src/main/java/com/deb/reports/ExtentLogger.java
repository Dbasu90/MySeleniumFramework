package com.deb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.deb.factories.ConfigFactory;
import com.deb.utils.ScreenshotUtil;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        if (ConfigFactory.getConfig().passedStepsScreenshots().equalsIgnoreCase("yes")) {
            ExtentManager.getExTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.captureScreenshot()).build());
        } else {
            ExtentManager.getExTest().pass(message);

        }

    }

    public static void fail(String message) {
        if (ConfigFactory.getConfig().failedStepsScreenshots().equalsIgnoreCase("yes")) {
            ExtentManager.getExTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.captureScreenshot()).build());
        } else {
            ExtentManager.getExTest().fail(message);
        }
    }

    public static void skip(String message) {
        ExtentManager.getExTest().skip(message);
    }

    public static void info(String message) {
        ExtentManager.getExTest().info(message);
    }

}
