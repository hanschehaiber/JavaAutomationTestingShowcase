package com.herokuapp.the_internet;

import com.herokuapp.the_internet.pages.AddRemoveElementPage;
import com.herokuapp.the_internet.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShowcaseTest {

    @Test
    public void addRemoveElementsTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        AddRemoveElementPage addRemoveElementPage = new AddRemoveElementPage(driver);
        driver.get("https://the-internet.herokuapp.com/");
        homePage.clickAddRemoveElements();
        addRemoveElementPage.clickAddElementButton();
        Assert.assertEquals(addRemoveElementPage.countHowManyAddedElements(), 1);

        Thread.sleep(5000);

        driver.quit();
    }
}
