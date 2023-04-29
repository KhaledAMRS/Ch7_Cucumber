package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.example.stepDefs.Hooks.driver;

public class login {
    @And("user go to login page")
    public void step1()
    {
    driver.findElement(By.className("ico-login")).click();

    }


    @When("user enter valid email and password in login page")
    public void userEnterValidEmailAndPasswordInLoginPage() {

    driver.findElement(By.id("Email")).sendKeys(signUp.globalEmail);
    driver.findElement(By.id("Password")).sendKeys(signUp.globalPass);

    }

    @And("user click on loginBtn")
    public void userClickOnLoginBtn() {
        driver.findElement(By.className("login-button")).click();
    }
}
