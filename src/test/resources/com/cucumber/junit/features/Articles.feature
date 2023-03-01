Feature: As a user I want to search for articles filtered by certain parameter

  @smoke
  Scenario Outline: The first article with announce should open
    Given the user opens Cucumber Home website
    When the user clicks on search icon
    And the user enters "Announces" to search input
    And the user filters result by parameter Blog
    And the user opens "<article_link>" article
    Then check if article with "<article_title>" is opened
    Examples:
      |article_title|article_link|
      |Announcing cucumber-electron|https://cucumber.io/blog/open-source/announcing-cucumber-electron/?sbsearch=Announces|
