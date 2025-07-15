package com.deb.driver;

import com.deb.utils.PropertyReaderUtil;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public final class RemoteDriverFactory {

    private RemoteDriverFactory() {
    }

    @SneakyThrows
    public static WebDriver getRemoteDriver(String browserName) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browserName.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
        } else if (browserName.equalsIgnoreCase("edge")) {
            capabilities.setBrowserName("edge");
        }
        driver = new RemoteWebDriver(new URL(PropertyReaderUtil.getValue("remoteUrl")), capabilities);
        return driver;
    }
}
