package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends BaseTest {


    @FrameworkAnnotation(author = "Debasmita", category = {"Smoke", "Regression"})
    @Test
    public void loginLogoutTest(Map<String, String> testData) {
        String actualTitle = new LoginPage()
                .loginToApplication(testData.get("username"), testData.get("password"))
                .clickLoginProfile().clickLogoutLink().getTitle();
        assertThat(actualTitle).as("Login Page Title").isEqualTo(testData.get("assertion value"));
    }

    @FrameworkAnnotation(category = "Regression")
    @Test
    public void invalidLoginTest(Map<String, String> testData) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testData.get("username"), testData.get("password"));
        String actualError = loginPage.getErrorMsg();
        assertThat(actualError).as("Actual Error Message").isEqualTo(testData.get("assertion value"));
    }
}
