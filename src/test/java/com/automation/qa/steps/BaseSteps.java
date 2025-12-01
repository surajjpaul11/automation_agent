package com.automation.qa.steps;

import com.automation.qa.hooks.Hooks;
import com.automation.qa.keywords.BrowserActions;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;

/**
 * BaseSteps - Base class for step definitions
 * Provides common functionality and keyword wrappers for step definitions
 */
public class BaseSteps {
    protected WebDriver driver;
    protected BrowserActions browserActions;
    protected ElementActions elementActions;

    public BaseSteps() {
        this.driver = Hooks.getDriver();
        this.browserActions = new BrowserActions(driver);
        this.elementActions = new ElementActions(driver);
    }
}

