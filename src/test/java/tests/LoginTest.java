package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.PropertyManager;

import java.lang.reflect.Method;

public class LoginTest extends BaseTest {

    private String username = PropertyManager.getInstance().getEmail();
    private String password = PropertyManager.getInstance().getPassword();
    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeClass
    public void getCtx(ITestContext ctx){
        driver = (WebDriver) ctx.getAttribute("driver");
    }

    @Test
    public void launch() {
        homePage = new HomePage(driver);

        Log.info("Opening Sample Website for Galen Framework website");
        homePage.goToHomePage();

        Log.info("Verifying homepage is loaded");
        homePage.waitForPageLoaded();

        Log.info("Opening Login page");
        homePage.gotoLoginPage();
    }

    @Test
    public void loginTest(Method method) {
        Log.info(method.getName() + " test is starting.");
        loginPage = new LoginPage(driver);

        Log.info("Verifying login page is loaded");
        loginPage.waitForPageLoaded();

        Log.info("Logging in");
        loginPage.loginToTestApp(username, password);

        Log.info("Verifying successful login");
        loginPage.verfiyTextOnPage("My Notes");
    }
}
