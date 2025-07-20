package com.deb.pages;

import com.deb.enums.WaitStrategy;
import com.deb.pages.pagecomponents.FooterMenuComponent;
import com.deb.pages.pagecomponents.SideBarMenuComponent;
import com.deb.utils.SeleniumUtil;
import org.openqa.selenium.By;

public class HomePage {

    private static final By DIV_DASHBOARD = By.xpath("(//div[@class='oxd-topbar-header-title']//h6)[1]");

    private static final By LOGIN_PROFILE = By.xpath("//span[@class='oxd-userdropdown-tab']/i");

    private static final By LOGOUT_LNK = By.xpath("//a[text()='Logout']");

    private final SideBarMenuComponent sideBarMenuComponent;

    private final FooterMenuComponent footerMenuComponent;

    public HomePage() {
        sideBarMenuComponent = new SideBarMenuComponent();
        footerMenuComponent = new FooterMenuComponent();
    }

    public HomePage clickLoginProfile() {
        SeleniumUtil.click(LOGIN_PROFILE, WaitStrategy.PRESENT, "Login Profile");
        return this;
    }

    public LoginPage clickLogoutLink() {
        SeleniumUtil.click(LOGOUT_LNK, WaitStrategy.CLICKABLE, "Logout Link");
        return new LoginPage();
    }

    public String getLandingTitle() {
        return SeleniumUtil.getText(DIV_DASHBOARD, WaitStrategy.VISIBLE);
    }

    public String getFooterText() {
        return footerMenuComponent.getFooterLabel();
    }

    public void clickOnAdmin() {
        sideBarMenuComponent.clickMenuLabel("Admin");
    }


}
