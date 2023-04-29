package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import static org.example.stepDefs.Hooks.driver;

public class signUp {

  public static String globalEmail;
  public static String globalPass;

    @Given("user navigate to home page")
    public void step1()
    {
    driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user go to register page")
    public void step2()
    {
    driver.findElement(By.className("ico-register")).click();
    }


    @When("user select gender")
    public void userSelectGender() {
    driver.findElement(By.id("gender-male")).click();
    }


    @And("user choose date of birth day {string} month {string} year {string}")
    public void userChooseDateOfBirth(String day, String month, String year) {

       WebElement DayList = driver.findElement(By.name("DateOfBirthDay"));
       Select select = new Select(DayList);
       select.selectByValue(day);

       WebElement MonthList = driver.findElement(By.name("DateOfBirthMonth"));
        select = new Select(MonthList);
        select.selectByVisibleText(month);

        WebElement yearList = driver.findElement(By.name("DateOfBirthYear"));
        select = new Select(yearList);
        select.selectByVisibleText(year);

    }

    @And("user enter valid email")
    public void userEnterValidEmail() {

        Faker faker = new Faker();
        globalEmail = faker.internet().emailAddress();
        System.out.println(globalEmail);

        driver.findElement(By.id("Email")).sendKeys(globalEmail);

    }

    @And("mark on Newletters checkbox")
    public void markOnNewlettersCheckbox() {

    }

    @And("user enter password {string} & confirm password {string}")
    public void userEnterPasswordConfirmPassword(String password, String confirmPassword) {
        globalPass = password;
        driver.findElement(By.id("Password")).sendKeys(globalPass);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

    }

    @And("user click on Register btn")
    public void userClickOnRegisterBtn() {
        driver.findElement(By.id("register-button")).click();
    }

    @Then("new account is created successfully")
    public void newAccountIsCreatedSuccessfully() {

        SoftAssert soft = new SoftAssert();

        //1- assert url equal or contains https://demo.nopcommerce.com/registerresult/1?returnUrl=/
    String actualUrl = driver.getCurrentUrl();

    soft.assertTrue(actualUrl.contains("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"),
"actual result : "+actualUrl + "  " + "expected result : " +  "https://demo.nopcommerce.com/registerresult/1?returnUrl=/"
            );

        //2- message content or equal "Your registration completed"
String actualMsg = driver.findElement(By.cssSelector("div[class=\"page-title\"]+div[class=\"page-body\"]>div[class=\"result\"]")).getText();
    soft.assertTrue(actualMsg.contains("Your registration completed"),
    "actualMsg : "+actualMsg + " | " + "expected Msg : "+"Your registration completed"
    );

    //soft.assertTrue(condition, message)
       // condition = actualMsg.contains("Your registration completed")     >> boolean
       // message in case of failure  =  "actualMsg : " + actualMsg + "  " + "expected Msg : "+"Your registration completed"

        //3- message color is green using RGPA or Hex
String actualColorRGPA = driver.findElement(By.cssSelector("div[class=\"page-title\"]+div[class=\"page-body\"]>div[class=\"result\"]")).getCssValue("color");
String actualColorHex  = Color.fromString(actualColorRGPA).asHex();
soft.assertEquals(actualColorHex, "#4cb17c");


        //don't forget assertAll()
        soft.assertAll();

    }


    @And("user enter valid firstname {string} and {string} lastname")
    public void step4(String firstname, String lastname)
    {
        driver.findElement(By.id("FirstName")).sendKeys(firstname);
        driver.findElement(By.id("LastName")).sendKeys(lastname);

    }


}
