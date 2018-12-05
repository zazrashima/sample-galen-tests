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
    @Parameters("browser")
    public void setup(String browser) {
        // Write a Log when tests is starting
        Log.startLog("Test is stating!");

        if (browser.equalsIgnoreCase("chrome")) {
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        }
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
