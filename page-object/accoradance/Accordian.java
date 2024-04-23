package org.example.pages.webdriveruniversity.accordance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Accordian {

  private WebDriver driver;
  Logger logger = Logger.getLogger(Accordian.class.getName());

  public Accordian (WebDriver driver) {
    this.driver = driver;
  }

  By manualTestingLocator = By.id("manual-testing-accordion");
  String url = "https://webdriveruniversity.com/Accordion/index.html";
  By manualTestingDescriptionLocator = By.id("manual-testing-description");

  /**
   * Navigate into the web page
   *
   * @return Accordian
   */
  public Accordian navigateIntoPage () {
    driver.get(url);
    logger.info("Navigated to Accordion page");
    return this;
  }

  /**
   * CLick on given link
   *
   * @return Accordian
   */
  public Accordian clickManualTestingLink () {
    driver.findElement(manualTestingLocator).click();
    WebElement description = driver.findElement(manualTestingDescriptionLocator);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(description));
    logger.info("Clicked manual testing link");
    return this;
  }
}
