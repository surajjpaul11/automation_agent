package com.automation.qa.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BrowserActions - Keyword wrapper for browser-level actions
 * Provides reusable methods for common browser operations
 */
public class BrowserActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Navigate to a URL
     * @param url URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Get current page title
     * @return page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get current URL
     * @return current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Navigate back
     */
    public void navigateBack() {
        driver.navigate().back();
    }

    /**
     * Navigate forward
     */
    public void navigateForward() {
        driver.navigate().forward();
    }

    /**
     * Refresh the current page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Close the current window
     */
    public void closeWindow() {
        driver.close();
    }

    /**
     * Quit all browser windows
     */
    public void quitBrowser() {
        driver.quit();
    }
}

