package org.example.pages.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollingUpToElement {

  private WebDriver driver;

  public ScrollingUpToElement(WebDriver driver){
    this.driver = driver;
  }

  /**
   * Common method for scroll into view
   *
   * @param element - Weblement scroll into view
   */

  public ScrollingUpToElement scrollIntoView(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    return this;
  }
}
