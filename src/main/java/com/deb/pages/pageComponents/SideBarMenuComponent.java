package com.deb.pages.pageComponents;

import com.deb.driver.DriverManager;
import org.openqa.selenium.By;

public class SideBarMenuComponent {

    private static final String LABEL_MENU = "//span[text()='%s']/..";

    public void clickMenuLabel(String menu){
        String formattedXpath = String.format(LABEL_MENU,menu);
        DriverManager.getDriver().findElement(By.xpath(formattedXpath)).click();
    }
}
