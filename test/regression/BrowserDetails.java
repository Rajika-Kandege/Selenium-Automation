package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.webdriveruniversity.browserinfo.BrowserInformation;
import org.testng.annotations.Test;

public class BrowserDetails extends BaseTest {

  @Test
  public void getDetails(){

    BrowserInformation browserInformation = new BrowserInformation(driver);

    browserInformation.getBrowserDetails();
  }
}
