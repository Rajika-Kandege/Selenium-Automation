package org.example.pages.webdriveruniversity.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFrameHandling {

  private WebDriver driver;

  public IFrameHandling (WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Switch to ifrmae
   *
   * @return IFrameHandling
   */

  public IFrameHandling switchToFrame () {
    driver.switchTo().frame("frame");
    return this;
  }

  /**
   * Click Home link in the frame
   *
   * @return IFrameHandling
   */

  public IFrameHandling clickHomeLink () {
    String path = "//a[@href='index.html']";
    driver.findElement(By.xpath(path)).click();
    return this;
  }
}
