package com.deb.tests;

import com.deb.annotations.FrameworkAnnotation;
import com.deb.pages.LoginPage;
import com.deb.testdataPojo.TestData;
import com.deb.utils.DataSupplierUtil;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public final class LoginWithDataSupplierTest extends BaseTest {

    private LoginWithDataSupplierTest() {
    }


    @FrameworkAnnotation(author = "Debasmita", category = {"Smoke", "Regression"})
    @Test(description = "To verify if user can successfully login and logout", dataProvider = "getTestData", dataProviderClass = DataSupplierUtil.class)
    public void loginLogoutTest(TestData testData) {
        String actualTitle = new LoginPage()
                .loginToApplication(testData.username, testData.password)
                .clickLoginProfile().clickLogoutLink().getTitle();
        assertThat(actualTitle).as("Login Page Title").isEqualTo(testData.assertionValue);
    }

    @FrameworkAnnotation(category = "Regression")
    @Test(description = "To verify if error is prompted on invalid login", dataProvider = "getTestData", dataProviderClass = DataSupplierUtil.class)
    public void invalidLoginTest(TestData testData) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testData.username, testData.password);
        String actualError = loginPage.getErrorMsg();
        assertThat(actualError).as("Actual Error Message").isEqualTo(testData.assertionValue);
    }
}
