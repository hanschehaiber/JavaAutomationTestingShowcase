package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By username = By.xpath("//input[@data-test='username']");
    private static final By password = By.id("password");
    private static final By login = By.cssSelector("#login-button");
    private static final By displayedUsernames = By.id("login_credentials");
    private static final By displayedPassword = By.cssSelector("[class='login_password']");
    private static final By error = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputPassword(String passwordText) {
        getDriver().findElement(password).sendKeys(passwordText);
    }

    public void inputUsername(String usernameText) {
        getDriver().findElement(username).sendKeys(usernameText);
    }

    public boolean checkIfUsernamesArePresent() {
        return !getDriver().findElements(displayedUsernames).isEmpty();
    }

    public boolean checkIfPasswordIsPresent() {
        return getDriver().findElement(displayedPassword).isDisplayed();
    }

    public ProductsPage clickLogin() {
        getDriver().findElement(login).click();
        return new ProductsPage(getDriver());
    }

    public String getErrorMessage() {
        return getDriver().findElement(error).getText();
    }

    public boolean checkIfErrorMessageIsDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = getDriver().findElement(error).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
