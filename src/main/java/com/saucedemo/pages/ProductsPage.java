package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    private static final By inventoryItems = By.cssSelector("[class='inventory_list'] > div");
    private static final By itemPrice = By.cssSelector("[class='inventory_item_price']");
    List<WebElement> inventoryList;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        inventoryList = this.driver.findElements(inventoryItems);
    }

    public String getPriceByIndex(int index) {
        return inventoryList.get(index).findElement(itemPrice).getText();
    }






}
