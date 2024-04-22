package org.example.pages.webdriveruniversity;

import org.example.pages.util.ScrollingUpToElement;
import org.example.pages.webdriveruniversity.handlingAlerts.HandleAlerts;
import org.example.pages.webdriveruniversity.iframe.IFrameHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.logging.Logger;

public class HomePageAlerts {

  private WebDriver driver;
  Logger logger = Logger.getLogger(HomePageAlerts.class.getName());

  public HomePageAlerts (WebDriver driver) {
    this.driver = driver;

  }

  By popupAlertLocator = By.xpath("//div[@class=\"section-title\"]/h1[contains(text(),'POPUP')]");
  By alertPopUpLinkLocator = By.xpath("//div[@class=\"caption\"]/h4[contains(text(),'Close those annoying Popup & Alerts!')]");
  String url = "https://webdriveruniversity.com/index.html";
  By iframeLocator = By.xpath("//div[@class=\"section-title\"]/h1[contains(text(),'IFRAME')]");
  By iframeDescription = By.xpath("//div[@class=\"caption\"]/h4[contains(text(),'Practise with inline frame(s)')]/ancestor::a[@id='iframe']");

  /**
   * Navigate into the main page
   *
   * @return
   */
  public HomePageAlerts navigateToMainPage () {
    driver.get(url);
    logger.info("Navigated to main page");
    return this;
  }

  /**
   * Click on Pop up Alert Header
   *
   * @return HandleAlerts
   */
  public HandleAlerts clickOnPopUpAlertHeader () {
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(popupAlertLocator));
    driver.findElement(alertPopUpLinkLocator).click();
    switchToNewTab();
    return new HandleAlerts(driver);
  }

  /**
   * Switch into the required tab
   */

  private void switchToNewTab () {

    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(2));
    Set<String> windowHandles = driver.getWindowHandles();
    for (String handle : windowHandles) {
      driver.switchTo().window(handle);
      String currentUrl = driver.getCurrentUrl();
      if (!currentUrl.equals(url)) {
        break;
      }
    }
  }

  /**
   * Click on iframe link
   *
   * @return IFrameHandling
   */

  public IFrameHandling clickIframeLink () {
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(iframeLocator));
    driver.findElement(iframeDescription).click();
    switchToNewTab();
    return new IFrameHandling(driver);
  }

}
