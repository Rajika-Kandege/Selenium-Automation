package org.example.regression;

import org.example.base.BaseTest;
import org.example.pages.homepage.form.Form;
import org.testng.annotations.Test;

import java.time.Duration;

public class FillForm extends BaseTest {


  @Test(groups = "reg")
  public void fillFormAndSubmit () {
    String pathToImage = "/Users/sheng/Downloads/2024.png";
    String address = "Tampines 81";

    driver.get("https://demoqa.com/automation-practice-form");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    Form form = new Form(driver);

    form
            .enterFirstName("sheng")
            .enterLastName("wang")
            .enterEmail("hey@gmail.com")
            .enterGender("Female")
            .enterMobilePhone("98786756")
            .enterDateOfBirth("12 June 2024")
            .enterSubjects("Computer science")
            .enterMusicAsHobby()
            .enterSportsAsHobby()
            .enterReadingAsHobby()
            .uploadPicture(pathToImage)
            .enterCurrentAddress(address)
            .submitForm();
  }
}
