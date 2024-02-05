package com.saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    protected static Properties prop;

    public TestBase() {
        try {
            String propertyFilePath = "src/main/java/com/saucedemo/config/config.properties";
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            prop = new Properties();
            prop.load(inputStream);
        } catch (IOException notFoundException) {
            notFoundException.printStackTrace();
        }
    }

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
