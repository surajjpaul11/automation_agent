package com.automation.qa.pages;

import com.automation.qa.base.BasePage;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CartPage - Page Object for the shopping cart page
 */
public class CartPage extends BasePage {
    private ElementActions elementActions;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        this.elementActions = new ElementActions(driver);
    }

    /**
     * Click checkout button
     */
    public void clickCheckout() {
        elementActions.click(checkoutButton);
    }
}

