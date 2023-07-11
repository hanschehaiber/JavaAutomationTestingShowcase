package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    private static final By cartItems = By.cssSelector("[class='cart_item']");
    private static final By checkout = By.cssSelector("[data-test='checkout']");

    private List<WebElement> cartItemList;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        cartItemList = getDriver().findElements(cartItems);
    }

    public int checkNumOfItemsInCart() {
        return cartItemList.size();
    }

    public CheckoutInfoPage clickCheckout() {
        getDriver().findElement(checkout).click();
        return new CheckoutInfoPage(getDriver());

    }


}
