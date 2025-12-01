package com.automation.qa.pages;

import com.automation.qa.base.BasePage;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage - Page Object for the login page
 */
public class LoginPage extends BasePage {
    private ElementActions elementActions;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.elementActions = new ElementActions(driver);
    }

    /**
     * Enter username
     * @param username username to enter
     */
    public void enterUsername(String username) {
        elementActions.sendKeys(usernameField, username);
    }

    /**
     * Enter password
     * @param password password to enter
     */
    public void enterPassword(String password) {
        elementActions.sendKeys(passwordField, password);
    }

    /**
     * Click login button
     */
    public void clickLogin() {
        elementActions.click(loginButton);
    }

    /**
     * Perform login with credentials
     * @param username username
     * @param password password
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}

