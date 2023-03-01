package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage{
    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final String TEXT_PATTERN = "%s[contains(text(),'%s')]";
    private static final String MENU_SECTION = "//*[contains(@class,'nav-link')]";
    private static final String CHILD_MENU_ITEM = "//*[contains(@class,'dropdown')]//*[contains(@class,'item')]";

    public void openCucumberWebsite(){
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement menuSection(String linkText){
        return findElement(xpath(format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }

    public WebElement menuChildItem(String linkText){
        return findElement(xpath(format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
    }
}
