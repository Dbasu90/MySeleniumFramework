package com.deb.utils;

import com.deb.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public final class ScreenshotUtil {

    private ScreenshotUtil() {
    }

    public static String captureScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static String captureScreenshot(WebElement element) {
        return element.getScreenshotAs(OutputType.BASE64);
    }
}
