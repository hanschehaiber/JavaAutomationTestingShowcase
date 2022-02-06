package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private static final By title = By.cssSelector("[class='title']");

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfTitleIsDisplayed() {
        return getDriver().findElement(title).isDisplayed();
    }
}
