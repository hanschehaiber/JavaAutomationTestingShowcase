package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private static final By checkoutCompleteContainer = By.id("checkout_complete_container");
    private static final By completeText = By.cssSelector("[class='complete-text']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfCheckoutCompleteContainerIsDisplayed() {
        return getDriver().findElement(checkoutCompleteContainer).isDisplayed();
    }

    public String getCompleteText() {
        return getDriver().findElement(completeText).getText();
    }
}
