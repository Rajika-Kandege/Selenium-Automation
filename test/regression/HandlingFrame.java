package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.webdriveruniversity.HomePageAlerts;
import org.example.pages.webdriveruniversity.iframe.IFrameHandling;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlerts extends BaseTest {


  @Test
  public void handleAlertsPerform(){


    HomePageAlerts homePageAlerts = new HomePageAlerts(driver);
    homePageAlerts.navigateToMainPage()
            .clickIframeLink();
    IFrameHandling iFrameHandling = new IFrameHandling(driver);
    iFrameHandling.switchToFrame();

    String sectionTileXpath = "//p[@class=\"sub-heading\" and contains(text(),'Who')]";
    String actualTitle = driver.findElement(By.xpath(sectionTileXpath)).getText();
    Assert.assertEquals(actualTitle,"Who Are We?");

  }
}
