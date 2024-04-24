package org.example.pages.webdriveruniversity.browserinfo;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

public class BrowserInformation {

  private WebDriver driver;

  public BrowserInformation (WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Get thr browser details
   *
   * @return BrowserInformation
   */

  public BrowserInformation getBrowserDetails () {
    driver.get("https://webdriveruniversity.com/");
    Capabilities capabilities = ((org.openqa.selenium.remote.RemoteWebDriver) driver).getCapabilities();

    String browser = capabilities.getBrowserName();
    String version = capabilities.getBrowserVersion();
    Platform platform = capabilities.getPlatformName();
    int platformVersion = platform.getMajorVersion();
    System.out.println(browser + "and  " + version + " and " + platformVersion);

    return this;
  }
}
