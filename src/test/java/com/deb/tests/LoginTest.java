package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.HomePage;
import com.deb.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider
    public static Object[][] getData1() {
        return new Object[][]{
                {"Admin", "admin123", "manda user"},
        };
    }

    @DataProvider
    public static Object[][] getData2() {
        return new Object[][]{
                {"Admin123", "admin123", "Invalid credentials"}
        };
    }

    @FrameworkAnnotation(author = "Debasmita", category = {"Smoke", "Regression"})
    @Test(description = "To verify if user can successfully login", dataProvider = "getData1")
    public void login(String userName, String password, String expectedUser) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(userName, password);
        Thread.sleep(3000);
        String actualUser = homePage.getLoginUser();
        Assert.assertEquals(actualUser, expectedUser);
    }

    @FrameworkAnnotation(category = "Regression")
    @Test(description = "To verify if error is prompted on invalid login", dataProvider = "getData2")
    public void invalidLogin(String userName, String password, String expectedError) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(userName, password);
        Thread.sleep(3000);
        String actualError = loginPage.getErrorMsg();
        Assert.assertEquals(actualError, expectedError);
    }
}
