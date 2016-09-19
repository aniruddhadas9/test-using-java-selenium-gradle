package com.candifood.cucumber.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ServiceabilityTest {

    private static WebDriver driver = null;

    @BeforeClass
    public static void setupTesting() {
        System.setProperty("webdriver.chrome.driver", "C:\\aniruddh\\installed_software\\google\\chrome_driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Before
    public void setup() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loadWidget() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:9090/EinsteinSalesConsumer/");
        driver.findElement(By.name("CallWidget")).click();

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("data")));

        driver.findElement(By.id("data")).sendKeys("{\"userId\": \"gsglobalint\"}");
        driver.findElement(By.name("CallWidget")).click();

        driver.findElement(By.id("auto-complete-address")).sendKeys("3939 monroe ave 111111");
        driver.findElement(By.id("auto-complete-unit")).sendKeys("220");
        driver.findElement(By.id("device_zip")).sendKeys("94536");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkAvailabilityButton")));
        driver.findElement(By.id("checkAvailabilityButton")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-1")));

        if(driver.findElement(By.id("device_zip")).getText()!="") {
            System.out.println("I am able to see the error|warning|success message.");
        }



    }

    @After
    public void tearDown(){
        //driver.close();
    }
}
