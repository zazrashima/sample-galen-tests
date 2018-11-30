package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Log;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        // Write a Log when tests is starting
        Log.startLog("Test is stating!");

        //Create a Chrome driver. All test classes use this.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Maximize Window
        driver.manage().window().maximize();
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() {
        Log.endLog("Test is ending!");
        driver.quit();
    }
}
