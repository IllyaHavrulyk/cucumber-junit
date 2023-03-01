package com.cucumber.junit.hooks;

import com.cucumber.junit.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHook {

    public static final String PNG_FILE_EXTENSION = "image/png";

    @After
    public void takeScreenshot(Scenario scenario){
        scenario.write(DriverManager.getDriver().getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, PNG_FILE_EXTENSION, scenario.getName());
    }
}
