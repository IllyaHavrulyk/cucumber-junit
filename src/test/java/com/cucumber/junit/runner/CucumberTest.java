package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/CucumberTests" +
        ".json", "junit:target/cucumber-reports/CucumberTests.xml"},
        monochrome = true,
        tags = "",
        glue = "com.cucumber.junit",
features = "classpath:com/cucumber/junit/")
public class CucumberTest {
}
