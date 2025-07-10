package com.deb.utils;

import com.deb.config.ConfigFactory;
import com.deb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtil {

    public static void enterText(By by, String text){
        WebElement element = waitUntilElementPresent(by);
        element.sendKeys(text);
    }

    public static void click(WebElement element){
        element.click();
    }

    public static void click(By by){
        WebElement element = waitUntilElementPresent(by);
        click(element);
    }

    public static void click(By by, String waitType){
        WebElement element=null;
        if(waitType.equalsIgnoreCase("Presence")){
            element = waitUntilElementPresent(by);
        } else if (waitType.equalsIgnoreCase("Clickable")) {
            element = waitUntilElementClickable(by);
        } else if (waitType.equalsIgnoreCase("Visible")) {
            element = waitUntilElementVisible(by);
        }
        click(element);
    }

    public static String getText(By by){
        WebElement element = waitUntilElementPresent(by);
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
