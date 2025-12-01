package com.automation.qa.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ElementActions - Keyword wrapper for element-level actions
 * Provides reusable methods for interacting with web elements
 * NO Thread.sleep() - Uses Explicit Waits only
 */
public class ElementActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Click on an element with explicit wait
     * @param element WebElement to click
     */
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Send keys to an element with explicit wait
     * @param element WebElement to send keys to
     * @param text Text to enter
     */
    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get text from an element with explicit wait
     * @param element WebElement to get text from
     * @return text content
     */
    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * Check if element is displayed
     * @param element WebElement to check
     * @return true if displayed, false otherwise
     */
    public boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if element is enabled
     * @param element WebElement to check
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get attribute value from element
     * @param element WebElement to get attribute from
     * @param attributeName attribute name
     * @return attribute value
     */
    public String getAttribute(WebElement element, String attributeName) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attributeName);
    }

    /**
     * Wait for element to be visible
     * @param element WebElement to wait for
     */
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for element to be clickable
     * @param element WebElement to wait for
     */
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

