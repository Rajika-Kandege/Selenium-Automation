package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.webdriveruniversity.fileupload.UploadFiles;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {

  @Test
  public void fileUpload() {

    UploadFiles uploadFiles = new UploadFiles(driver);
    uploadFiles.navigateToPage().submitWithoutFile();

  }
}
