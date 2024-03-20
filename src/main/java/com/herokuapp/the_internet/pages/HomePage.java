package com.herokuapp.the_internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By addRemoveElementsBy = By.linkText("Add/Remove Elements");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddRemoveElements() {
        driver.findElement(addRemoveElementsBy).click();
    }



}
