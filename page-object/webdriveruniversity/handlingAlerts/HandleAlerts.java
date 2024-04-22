package org.example.pages.webdriveruniversity.handlingAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlerts {

  private WebDriver driver;

  public HandleAlerts (WebDriver driver) {
    this.driver = driver;
  }

  By javascriptAlert = By.id("button1");
  By confirmAlert = By.id("button4");
  By modelPopUp = By.id("button2");
  By closeButtonModelPopUp = By.xpath("//button[@type=\"button\" and contains(text(),'Close')]");

  /**
   * Accept javascript alert
   *
   * @return HandleAlerts
   */
  public HandleAlerts acceptJavaScriptAlert () {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(javascriptAlert));
    driver.findElement(javascriptAlert).click();
    driver.switchTo().alert().accept();
    return this;
  }

  /**
   * Dismiss the confirm alert
   *
   * @return HandleAlerts
   */

  public HandleAlerts dismissConfirmAlert () {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(confirmAlert));
    driver.findElement(confirmAlert).click();
    driver.switchTo().alert().dismiss();
    return this;
  }

  /**
   * Accept the confirm alert
   *
   * @return HandleAlerts
   */

  public HandleAlerts acceptConfirmAlert () {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(confirmAlert));
    driver.findElement(confirmAlert).click();
    driver.switchTo().alert().accept();
    return this;
  }

  /**
   * Accept the confirm alert
   *
   * @return HandleAlerts
   */

  public HandleAlerts closeModelPopUp () {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(modelPopUp));
    driver.findElement(modelPopUp).click();
    driver.switchTo().activeElement().findElement(closeButtonModelPopUp).click();
    String value = driver.findElement(closeButtonModelPopUp).getText();
    System.out.println(value);
    return this;
  }
}
