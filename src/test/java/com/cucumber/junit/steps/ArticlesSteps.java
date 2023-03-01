package com.cucumber.junit.steps;

import com.cucumber.junit.driver.DriverManager;
import com.cucumber.junit.pages.ArticlesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticlesSteps {
    private final ArticlesPage articlesPage = new ArticlesPage();

    @Given("the user opens Cucumber Home website")
    public void theUserOpensCucumberHomeWebsite() {
        articlesPage.openCucumberWebsite();
    }

    @When("the user clicks on search icon")
    public void theUserClicksOnSearchIcon() {
        articlesPage.getSearchIcon().click();
    }

    @And("the user enters {string} to search input")
    public void theUserEntersToSearchInput(String searchText) {
        articlesPage.getSearchInput().sendKeys(searchText);
    }

    @And("the user filters result by parameter Blog")
    public void theUserFiltersResultByParameterBlog(){
        articlesPage.getBlogFilterItem().click();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
        wait.withTimeout(Duration.ofSeconds(30L));
    }

    @And("the user opens {string} article")
    public void theUserOpensArticle(String articleLink) throws InterruptedException {
        articlesPage.getArticleItem(articleLink).click();
    }

    @Then("check if article with {string} is opened")
    public void checkIfArticleWithIsOpened(String articleTitle) {
        Assertions.assertThat(articlesPage.articleExists(articleTitle))
                .overridingErrorMessage("Article with this title does not exist!")
                .isTrue();
    }
}
