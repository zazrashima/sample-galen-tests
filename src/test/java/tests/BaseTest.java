package tests;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.Log;

public class BaseTest {
    public static WebDriver driver;
    public DriverManager driverManager;

    @BeforeTest
    public void setup() {
        // Write a Log when tests is starting
        Log.startLog("Test is stating!");
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }

    @BeforeClass
    public void storeDriver(ITestContext ctx){
        ctx.setAttribute("driver", driver);
    }

    @AfterSuite
    public void tearDown() {
        Log.endLog("Test is ending!");
        driverManager.quitDriver();
    }
}
