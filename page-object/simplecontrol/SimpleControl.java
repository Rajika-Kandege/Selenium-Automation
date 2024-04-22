package org.example.pages.simplecontrol;

import org.example.pages.util.ScrollingUpToElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class SimpleControl {

  private WebDriver driver;
  private Logger logger = Logger.getLogger(this.getClass().getName());

  public SimpleControl (WebDriver driver) {
    this.driver = driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

  }
  
  By femaleRadioButton = By.xpath("//input[@type=\"radio\" and @value=\"female\"]");
  By maleRadioButton = By.cssSelector("input[value='male']");
  By otherRadioButton = By.cssSelector("input[value='other']");
  By buttonClickSuccessText = By.cssSelector("[class=\"entry-title\"]");
  By radioButtonsHeader = By.xpath("//h4[@class=\"et_pb_module_header\"]//child::span[contains(text(),\"Radio\")]");
  By checkboxDescription = By.xpath("//div[@class=\"et_pb_blurb_description\" and contains(text(),\"Select a checkbox and validate that they are selected\")]");
  By dropDownHeader = By.xpath("//h4[@class=\"et_pb_module_header\" and span[contains(text(),\"Dropdown\")]]");
  By dropDownOptions = By.xpath("//div[@class=\"et_pb_blurb_description\"]//child::select");
  By tabOneLocator = By.xpath("//a[@href=\"#\" and contains(text(),\"Tab 1\")]");
  By tableRowsLocator = By.xpath("//table[@id=\"htmlTableId\"]/tbody/tr");
  By uniqueTableLocator = By.xpath("//h2[contains(text(),\"unique\")]");
  By tableColumnsLocator = By.xpath("//table[@id=\"htmlTableId\"]/tbody/tr/th");
  By buttonLocatorWithClassName = By.className("buttonClass");
  By noUniqueIdTableLocator = By.xpath("//table/tbody/tr/ancestor::div[@class=\"et_pb_text_inner\"]/child::h2[contains(text(),'no')]/following-sibling::table//tr");

  /**
   * Navigate into the given web page
   *
   * @return SimpleControl
   */
  public SimpleControl navigateIntoWebPage () {
    driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
    logger.info("Navigated to the simple-html-elements-for-automation");
    return this;
  }

  /**
   * Select given radio button
   *
   * @param gender - Type of the gender
   * @return SimpleControl
   */

  public SimpleControl selectGenderRadioButton (String gender) {

    WebElement element;
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(radioButtonsHeader));

    if (gender.equals("Female")) {
      element = driver.findElement(femaleRadioButton);
    } else if (gender.equals("Male")) {
      element = driver.findElement(maleRadioButton);
    } else if (gender.equals("Other")) {
      element = driver.findElement(otherRadioButton);
    } else {
      throw new RuntimeException("Invalid gender");
    }
    element.click();
    logger.info("Selected gender: " + gender);
    return this;
  }

  /**
   * Select given checkbox
   *
   * @param checkBoxName - Name of the value attribute in checkbox
   * @return SimpleControl
   */
  public SimpleControl selectGivenCheckBox (String checkBoxName) {
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(checkboxDescription));

    driver.findElement(By.cssSelector("[value='" + checkBoxName + "']")).click();
    logger.info("Selected checkbox: " + checkBoxName);

    return this;
  }

  /**
   * Select value from drop down list
   *
   * @param value - Value of the drop down list
   * @return
   */
  public SimpleControl selectValueFromDropDown (String value) {
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(dropDownHeader));
    Select select = new Select(driver.findElement(dropDownOptions));
    select.selectByVisibleText(value);
    logger.info("Selected value: " + value);
    return this;
  }

  /**
   * Select given tab
   *
   * @param tabName - Name of the tab
   * @return
   */

  public SimpleControl selectTab (String tabName) {

    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(tabOneLocator));
    By tabLocator = By.xpath("//a[@href='#' and contains(text(),'" + tabName + "')]");
    driver.findElement(tabLocator).click();
    logger.info("Selected tab: " + tabName);
    return this;
  }

  /**
   * Retrieve the
   *
   * @param salaryValue
   * @return
   */
  public SimpleControl getTitleBySalary (String salaryValue) {
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(uniqueTableLocator));
    List<WebElement> rows = driver.findElements(tableRowsLocator);
    int rowsSize = rows.size();
    List<WebElement> columns = driver.findElements(tableColumnsLocator);
    int sizeOfColumns = columns.size();
    System.out.println(rowsSize + " " + sizeOfColumns);
    List<WebElement> salaryValues = driver.findElements(By.xpath("//table[@id=\"htmlTableId\"]/tbody/tr/td[3]"));
    for (WebElement salary : salaryValues) {
      if ((salary.getText()).equals(salaryValue)) {
        String title = driver.findElement(By.xpath("//table[@id='htmlTableId']/tbody/tr[td[contains(text(), '" + salaryValue + "')]]/td[1]")).getText();
        System.out.println("Title is " + title);
      }
    }

    return this;
  }

  /**
   * Retrieve work text based on the salary
   *
   * @param salaryValue - Value of the salary
   * @return SimpleControl
   */

  public SimpleControl getWorkBySalary (String salaryValue) {
    new ScrollingUpToElement(driver).scrollIntoView(driver.findElement(noUniqueIdTableLocator));
    String noUniqueTableRowsLocator = "//table/tbody/tr/ancestor::div[@class=\"et_pb_text_inner\"]/child::h2[contains(text(),'no')]/following-sibling::table/tbody/tr[td[contains(text(),'" + salaryValue + "')]]/td[2]";
    String work = driver.findElement(By.xpath(noUniqueTableRowsLocator)).getText();
    System.out.println(work);
    logger.info("Work is " + work);
    return this;
  }
  
  /**
   * Click on given button using click() method in WebElement interface
   * @return SimpleControl
   */

  public SimpleControl clickGivenButton(){
    driver.findElement(buttonLocatorWithClassName).click();
    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(buttonClickSuccessText));
    logger.info("Button clicked successfully");
    return this;
  }

  /**
   * Click on given button using JavaScriptExecutor interface
   * @return SimpleControl
   */

  public SimpleControl clickGivenButtonWithJavaScriptExecutor(){
    WebElement element = driver.findElement(buttonLocatorWithClassName);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",element);
    logger.info("Button clicked successfully");
    return this;
  }

  /**
   * Click on given button using Actions class
   * @return SimpleControl
   */

  public SimpleControl clickGivenButtonByActionsClass(){
    WebElement element = driver.findElement(buttonLocatorWithClassName);
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().perform();
    logger.info("Button clicked successfully");
    return this;
  }


}
