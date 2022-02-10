package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutOverviewPage extends BasePage {

    private static final By title = By.cssSelector("[class='title']");
    private static final By subTotal = By.cssSelector("[class='summary_subtotal_label']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfTitleIsDisplayed() {
        return getDriver().findElement(title).isDisplayed();
    }

    public double getSubTotal() {
        String textWithSubTotal = getDriver().findElement(subTotal).getText();
        String regex = "((\\$)\\d+.\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textWithSubTotal);
        boolean matchFound = matcher.find();
        String extractedPrice = null;
        if (matchFound) {
            extractedPrice = matcher.group(0).replace("$", "");
        }

        assert extractedPrice != null;
        return Double.parseDouble(extractedPrice);
    }
}
