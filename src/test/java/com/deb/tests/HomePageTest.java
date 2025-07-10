package com.deb.tests;

import com.deb.pages.HomePage;
import com.deb.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description ="To verify user is able to access Admin page")
    public void verifyHomePage(){
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication("Admin","admin123");
        String actualTitle = homePage.getLandingTitle();
        Assert.assertEquals(actualTitle,"Dashboard");
        homePage.clickOnAdmin();
        String landingTitle = homePage.getLandingTitle();
        Assert.assertEquals(landingTitle,"Admin");
    }
}
