package com.automation.qa.steps;

import com.automation.qa.config.ConfigurationManager;
import com.automation.qa.hooks.Hooks;
import com.automation.qa.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * LoginCheckoutSteps - Step definitions for login and checkout flow
 */
public class LoginCheckoutSteps extends BaseSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private ConfigurationManager config;

    public LoginCheckoutSteps() {
        super();
        this.config = ConfigurationManager.getInstance();
    }

    @Given("user lands on login page")
    public void user_lands_on_login_page() {
        WebDriver driver = Hooks.getDriver();
        String baseUrl = config.getProperty("base.url", "https://www.saucedemo.com/");
        browserActions.navigateTo(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.login(username, password);
        productsPage = new ProductsPage(Hooks.getDriver());
    }

    @When("user adds {string} to cart")
    public void user_adds_to_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @When("user clicks Cart icon")
    public void user_clicks_cart_icon() {
        productsPage.clickCartIcon();
        cartPage = new CartPage(Hooks.getDriver());
    }

    @When("user clicks Checkout")
    public void user_clicks_checkout() {
        cartPage.clickCheckout();
        checkoutPage = new CheckoutPage(Hooks.getDriver());
    }

    @When("user enters details {string}, {string}, {string} and continues")
    public void user_enters_details_and_continues(String firstName, String lastName, String postalCode) {
        checkoutPage.fillCheckoutInfoAndContinue(firstName, lastName, postalCode);
        checkoutOverviewPage = new CheckoutOverviewPage(Hooks.getDriver());
        checkoutOverviewPage.clickFinish();
        checkoutCompletePage = new CheckoutCompletePage(Hooks.getDriver());
    }

    @Then("verify {string} message appears")
    public void verify_message_appears(String expectedMessage) {
        String actualMessage = checkoutCompletePage.getThankYouMessage();
        Assert.assertTrue("Expected message '" + expectedMessage + "' not found. Actual: " + actualMessage,
                actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()));
    }
}

