package com.saucedemo;

import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends TestBase {

    @Test
    public void testLockedOutUser() {
        String userName = "locked_out_user";
        String password = "secret_sauce";

        driver.get(prop.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(userName);
        loginPage.inputPassword(password);
        Assert.assertFalse(loginPage.checkIfErrorMessageIsDisplayed());
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.checkIfErrorMessageIsDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.");

    }

}
