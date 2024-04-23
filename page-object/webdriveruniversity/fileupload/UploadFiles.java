package org.example.pages.webdriveruniversity.fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFiles {

  private WebDriver driver;

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
    return this;
  }

  /**
   * Click on submit button without having file
   *
   * @return UploadFiles
   */
  public UploadFiles submitWithoutFile () {
    driver.findElement(submitButton).submit();
    return this;

  }
}
