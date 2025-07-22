package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.HomePage;
import com.deb.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class HomePageTest extends BaseTest {

    private HomePageTest() {
    }

    private static final String EXPECTED_TITLE = "Dashboard";

    @FrameworkAnnotation(author = "Debasmita", category = "Regression")
    @Test
    public void verifyHomePageTest(Map<String, String> data) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(data.get("username"), data.get("password"));
        String actualTitle = homePage.getLandingTitle();
        assertThat(actualTitle).as("Homepage Landing Title").isEqualTo(EXPECTED_TITLE);
        homePage.clickOnAdmin();
        String landingTitle = homePage.getLandingTitle();
        assertThat(landingTitle).as("Landing Page Title").isEqualTo(data.get("assertion value"));
    }

    @FrameworkAnnotation(author = "Basu", category = "Regression")
    @Test
    public void verifyFooterTextTest(Map<String, String> data) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication(data.get("username"), data.get("password"));
        String actualTitle = homePage.getLandingTitle();
        assertThat(actualTitle).as("Homepage Landing Title").isEqualTo(EXPECTED_TITLE);
        String actualText = homePage.getFooterText();
        assertThat(actualText).as("Actual Footer Text").isEqualTo(data.get("assertion value"));

    }
}
