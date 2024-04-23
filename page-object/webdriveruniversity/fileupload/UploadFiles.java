package org.example.pages.webdriveruniversity.fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class UploadFiles {

  private WebDriver driver;
  Logger logger = Logger.getLogger(UploadFiles.class.getName());

  public UploadFiles (WebDriver driver) {
    this.driver = driver;
  }

  By submitButton = By.id("submit-button");

  /**
   * Navigate into specific web page
   *
   * @return UploadFiles
   */
  public UploadFiles navigateToPage () {
    driver.navigate().to("https://webdriveruniversity.com/File-Upload/index.html");
    logger.info(driver.getCurrentUrl());
    return this;
  }

  /**
   * Click on submit button without having file
   *
   * @return UploadFiles
   */
  public UploadFiles submitWithoutFile () {
    driver.findElement(submitButton).submit();
    logger.info("Click submit button");
    return this;

  }

  /**
   * Get the page title
   * @return UploadFiles
   */

  public UploadFiles getPageTitle(){
   String title =  driver.getTitle();
    System.out.println(title);
    return this;
  }
}
