package com.saucedemo.tests;

import com.saucedemo.pages.SauceDemoLoginPage;
import org.testng.annotations.Test;


public class PurchasingItemsTest extends TestBase {

    @Test
    public void test() {

        driver.get(prop.getProperty("url"));
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        sauceDemoLoginPage.inputUsername("standard_user");
        sauceDemoLoginPage.inputPassword("secret_sauce");
        sauceDemoLoginPage.clickLogin(driver);

    }


}
