package com.herokuapp.the_internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementPage extends BasePage  {

    private By addElementButton = By.linkText("Add Element");
    public AddRemoveElementPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddElementButton() {
        driver.findElement(addElementButton).click();
    }

}
