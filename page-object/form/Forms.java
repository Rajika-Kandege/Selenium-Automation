package org.example.pages.homepage.form;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {


    private WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(Form.class);


    By firstNameLocator = By.cssSelector("input[placeholder=\"First Name\"]");
    By lastNameLocator = By.id("lastName");
    By emailLocator = By.xpath("//div[@class=\"mt-2 row\"]//following::input[@id=\"userEmail\"]");
    By maleGenderLocator = By.id("gender-radio-1");
    By femaleGenderLocator = By.id("gender-radio-2");
    By otherGenderLocator = By.id("gender-radio-3");
    By mobilePhoneLocator = By.id("userNumber");
    By dateOfBirthLocator = By.id("dateOfBirthInput");
    By subjectsLocator = By.xpath("//input[@id=\"subjectsInput\"]");
    By sportsLocator = By.id("hobbies-checkbox-1");
    By readingLocator = By.id("hobbies-checkbox-2");
    By musicLocator = By.id("hobbies-checkbox-3");
    By fileUploadLocator = By.id("uploadPicture");
    By currentAddressLocator = By.cssSelector("textarea[placeholder=\"Current Address\"]");

    public Form(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Common method for scroll into view
     *
     * @param element - Weblement scroll into view
     */

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Enter First name into input field
     *
     * @param firstName - First name of the person
     * @return Form
     */
    public Form enterFirstName(String firstName) {

        driver.findElement(firstNameLocator).sendKeys(firstName);
        logger.info("Entered First Name" + firstName);
        return this;
    }

    /**
     * Enter last name into input field
     *
     * @param lastName - Last name of the person
     * @return Form
     */
    public Form enterLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
        logger.info("Entered Last Name" + lastName);
        return this;
    }

    /**
     * Enter email into input field
     *
     * @param email - Email id of the person
     * @return Form
     */

    public Form enterEmail(String email) {

        driver.findElement(emailLocator).sendKeys(email);
        logger.info("Entered Email" + email);
        return this;

    }

    /**
     * Select radion button for the gender
     *
     * @param gender - Value should be Male , Female or Other
     * @return Form
     */

    public Form enterGender(String gender) {

        WebElement element;
        if (gender.equals("Male")) {
            element = driver.findElement(maleGenderLocator);
        } else if (gender.equals("Female")) {
            element = driver.findElement(femaleGenderLocator);

        } else if (gender.equals("Other")) {
            element = driver.findElement(otherGenderLocator);
        } else {
            throw new IllegalArgumentException("Invalid gender : Value should be Male, Female or Other");
        }

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;


        javascriptExecutor.executeScript("arguments[0].click();", element);

        //  element.click();
        logger.info("Entered Gender" + gender);

        return this;
    }

    /**
     * Enter mobile phone number into text field
     *
     * @param mobilePhone - Mobile phone number
     * @return Form
     */
    public Form enterMobilePhone(String mobilePhone) {
        driver.findElement(mobilePhoneLocator).sendKeys(mobilePhone);
        logger.info("Entered Mobile Phone" + mobilePhone);
        return this;
    }

    /**
     * Enter Date of birth into input field
     *
     * @param dateOfBirth - Date of birth value
     * @return Form
     */
    public Form enterDateOfBirth(String dateOfBirth) {

        driver.findElement(dateOfBirthLocator).sendKeys(dateOfBirth);

        logger.info("Entered Date Of Birth" + dateOfBirth);
        return this;
    }

    /**
     * Enter Subjects into input filed
     *
     * @param subjects - Subjects values
     * @return Form
     */

    public Form enterSubjects(String subjects) {
        driver.findElement(subjectsLocator).sendKeys(subjects);
        logger.info("Entered Subjects" + subjects);
        return this;
    }

    /**
     * Select sports as hobby
     *
     * @return Form
     */

    public Form enterSportsAsHobby() {
        WebElement element = driver.findElement(sportsLocator);
        scrollIntoView(element);
        element.click();
        logger.info("Entered Sports AsHobby");
        return this;
    }

    /**
     * Select reading as hobby
     *
     * @return Form
     */

    public Form enterReadingAsHobby() {
        WebElement element = driver.findElement(readingLocator);
        scrollIntoView(element);
        element.click();
        logger.info("Entered Reading AsHobby");
        return this;
    }

    /**
     * Select music as hobby
     *
     * @return Form
     */

    public Form enterMusicAsHobby() {
        WebElement element = driver.findElement(musicLocator);
        scrollIntoView(element);
        element.click();
        logger.info("Entered Music AsHobby");
        return this;
    }

    /**
     * Upload a file from given machine
     *
     * @param path - Absolute path of the given image
     * @return Form
     */

    public Form uploadPicture(String path) {
        WebElement element = driver.findElement(fileUploadLocator);
        scrollIntoView(element);
        element.sendKeys(path);
        logger.info("Upload a  Picture");
        return this;
    }

    /**
     * Enter current address into text field
     *
     * @param address - Current address value
     * @return Form
     */

    public Form enterCurrentAddress(String address) {
        WebElement element = driver.findElement(currentAddressLocator);
        scrollIntoView(element);
        element.sendKeys(address);
        logger.info("Entered Current Address");
        return this;
    }


    /**
     * Submit the form
     *
     * @return Form
     */

    public Form submitForm() {

        WebElement element = driver.findElement(By.id("submit"));
        scrollIntoView(element);
        element.click();
        return this;
    }
}
