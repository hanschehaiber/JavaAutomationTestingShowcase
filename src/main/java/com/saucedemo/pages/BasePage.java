package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private static final By shoppingCart = By.cssSelector("[class='shopping_cart_link']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingCartPage clickShoppingCart() {
        driver.findElement(shoppingCart).click();
        return new ShoppingCartPage(driver);
    }
}
