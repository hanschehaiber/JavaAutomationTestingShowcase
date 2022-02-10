package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private static final By title = By.cssSelector("[class='title']");
    private static final By firstName = By.id("first-name");
    private static final By lastName = By.id("last-name");
    private static final By postalCode = By.id("postal-code");
    private static final By continueButton = By.id("continue");

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfTitleIsDisplayed() {
        return getDriver().findElement(title).isDisplayed();
    }

    public void enterFirstName(String firstNameText) {
        getDriver().findElement(firstName).sendKeys(firstNameText);
    }

    public void enterLastName(String lastNameText) {
        getDriver().findElement(lastName).sendKeys(lastNameText);
    }

    public void enterPostalCode(String postalCodeText) {
        getDriver().findElement(postalCode).sendKeys(postalCodeText);
    }

    public CheckoutOverviewPage clickContinue(WebDriver driver) {
        getDriver().findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }
}
