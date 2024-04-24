package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.webdriveruniversity.actions.ActionOfElements;
import org.testng.annotations.Test;

import java.awt.*;

public class MultipleActions extends BaseTest {


  @Test
  public void useRobotMethod () throws AWTException {
    ActionOfElements actionOfElements = new ActionOfElements(driver);
    actionOfElements.navigateIntoPage().clickOnElement();

  }

  @Test
  public void performHoverOverElement () {
    ActionOfElements actionOfElements = new ActionOfElements(driver);
    actionOfElements.hoverOverOnElement();
  }

  @Test(priority = 1)
  public void performGetPageSource () {
    ActionOfElements actionOfElements = new ActionOfElements(driver);

    actionOfElements.navigateIntoPage().getsourceOfPage();
  }

  @Test(priority = 3)
  public void performDragAndDrop () {
    ActionOfElements actionOfElements = new ActionOfElements(driver);

    actionOfElements.navigateIntoPage().dragAndDropElements();
  }

  @Test
  public void performDragAndDropMultipleMethods () {
    ActionOfElements actionOfElements = new ActionOfElements(driver);

    actionOfElements.navigateIntoPage().dragAndDropWithMultipleMethods();
  }

  @Test
  public void performDoubleClick () {
    ActionOfElements actionOfElements = new ActionOfElements(driver);
    actionOfElements.navigateIntoPage().doubleClickElement();
  }

}
