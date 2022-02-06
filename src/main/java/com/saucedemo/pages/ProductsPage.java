package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private static final By inventoryItems = By.cssSelector("[class='inventory_list'] > div");
    private static final By itemPrice = By.cssSelector("[class='inventory_item_price']");
    private static final By addToCart = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    List<WebElement> inventoryList;

    public ProductsPage(WebDriver driver) {
        super(driver);
        inventoryList = getDriver().findElements(inventoryItems);
    }

    public double getPriceByIndex(int index) {
        String priceStr = inventoryList.get(index).findElement(itemPrice).getText().trim();
        priceStr = priceStr.replace("$", "");
        return Double.parseDouble(priceStr);
    }

    public void clickAddToCartByIndex(int index) {
        inventoryList.get(index).findElement(addToCart).click();
    }


}
