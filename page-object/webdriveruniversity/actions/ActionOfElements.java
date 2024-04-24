package org.example.pages.webdriveruniversity.actions;

import org.example.pages.util.ScrollingUpToElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class ActionOfElements {
  private WebDriver driver;
  Logger logger = Logger.getLogger(ActionOfElements.class.getName());

  public ActionOfElements (WebDriver driver) {
    this.driver = driver;
  }

  By sourceElement = By.cssSelector("[id=\"draggable\"]");
  By targetElement = By.id("droppable");
  By doubleClickElement = By.id("double-click");
  By hoverElement = By.xpath("//div[@class='dropdown hover']");
  By bottomElement = By.xpath("//div[@class=\"col-lg-12 text-center\" and  @id='click-box']");


  /**
   * Mouse hover over on an element
   *
   * @return ActionOfElements
   */
  public ActionOfElements hoverOverOnElement () {
    WebElement element = driver.findElement(hoverElement);

    new ScrollingUpToElement(driver).scrollIntoView(element);

    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    logger.info("Hover over on element");
    return this;
  }

  /**
   * Navigate into web page
   *
   * @return
   */
  public ActionOfElements navigateIntoPage () {
    driver.get("https://webdriveruniversity.com/Actions/index.html");
    logger.info("Navigating to page");
    return this;
  }

  /**
   * Drag and Drop elements
   *
   * @return ActionOfElements
   */
  public ActionOfElements dragAndDropElements () {

    try {
      WebElement source = driver.findElement(sourceElement);
      WebElement target = driver.findElement(targetElement);
      Actions actions = new Actions(driver);
      actions.dragAndDrop(source, target).perform();
      logger.info("Drag and drop elements");
    } catch (Exception e) {
      throw new DragAndDropException("Failed to perform the drag and drop due to " + e.getMessage());
    }
    return this;
  }

  /**
   * a custom exception class named DragAndDropException, which inherits from RuntimeException.
   * It has a private constructor that accepts a message parameter and passes it to the constructor
   * of the superclass.
   */

  private class DragAndDropException extends RuntimeException {
    private DragAndDropException (String message) {
      super(message);
    }
  }


  /**
   * Drag and drop elements using multiple methods
   *
   * @return ActionOfElements;
   */
  public ActionOfElements dragAndDropWithMultipleMethods () {

    try {
      WebElement source = driver.findElement(sourceElement);
      WebElement target = driver.findElement(targetElement);
      Actions actions = new Actions(driver);
      actions.clickAndHold(source).moveToElement(target).release().perform();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ;
    logger.info("Drag and drop elements");
    return this;
  }

  /**
   * Get the html source code of the page
   *
   * @return ActionOfElements
   */

  public ActionOfElements getsourceOfPage () {
    String value = driver.getPageSource();
    System.out.println(value);
    return this;

  }

  /**
   * Right click on an element
   *
   * @return ActionOfElements
   */

  public ActionOfElements doubleClickElement () {
    Actions actions = new Actions(driver);
    actions.doubleClick(driver.findElement(doubleClickElement));
    return this;
  }

  /**
   * Click on given element
   *
   * @return ActionOfElements
   * @throws AWTException
   */

  public ActionOfElements clickOnElement () {

    try {
      WebElement element = driver.findElement(bottomElement);
      new ScrollingUpToElement(driver).scrollIntoView(element);
      Actions actions = new Actions(driver);
      actions.clickAndHold(element).perform();
      System.out.println(element.getText());
      actions.release(element).perform();
      System.out.println(element.getText());
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return this;

  }

}
