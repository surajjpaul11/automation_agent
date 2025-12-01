package com.automation.qa.pages;

import com.automation.qa.base.BasePage;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CheckoutCompletePage - Page Object for the checkout complete page
 */
public class CheckoutCompletePage extends BasePage {
    private ElementActions elementActions;

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        this.elementActions = new ElementActions(driver);
    }

    /**
     * Get thank you message text
     * @return thank you message
     */
    public String getThankYouMessage() {
        elementActions.waitForVisibility(thankYouMessage);
        return elementActions.getText(thankYouMessage);
    }

    /**
     * Verify thank you message is displayed
     * @return true if message is displayed
     */
    public boolean isThankYouMessageDisplayed() {
        return elementActions.isDisplayed(thankYouMessage);
    }
}

