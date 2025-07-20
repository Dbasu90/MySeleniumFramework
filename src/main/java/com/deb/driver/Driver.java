package com.deb.driver;

import com.deb.constants.FrameworkConstants;
import com.deb.enums.ConfigProperties;
import com.deb.factories.ConfigFactory;
import com.deb.factories.DriverFactory;
import com.deb.utils.PropertyReaderUtil;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    //implemented traditional Property reading using Properties class as well as using Owner library to avoid data conversion from String

    public static void initDriver() {
        String browser = ConfigFactory.getConfig().browser();
        String runMode = PropertyReaderUtil.getValue(ConfigProperties.RUNMODE);
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = DriverFactory.getDriver(browser, runMode);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getTimeout()));
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
