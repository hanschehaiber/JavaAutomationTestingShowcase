package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PurchasingItemsTest extends TestBase {

    @Test
    public void purchasingASingleItemTest() {
        SoftAssert softly = new SoftAssert();

        driver.get(prop.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        softly.assertTrue(loginPage.checkIfUsernamesArePresent());
        softly.assertTrue(loginPage.checkIfPasswordIsPresent());


        ProductsPage productsPage = loginPage.clickLogin(driver);



        softly.assertAll();
    }


}
