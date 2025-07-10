package com.deb.utils;

import com.deb.config.ConfigFactory;
import com.deb.driver.DriverManager;
import com.deb.enums.WaitType;
import com.deb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtil {

    public static void enterText(By by, String text, String elementName) {
        WebElement element = waitUntilElementPresent(by);
        element.sendKeys(text);
        ExtentLogger.pass(text + " is successfully entered in " + elementName);
    }

    public static void click(WebElement element) {
        element.click();
        ExtentLogger.pass("Element is successfully clicked");
    }

    public static void click(By by, String elementName) {
        WebElement element = waitUntilElementPresent(by);
        element.click();
        ExtentLogger.pass(elementName + " is successfully clicked");
    }

    public static void click(By by, WaitType waitType) {
        WebElement element = null;
        if (waitType == WaitType.PRESENT) {
            element = waitUntilElementPresent(by);
        } else if (waitType == WaitType.CLICKABLE) {
            element = waitUntilElementClickable(by);
        } else if (waitType == WaitType.VISIBLE) {
            element = waitUntilElementVisible(by);
        }
        click(element);
    }

    public static String getText(By by) {
        WebElement element = waitUntilElementPresent(by);
        ExtentLogger.pass("Value has been successfully retrieved");
        return element.getText();
    }

    private static WebElement waitUntilElementVisible(By by) {
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigFactory.getConfig().timeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement waitUntilElementClickable(By by) {
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigFactory.getConfig().timeout()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigFactory.getConfig().timeout()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
