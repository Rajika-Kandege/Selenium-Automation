package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.simplecontrol.SimpleControl;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleAction extends BaseTest {


  @Test
  public void performActionsInSimpleControlPage () {

    SimpleControl simpleControl = new SimpleControl(driver);

    simpleControl
            .navigateIntoWebPage()
            .selectGenderRadioButton("Male")
            .selectGivenCheckBox("Bike")
            .selectGivenCheckBox("Car")
            .selectValueFromDropDown("Saab")
            .selectTab("Tab 1")
            .getTitleBySalary("$150,000+")
            .getWorkBySalary("$150,000+")
            .clickGivenButtonByActionsClass();

    String successMessage = driver.findElement(By.cssSelector("[class=\"entry-title\"]")).getText();
    Assert.assertEquals(successMessage, "Button success");

  }
}
