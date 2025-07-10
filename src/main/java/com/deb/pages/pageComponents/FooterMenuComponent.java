package com.deb.pages.pageComponents;

import com.deb.driver.DriverManager;
import org.openqa.selenium.By;

public class FooterMenuComponent {

    private static final By LABEL_FOOTER = By.xpath("//div[@class='oxd-layout-footer']/p");

    public String getFooterLabel(){
       return  DriverManager.getDriver().findElement(LABEL_FOOTER).getText();
    }
}
