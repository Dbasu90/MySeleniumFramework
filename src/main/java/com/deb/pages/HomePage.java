package com.deb.pages;

import com.deb.pages.pageComponents.FooterMenuComponent;
import com.deb.pages.pageComponents.SideBarMenuComponent;
import com.deb.utils.SeleniumUtil;
import org.openqa.selenium.By;

public class HomePage {

    private static final By DIV_DASHBOARD = By.xpath("(//div[@class='oxd-topbar-header-title']//h6)[1]");

    private static final By LOGIN_USER = By.xpath("//span[@class='oxd-userdropdown-tab']/p");

    private final SideBarMenuComponent sideBarMenuComponent;

    private final FooterMenuComponent footerMenuComponent;

    public HomePage() {
        sideBarMenuComponent = new SideBarMenuComponent();
        footerMenuComponent = new FooterMenuComponent();
    }

    public String getLoginUser() {
        return SeleniumUtil.getText(LOGIN_USER);
    }

    public String getLandingTitle() {
        return SeleniumUtil.getText(DIV_DASHBOARD);
    }

    public String getFooterText() {
        return footerMenuComponent.getFooterLabel();
    }

    public void clickOnAdmin() {
        sideBarMenuComponent.clickMenuLabel("Admin");
    }


}
