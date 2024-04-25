package org.example.pages.webdriveruniversity.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class DatePicker {
  private WebDriver driver;
  Logger logger = Logger.getLogger(DatePicker.class.getName());

  public DatePicker (WebDriver driver) {
    this.driver = driver;
  }

  By inputIcon = By.cssSelector("[class=\"input-group-addon\"]");
  By datePicker = By.xpath("//input[@class=\"form-control\"]");
  By monthAndYearlocator = By.xpath("//table[@class=\" table-condensed\"]//th[@class=\"datepicker-switch\"]");


  public DatePicker navigateToPage () {
    driver.navigate().to("https://webdriveruniversity.com/Datepicker/index.html");
    return this;
  }

  public DatePicker clickInputButton (String month, String day) {

    String monthPath = "//span[@class=\"month\" and contains(text()," + month + ")]";
    String datePath = "//td[@class=\"day\" and contains(text()," + day + ")]";
    driver.findElement(inputIcon).click();
    driver.findElement(monthAndYearlocator).click();
    driver.findElement(By.xpath(monthPath)).click();
    driver.findElement(By.xpath(datePath)).click();
    String dateValue = driver.findElement(datePicker).getAttribute("value");
    logger.info("Enter date value" + dateValue);
    return this;
  }
}
