package com.deb.pages.pageComponents;

import com.deb.utils.SeleniumUtil;
import org.openqa.selenium.By;

public class SideBarMenuComponent {

    private static final String LABEL_MENU = "//span[text()='%s']/..";

    public void clickMenuLabel(String menu) {
        String formattedXpath = String.format(LABEL_MENU, menu);
        SeleniumUtil.click(By.xpath(formattedXpath), menu);
    }
}
