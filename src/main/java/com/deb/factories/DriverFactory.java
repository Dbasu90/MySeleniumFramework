package com.deb.factories;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browserName, String runMode) {
        WebDriver driver = null;
        if (runMode.equalsIgnoreCase("local")) {
            driver = LocalDriverFactory.getLocalDriver(browserName);
        } else if (runMode.equalsIgnoreCase("remote")) {
            driver = RemoteDriverFactory.getRemoteDriver(browserName);
        }
        return driver;
    }
}
