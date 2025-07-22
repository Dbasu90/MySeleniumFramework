package com.deb.pages.pagecomponents;

import com.deb.driver.DriverManager;
import org.openqa.selenium.By;

public final class FooterMenuComponent {

    private static final By LABEL_FOOTER = By.xpath("//div[@class='oxd-layout-footer']/p[1]");

    public String getFooterLabel() {
        return DriverManager.getDriver().findElement(LABEL_FOOTER).getText();
    }
}
