package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.HomePage;
import com.deb.pages.LoginPage;
import com.deb.testdataPojo.TestData;
import com.deb.utils.DataSupplierUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @FrameworkAnnotation(author = "Debasmita", category = {"Smoke", "Regression"})
    @Test(description = "To verify if user can successfully login", dataProvider = "getTestData", dataProviderClass = DataSupplierUtil.class)
    public void login(TestData testData) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(testData.username, testData.password);
        Thread.sleep(3000);
        String actualUser = homePage.getLoginUser();
        Assert.assertEquals(actualUser, testData.assertionValue);
    }

    @FrameworkAnnotation(category = "Regression")
    @Test(description = "To verify if error is prompted on invalid login", dataProvider = "getTestData", dataProviderClass = DataSupplierUtil.class)
    public void invalidLogin(TestData testData) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testData.username, testData.password);
        Thread.sleep(3000);
        String actualError = loginPage.getErrorMsg();
        Assert.assertEquals(actualError, testData.assertionValue);
    }
}
