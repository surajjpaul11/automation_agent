package com.automation.qa.hooks;

import com.automation.qa.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

/**
 * Hooks - Cucumber hooks for test setup and teardown
 * Handles WebDriver initialization and cleanup
 */
public class Hooks {
    private static WebDriver driver;
    private TestBase testBase;

    public Hooks() {
        testBase = new TestBase();
    }

    /**
     * Before hook - runs before each scenario
     * Initializes WebDriver
     */
    @Before
    public void setUp() {
        driver = testBase.initializeDriver();
    }

    /**
     * After hook - runs after each scenario
     * Cleans up WebDriver
     */
    @After
    public void tearDown() {
        if (driver != null) {
            testBase.tearDown();
        }
    }

    /**
     * Get the current WebDriver instance
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }
}

