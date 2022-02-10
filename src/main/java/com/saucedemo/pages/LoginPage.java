package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private static final By username = By.xpath("//input[@data-test='username']");
    private static final By password = By.id("password");
    private static final By login = By.cssSelector("#login-button");
    private static final By displayedUsernames = By.id("login_credentials");
    private static final By displayedPassword = By.cssSelector("[class='login_password']");
    private static final By error = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }

    public void inputUsername(String usernameText) {
        driver.findElement(username).sendKeys(usernameText);
    }

    public boolean checkIfUsernamesArePresent() {
        return !driver.findElements(displayedUsernames).isEmpty();
    }

    public boolean checkIfPasswordIsPresent() {
        return driver.findElement(displayedPassword).isDisplayed();
    }

    public ProductsPage clickLogin(WebDriver driver) {
        driver.findElement(login).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(error).getText();
    }

    public boolean checkIfErrorMessageIsDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(error).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
