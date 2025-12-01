package com.automation.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * TestRunner - Main test runner for Cucumber BDD tests
 * Executes feature files from src/test/resources/features
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.qa.steps", "com.automation.qa.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml"
        },
        monochrome = true,
        tags = "@smoke or not @ignore"
)
public class TestRunner {
}

