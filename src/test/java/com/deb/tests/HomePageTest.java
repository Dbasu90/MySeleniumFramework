package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.HomePage;
import com.deb.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @FrameworkAnnotation(author = "Debasmita", category = "Regression")
    @Test(description = "To verify user is able to access Admin page")
    public void verifyHomePage() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication("Admin", "admin123");
        String actualTitle = homePage.getLandingTitle();
        Assert.assertEquals(actualTitle, "Dashboard");
        homePage.clickOnAdmin();
        String landingTitle = homePage.getLandingTitle();
        Assert.assertEquals(landingTitle, "Admin");
    }

    @FrameworkAnnotation(author = "Basu", category = "Regression")
    @Test(description = "To verify footer is present")
    public void verifyFooterText() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication("Admin", "admin123");
        String actualTitle = homePage.getLandingTitle();
        Assert.assertEquals(actualTitle, "Dashboard");
        String actualText = homePage.getFooterText();
        Assert.assertEquals(actualText, "OrangeHRM OS 5.7");

    }
}
