package com.automation.qa.pages;

import com.automation.qa.base.BasePage;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * CheckoutOverviewPage - Page Object for the checkout overview page
 */
public class CheckoutOverviewPage extends BasePage {
    private ElementActions elementActions;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.elementActions = new ElementActions(driver);
    }

    /**
     * Click finish button
     */
    public void clickFinish() {
        // Try to find finish button with multiple strategies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishBtn = wait.until(ExpectedConditions.elementToBeClickable(
            org.openqa.selenium.By.id("finish")
        ));
        if (finishBtn == null) {
            finishBtn = driver.findElement(org.openqa.selenium.By.xpath("//button[contains(text(), 'Finish')]"));
        }
        elementActions.click(finishBtn);
    }
}

