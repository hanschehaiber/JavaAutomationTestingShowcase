package com.herokuapp.the_internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementPage extends BasePage  {

    private By addElementButton = By.xpath("//button[contains(text(), 'Add Element')]");
    private By addedElements = By.id("elements");
    public AddRemoveElementPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddElementButton() {
        driver.findElement(addElementButton).click();
    }

    public int countHowManyAddedElements() {
        return driver.findElements(addedElements).size();
    }

}
