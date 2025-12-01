package com.automation.qa.pages;

import com.automation.qa.base.BasePage;
import com.automation.qa.keywords.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ProductsPage - Page Object for the products/inventory page
 */
public class ProductsPage extends BasePage {
    private ElementActions elementActions;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.elementActions = new ElementActions(driver);
    }

    /**
     * Add product to cart by product name
     * @param productName name of the product to add
     */
    public void addProductToCart(String productName) {
        String xpath = "//div[text()='Sauce Labs " + productName + "']/ancestor::div[@class='inventory_item']//button[contains(text(), 'Add to cart')]";
        WebElement addToCartButton = driver.findElement(org.openqa.selenium.By.xpath(xpath));
        elementActions.click(addToCartButton);
    }

    /**
     * Click cart icon
     */
    public void clickCartIcon() {
        elementActions.click(cartIcon);
    }
}

