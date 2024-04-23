package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.webdriveruniversity.accordance.Accordian;
import org.testng.annotations.Test;

public class AccordianTest extends BaseTest {


  @Test
  public void performAccodianTest(){

    Accordian accordian  = new Accordian(driver);
    accordian.navigateIntoPage().clickManualTestingLink();

  }
}
