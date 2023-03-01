package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ArticlesPage extends BasePage {
    public static final String BLOG = "Blog";
    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final By SEARCH_ICON = By.className("sb-search-ico");
    private static final By SEARCH_INPUT = By.className("app-input-query");
    private static final String BLOG_FILTER_ITEM = "//*[@id=\"searchComponent\"]/div/div[2]/div[2]/div[1]/div/div[1" +
            "]/div[2]";
    private static final String ARTICLE_ITEM = "//*[contains(@href,'%s')]";
    private static final String ARTICLE_TITLE_PATH = "//*[contains(text(), '%s')]";
    public WebElement getSearchIcon() {
        return findElement(SEARCH_ICON);
    }

    public WebElement getSearchInput() {
        return findElement(SEARCH_INPUT);
    }


    public void openCucumberWebsite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement getBlogFilterItem() {
        return DriverManager.getDriver().findElement(By.xpath(BLOG_FILTER_ITEM));
    }

    public WebElement getArticleItem(String articleLink) {
        return DriverManager.getDriver().findElement(By.xpath(format(ARTICLE_ITEM, articleLink)));
    }

    public boolean articleExists(String articleTitle){
        return isElementDisplayed(By.xpath(format(ARTICLE_TITLE_PATH, articleTitle)));
    }
}
