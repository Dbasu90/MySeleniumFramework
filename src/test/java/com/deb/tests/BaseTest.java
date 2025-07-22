package com.deb.tests;

import com.deb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

@SuppressWarnings("java:S2187")
public class BaseTest {

    protected BaseTest() {
    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    public void setUp(Object[] data) {
        Map<String, String> testData = (Map<String, String>) data[0];
        Driver.initDriver(testData.get("browser"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
