package com.candifood.cucumber.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private static WebDriver driver = null;
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webdriver.chrome.driver", "C:\\aniruddh\\installed_software\\google\\chrome_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("searching selenium for testing");
        driver.findElement(By.id("tsf")).submit();
        System.out.println("LogOut Successfully");
        // Close the driver
        //driver.quit();

    }

}