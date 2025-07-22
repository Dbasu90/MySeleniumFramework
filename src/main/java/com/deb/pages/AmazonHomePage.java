package com.deb.pages;

import com.deb.enums.WaitStrategy;
import com.deb.pages.pagecomponents.SideBarMenuComponent;
import com.deb.utils.SeleniumUtil;
import org.openqa.selenium.By;

public final class AmazonHomePage {

    private static final By CONTINUE_BTN = By.xpath("//button[text()='Continue shopping']");

    private static final By HAMBURGER_MENU = By.id("nav-hamburger-menu");

    private final SideBarMenuComponent sideBarMenuComponent;

    public AmazonHomePage() {
        sideBarMenuComponent = new SideBarMenuComponent();
    }


    public SideBarMenuComponent clickOnHamburgerMenu() {
        SeleniumUtil.click(CONTINUE_BTN, WaitStrategy.VISIBLE, "Continue shopping");
        SeleniumUtil.click(HAMBURGER_MENU, WaitStrategy.CLICKABLE, "Hamburger Menu");
        return sideBarMenuComponent;
    }


}
