package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quit() {
        driver.quit();


    }
}
