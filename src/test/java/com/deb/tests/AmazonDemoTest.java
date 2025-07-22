package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.AmazonHomePage;
import com.deb.utils.SeleniumUtil;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest {

    private AmazonDemoTest() {
    }

    @FrameworkAnnotation(author = "Debasmita", category = {"Smoke", "Regression"})
    @Test
    public void amazonTest(Map<String, String> testData) {
        new AmazonHomePage().clickOnHamburgerMenu()
                .clickMainMenuLabel("Mobiles, Computers").clickSubMenuLabel("Laptops");
        String actualTitle = SeleniumUtil.getPageTitle();
        Assertions.assertThat(actualTitle)
                .as("Actual Landing Page Title")
                .isNotBlank()
                .contains(testData.get("assertion value"));
    }
}
