package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By username = By.xpath("//input[@data-test='username']");
    By password = By.id("password");
    By login = By.cssSelector("#login-button");
    By displayedUsernames = By.id("login_credentials");
    By displayedPassword = By.cssSelector("[class='login_password']");

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
}
