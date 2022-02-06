package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    By inventoryItems = By.cssSelector("[class='inventory_list'] > div");
    List<WebElement> inventoryList;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        inventoryList = driver.findElements(inventoryItems);
    }


}
