package com.deb.pages;

import com.deb.enums.WaitStrategy;
import com.deb.utils.SeleniumUtil;
import org.openqa.selenium.By;

public final class LoginPage {

    private static final By TXTBOX_USERNAME = By.xpath("//input[@name='username']");

    private static final By TXTBOX_PASSWORD = By.xpath("//input[@name='password']");

    private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");

    private static final By ERROR_MSG = By.xpath("//div[@role='alert']//p");

    public LoginPage setUserName(String userName) {
        SeleniumUtil.enterText(TXTBOX_USERNAME, userName, WaitStrategy.PRESENT, "Username");
        return this;
    }

    public LoginPage setPassword(String password) {
        SeleniumUtil.enterText(TXTBOX_PASSWORD, password, WaitStrategy.PRESENT, "Password");
        return this;
    }

    public HomePage clickLogin() {
        SeleniumUtil.click(BTN_LOGIN, WaitStrategy.CLICKABLE, "Login Button");
        return new HomePage();
    }

    public HomePage loginToApplication(String username, String password) {
        return setUserName(username).
                setPassword(password).
                clickLogin();
    }

    public String getErrorMsg() {
        return SeleniumUtil.getText(ERROR_MSG, WaitStrategy.VISIBLE);
    }

    public String getTitle() {
        return SeleniumUtil.getPageTitle();
    }
}
