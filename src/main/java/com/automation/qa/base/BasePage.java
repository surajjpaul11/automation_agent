package com.automation.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage - Base class for all Page Objects
 * Provides common functionality and initialization for Page Object Model
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Get the current page title
     * @return page title as String
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get the current page URL
     * @return current URL as String
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

