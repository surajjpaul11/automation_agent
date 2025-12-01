package com.automation.qa.base;

import com.automation.qa.config.ConfigurationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * TestBase - Base class for test setup and WebDriver management
 * Handles browser initialization and configuration
 */
public class TestBase {
    protected WebDriver driver;
    protected ConfigurationManager config;

    public TestBase() {
        config = ConfigurationManager.getInstance();
    }

    /**
     * Initialize WebDriver based on browser configuration
     * @return WebDriver instance
     */
    public WebDriver initializeDriver() {
        String browser = config.getProperty("browser", "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(config.getProperty("headless", "false"));

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Quit the WebDriver instance
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

