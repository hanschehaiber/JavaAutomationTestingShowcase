package com.saucedemo;

import com.saucedemo.pages.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PurchasingItemsTest extends TestBase {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "John", "Smith" }, { "Luke", "Skywalker" } };
    }

    @Test(dataProvider = "data-provider")
    public void purchasingASingleItemTest(String firstName, String lastName) {
        SoftAssert softly = new SoftAssert();
        String postalCode = "12345";
        String userName = "standard_user";
        String password = "secret_sauce";

        driver.get(prop.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(userName);
        loginPage.inputPassword(password);
        softly.assertTrue(loginPage.checkIfUsernamesArePresent());
        softly.assertTrue(loginPage.checkIfPasswordIsPresent());


        ProductsPage productsPage = loginPage.clickLogin();
        double firstItemPrice = productsPage.getPriceByIndex(0);
        productsPage.clickAddToCartByIndex(0);
        ShoppingCartPage shoppingCartPage = productsPage.clickShoppingCart();

        softly.assertEquals(shoppingCartPage.checkNumOfItemsInCart(), 1);

        CheckoutInfoPage checkoutInfoPage = shoppingCartPage.clickCheckout();
        softly.assertTrue(checkoutInfoPage.checkIfTitleIsDisplayed());
        checkoutInfoPage.enterFirstName(firstName);
        checkoutInfoPage.enterLastName(lastName);
        checkoutInfoPage.enterPostalCode(postalCode);
        CheckoutOverviewPage checkoutOverviewPage = checkoutInfoPage.clickContinue();
        softly.assertTrue(checkoutOverviewPage.checkIfTitleIsDisplayed());

        double subTotal = checkoutOverviewPage.getSubTotal();

        softly.assertEquals(firstItemPrice, subTotal);

        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinish();

        softly.assertTrue(checkoutCompletePage.checkIfCheckoutCompleteContainerIsDisplayed());
        String completeTextMessage = checkoutCompletePage.getCompleteText();

        softly.assertEquals(completeTextMessage, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        softly.assertAll();
    }


}
