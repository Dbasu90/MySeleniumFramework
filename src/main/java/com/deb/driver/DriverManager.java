package com.deb.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {

    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        if (Objects.nonNull(driver)) {
            threadLocal.set(driver);
        }
    }

    public static void unload() {
        threadLocal.remove();
    }
}
