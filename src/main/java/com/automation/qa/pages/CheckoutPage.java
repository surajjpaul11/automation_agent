package com.automation.qa.pages;

import com.automation.qa.base.BasePage;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CheckoutPage - Page Object for the checkout information page
 */
public class CheckoutPage extends BasePage {
    private ElementActions elementActions;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.elementActions = new ElementActions(driver);
    }

    /**
     * Enter first name
     * @param firstName first name
     */
    public void enterFirstName(String firstName) {
        elementActions.sendKeys(firstNameField, firstName);
    }

    /**
     * Enter last name
     * @param lastName last name
     */
    public void enterLastName(String lastName) {
        elementActions.sendKeys(lastNameField, lastName);
    }

    /**
     * Enter postal code
     * @param postalCode postal code
     */
    public void enterPostalCode(String postalCode) {
        elementActions.sendKeys(postalCodeField, postalCode);
    }

    /**
     * Click continue button
     */
    public void clickContinue() {
        elementActions.click(continueButton);
    }

    /**
     * Fill checkout information and continue
     * @param firstName first name
     * @param lastName last name
     * @param postalCode postal code
     */
    public void fillCheckoutInfoAndContinue(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
        // Wait for navigation to checkout step two
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("checkout-step-two"));
    }
}

