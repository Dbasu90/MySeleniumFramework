package com.deb.utils;

import com.deb.driver.DriverManager;
import com.deb.enums.WaitStrategy;
import com.deb.factories.ExplicitWaitFactory;
import com.deb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class SeleniumUtil {

    private SeleniumUtil() {
    }

    public static void enterText(By by, String text, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.sendKeys(text);
        ExtentLogger.pass(text + " is successfully entered in " + elementName);
    }

    public static void click(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();
        ExtentLogger.pass(elementName + " is successfully clicked");
    }

    public static String getText(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        ExtentLogger.pass("Value has been successfully retrieved");
        return element.getText();
    }


    public static String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
