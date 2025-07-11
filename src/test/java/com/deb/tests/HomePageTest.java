package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.HomePage;
import com.deb.pages.LoginPage;
import com.deb.utils.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class HomePageTest extends BaseTest {

    private static final String EXPECTED_TITLE = "Dashboard";

    @FrameworkAnnotation(author = "Debasmita", category = "Regression")
    @Test(description = "To verify user is able to access Admin page", dataProvider = "getData", dataProviderClass = DataProviderUtil.class)
    public void verifyHomePage(Map<String, String> data) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(data.get("username"), data.get("password"));
        String actualTitle = homePage.getLandingTitle();
        Assert.assertEquals(actualTitle, EXPECTED_TITLE);
        homePage.clickOnAdmin();
        String landingTitle = homePage.getLandingTitle();
        Assert.assertEquals(landingTitle, data.get("assertion value"));
    }

    @FrameworkAnnotation(author = "Basu", category = "Regression")
    @Test(description = "To verify footer is present", dataProvider = "getData", dataProviderClass = DataProviderUtil.class)
    public void verifyFooterText(Map<String, String> data) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(data.get("username"), data.get("password"));
        String actualTitle = homePage.getLandingTitle();
        Assert.assertEquals(actualTitle, EXPECTED_TITLE);
        String actualText = homePage.getFooterText();
        Assert.assertEquals(actualText, data.get("assertion value"));

    }
}
