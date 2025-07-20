package com.deb.factories;

import com.deb.constants.FrameworkConstants;
import com.deb.driver.DriverManager;
import com.deb.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement element = null;
        WebDriver driver = DriverManager.getDriver();
        if (waitStrategy == WaitStrategy.PRESENT) {
            element = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getTimeout()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getTimeout()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getTimeout()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }

        return element;
    }


}
