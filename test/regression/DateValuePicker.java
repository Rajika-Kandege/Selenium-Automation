package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.webdriveruniversity.datepicker.DatePicker;
import org.testng.annotations.Test;

public class DateValuePicker  extends BaseTest {

  @Test
  public void datePickerActions(){

    DatePicker datePicker = new DatePicker(driver);
    datePicker.navigateToPage().clickInputButton("Oct","23");
  }
}
