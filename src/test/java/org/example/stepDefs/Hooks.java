package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {

 static WebDriver driver;

    @Before
    public void openBrowser()
    {
    //1- Define system.setProperty if needed

    //additional step: ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

    //2- initialize new object
    driver = new ChromeDriver(options);

    //3- Set Browser Configurations
        //3.1- maximize window
        driver.manage().window().maximize();

        //3.2- set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(3));
        driver.quit();

    }

}