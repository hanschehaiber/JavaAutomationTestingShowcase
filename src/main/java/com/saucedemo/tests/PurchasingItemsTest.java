package com.saucedemo.tests;

import com.saucedemo.pages.CheckoutCompletePage;
import com.saucedemo.pages.CheckoutInfoPage;
import com.saucedemo.pages.CheckoutOverviewPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.ShoppingCartPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PurchasingItemsTest extends TestBase {

    @Test
    public void purchasingASingleItemTest() {
        SoftAssert softly = new SoftAssert();
        String firstName = "John";
        String lastName = "Smith";
        String postalCode = "12345";
        String userName = "standard_user";
        String password = "secret_sauce";

        driver.get(prop.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(userName);
        loginPage.inputPassword(password);
        softly.assertTrue(loginPage.checkIfUsernamesArePresent());
        softly.assertTrue(loginPage.checkIfPasswordIsPresent());


        ProductsPage productsPage = loginPage.clickLogin(driver);
        double firstItemPrice = productsPage.getPriceByIndex(0);
        productsPage.clickAddToCartByIndex(0);
        ShoppingCartPage shoppingCartPage = productsPage.clickShoppingCart(driver);

        softly.assertEquals(shoppingCartPage.checkNumOfItemsInCart(), 1);

        CheckoutInfoPage checkoutInfoPage = shoppingCartPage.clickCheckout(driver);
        softly.assertTrue(checkoutInfoPage.checkIfTitleIsDisplayed());
        checkoutInfoPage.enterFirstName(firstName);
        checkoutInfoPage.enterLastName(lastName);
        checkoutInfoPage.enterPostalCode(postalCode);
        CheckoutOverviewPage checkoutOverviewPage = checkoutInfoPage.clickContinue(driver);
        softly.assertTrue(checkoutOverviewPage.checkIfTitleIsDisplayed());

        double subTotal = checkoutOverviewPage.getSubTotal();

        softly.assertEquals(firstItemPrice, subTotal);

        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinish(driver);

        softly.assertTrue(checkoutCompletePage.checkIfCheckoutCompleteContainerIsDisplayed());
        String completeTextMessage = checkoutCompletePage.getCompleteText();

        softly.assertEquals(completeTextMessage, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        softly.assertAll();
    }


}
