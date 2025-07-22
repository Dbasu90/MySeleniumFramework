package com.deb.pages.pagecomponents;

import com.deb.enums.WaitStrategy;
import com.deb.utils.SeleniumUtil;
import org.openqa.selenium.By;

public final class SideBarMenuComponent {

    private static final String LABEL_MENU = "//span[text()='%s']/..";

    private static final String MAIN_MENU_LABEL = "//div[text()='%s']/parent::a[@role='button']";

    private static final String SUB_MENU_LABEL = "//a[text()='%s' and @class='hmenu-item']";

    public void clickMenuLabel(String menu) {
        String formattedXpath = String.format(LABEL_MENU, menu);
        SeleniumUtil.click(By.xpath(formattedXpath), WaitStrategy.PRESENT, menu);
    }

    public SideBarMenuComponent clickMainMenuLabel(String menu) {
        String formattedXpath = String.format(MAIN_MENU_LABEL, menu);
        SeleniumUtil.click(By.xpath(formattedXpath), WaitStrategy.CLICKABLE, menu);
        return this;
    }

    public void clickSubMenuLabel(String menu) {
        String formattedXpath = String.format(SUB_MENU_LABEL, menu);
        SeleniumUtil.scrollAndClick(By.xpath(formattedXpath), WaitStrategy.PRESENT, menu);
    }
}
