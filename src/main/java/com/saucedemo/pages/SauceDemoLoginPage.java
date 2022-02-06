package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoLoginPage {
    WebDriver driver;

    By username = By.xpath("//input[@data-test='username']");
    By password = By.id("password");

    public SauceDemoLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }

    public void inputUsername(String usernameText) {
        driver.findElement(username).sendKeys(usernameText);
    }
}